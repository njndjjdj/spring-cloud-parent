package com.zyc.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * 作者:ZYC
 * DATE:2024/8/22
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */
// @Configuration
// public class MySwaggerConfig {
//     @org.springframework.context.annotation.Bean
//     public Docket docketApiInfo(){
//         return new Docket(DocumentationType.SWAGGER_2)
//                 .apiInfo(apiInfo())
//                 .groupName("api组")
//                 .select()
//                 .paths(Predicates.and(PathSelectors.regex("/emp/.*")))
//                 .build();
//     }
//
//     /**
//      * 1. 定制前端开发接口信息
//      * @return
//      */
//     private ApiInfo apiInfo() {
//         return new ApiInfoBuilder()
//                 .version("1.0.0")
//                 .title("后台管理系统-API文档")
//                 .description("本文档描述了后台管理系统接口")
//                 .contact(new Contact("合众后台","http://hzitxx.com","23232444@qq.com"))
//                 .build();
//     }
// }
