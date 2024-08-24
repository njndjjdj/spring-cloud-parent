package com.zyc.controller;

import com.zyc.entity.LoginUser;
import com.zyc.entity.User;
import com.zyc.service.ITokenService;
import com.zyc.service.IUserService;
import com.zyc.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

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
@RestController
@RequestMapping("/auth")
@Api(tags = "管理员后端接口")
public class AdminController {

    @Resource
    private IUserService userService;
    @Resource
    private ITokenService tokenService;

    @PostMapping("/login")
    @ApiOperation("管理员登录")
    public R login(@ApiParam(value = "用户", required = true)@RequestBody User user) {
        // 获取登录用户对象
        LoginUser loginUser = userService.login(user);
        // 封装token
        Map<String, Object> map = tokenService.createToken(loginUser);
        return R.ok().data(map);
    }
}
