package com.zyc.mapper;

import com.zyc.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ZYC帅哥
 * @since 2024-08-23
 */
public interface UserMapper extends BaseMapper<User> {

    List<String> selectPermissionByUsername(@Param("username") String username);
}
