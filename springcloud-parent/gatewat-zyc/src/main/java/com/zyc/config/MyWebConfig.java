package com.zyc.config;

import org.springframework.boot.type.classreading.ConcurrentReferenceCachingMetadataReaderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * 作者:ZYC
 * DATE:2024/8/23
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:允许跨域访问
*/
@Configuration
public class MyWebConfig {
	@Bean
	public CorsWebFilter corsWebFilter(){
		UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.addAllowedHeader("*");   // 放行所有请求求
		config.addAllowedMethod("*");   // 放行所有方法
		config.addAllowedOrigin("*");   // 请允许许行的地址
		config.setAllowCredentials(true); // 请允许使用cookie
		configSource.registerCorsConfiguration("/**",config);
		CorsWebFilter corsWebFilter = new CorsWebFilter(configSource);
		return corsWebFilter;
	}
}