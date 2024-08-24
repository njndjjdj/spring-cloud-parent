package com.zyc.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Map;

public class JwtUtil {

	private static final String SECRET = "HZIT";
	/**
	 * 从数据声明生成令牌
	 *
	 * @param claims 数据声明
	 * @return 令牌
	 */
	public static String createToken(Map<String, Object> claims)
	{
		String token = Jwts.builder().setClaims(claims)
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		return token;
	}
	/**
	 * 从令牌中获取数据声明
	 *
	 * @param token 令牌
	 * @return 数据声明
	 */
	public static Claims parseToken(String token)
	{
		return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
	}
}