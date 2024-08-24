package com.zyc.service.impl;

import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zyc.entity.LoginUser;
import com.zyc.entity.User;
import com.zyc.mapper.UserMapper;
import com.zyc.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ZYC帅哥
 * @since 2024-08-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public LoginUser login(User user) {
        if (user == null || user.getUsername() == null || user.getPassword() == null) {
            throw new RuntimeException("用户名和密码不能为空");
        }
        User dbUser = userMapper.selectOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        if (dbUser == null) {
            throw new RuntimeException("该用户不存在");
        }
        if (!SecureUtil.md5(user.getPassword()).equals(dbUser.getPassword())) {
            throw new RuntimeException("同户名或密码错误");
        }
        LoginUser loginUser = new LoginUser();
        loginUser.setUserId(dbUser.getId());
        loginUser.setUser(dbUser);
        // todo 后续存入该用户的权限列表

        return loginUser;
    }
}
