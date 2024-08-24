package com.zyc.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 作者:ZYC
 * DATE:2024/8/21
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */
// @Configuration
// @MapperScan("com.zyc.mapper")
// public class MyBatisConfig {
//     @Bean
//     public MybatisPlusInterceptor mybatisPlusInterceptor(){
//         MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
//         mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
//         mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
//         return mybatisPlusInterceptor;
//     }
// }
