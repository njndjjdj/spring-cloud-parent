package com.zyc.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class LoginUser implements Serializable {
	private String userId;
	private User user;
	private List<Permission> permissions;       // 根据用户id查询出的用户的权限列表
}