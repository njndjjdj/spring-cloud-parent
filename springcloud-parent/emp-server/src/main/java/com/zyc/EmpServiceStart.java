package com.zyc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

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
@EnableFeignClients("com.zyc.client") // 开启openfeign
@SpringBootApplication
public class EmpServiceStart {
    public static void main(String[] args) {
        SpringApplication.run(EmpServiceStart.class, args);
    }

    @Bean
    @LoadBalanced       // 此注解要配合spring-cloud-starter-loadbalancer这个依赖才能起作用
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
