package com.zyc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

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
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ZycGatewayStart {
    public static void main(String[] args) {
        SpringApplication.run(ZycGatewayStart.class);
    }
}
