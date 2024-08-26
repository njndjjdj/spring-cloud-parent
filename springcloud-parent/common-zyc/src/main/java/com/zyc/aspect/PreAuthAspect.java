package com.zyc.aspect;

import com.alibaba.fastjson.JSON;
import com.zyc.anno.RequiresPromissions;
import com.zyc.constant.MyConstant;
import com.zyc.entity.LoginUser;
import com.zyc.enums.Logical;
import com.zyc.excep.NotPermissionException;
import com.zyc.utils.JwtUtil;
import com.zyc.utils.ResponseEnum;
import io.jsonwebtoken.Claims;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * 作者:ZYC
 * DATE:2024/8/26
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */
@Aspect
@Component
public class PreAuthAspect {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 环绕通知
     *
     * @param joinPoint
     * @param requiresPromissions
     * @return
     * @throws Throwable
     */
    @Around("@annotation(requiresPromissions)")
    public Object innerAround(ProceedingJoinPoint joinPoint, RequiresPromissions requiresPromissions) throws Throwable {
        // 得到方法上的权限列表
        String[] myMethodPermissions = requiresPromissions.value();
        // 得到方法山东个逻辑表达
        Logical logical = requiresPromissions.logical();
        // 得到当前用户的权限列表
        List<String> permissionList = getPermissionsByToken();
        // 判断方法前的注解中的权限串是否在上面的权限串列表中
        Boolean hasPromiss = isExistPersion(myMethodPermissions, permissionList, logical);
        if (!hasPromiss) {
            throw new NotPermissionException(ResponseEnum.NOT_PERMISSION_ERROR.getMessage());
        }
        return joinPoint.proceed();
    }

    /**
     * 判断方法前的注解中的权限串是否在上面的权限串列表中
     *
     * @param myMethodPermissions
     * @param permissionList
     * @param logical
     */
    private Boolean isExistPersion(String[] myMethodPermissions, List<String> permissionList, Logical logical) {
        // 使用Logical.AND逻辑，检查所有权限是否都存在于列表中
        if (logical == Logical.OR) {
            return Arrays.stream(myMethodPermissions).anyMatch(permissionList::contains);
        }
        // 使用Logical.AND逻辑，检查所有权限是否都存在于列表中
        if (logical == Logical.AND) {
            return Arrays.stream(myMethodPermissions).allMatch(permissionList::contains);
        }
        // 如果logical既不是AND也不是OR，返回false或抛出异常
        throw new NotPermissionException(ResponseEnum.NOT_PERMISSION_ERROR.getMessage());
    }

    /**
     * 得到当前用户的权限列表
     *
     * @return
     */
    private List<String> getPermissionsByToken() {
        // 获取请求对象
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        // 得到token的值
        String authorization = request.getHeader(MyConstant.AUTHORIZATION);
        String token = authorization.replace(MyConstant.BEARER, "");
        // 解析token
        Claims claims = JwtUtil.parseToken(token);
        // 获得uuid
        String uuid = claims.get(MyConstant.USER_KEY) + "";
        // 得到redis的key值
        String key = MyConstant.LOGIN_TOKEN + uuid;
        // 查询redis中的用户
        String loginUserStr = stringRedisTemplate.opsForValue().get(key);
        if (loginUserStr == null) {
            throw new NotPermissionException(ResponseEnum.NOT_PERMISSION_ERROR.getMessage());
        }
        // 转为java对象
        LoginUser loginUser = JSON.parseObject(loginUserStr, LoginUser.class);
        return loginUser.getPermissions();
    }
}
