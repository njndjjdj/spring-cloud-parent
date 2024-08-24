package com.zyc.service;

import com.zyc.entity.LoginUser;
import com.zyc.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ZYC帅哥
 * @since 2024-08-23
 */
public interface IUserService extends IService<User> {

    LoginUser login(User user);
}
