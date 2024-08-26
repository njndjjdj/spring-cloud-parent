package com.zyc.service.impl;


import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import com.zyc.constant.MyConstant;
import com.zyc.entity.LoginUser;
import com.zyc.service.ITokenService;
import com.zyc.utils.JwtUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 作者:ZYC
 * DATE:2024/8/23
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */
@Service("tokenServiceImpl")
public class TokenServiceImpl implements ITokenService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Map<String, Object> createToken(LoginUser loginUser) {
        // 封装token信息
        HashMap<String, Object> climas = new HashMap<>();
        climas.put("userId", loginUser.getUserId());
        climas.put("username", loginUser.getUser().getUsername());
        String uuid = UUID.randomUUID().toString().replace("-", "");
        climas.put("user_key", uuid);
        // 生成token
        String token = JwtUtil.createToken(climas);
        // 封装要返回的token
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", token);
        // 将登陆信息保存到redis中
        stringRedisTemplate.opsForValue().set(MyConstant.LOGIN_TOKEN + uuid, JSON.toJSONString(loginUser), 1, TimeUnit.DAYS);
        return map;
    }

}
