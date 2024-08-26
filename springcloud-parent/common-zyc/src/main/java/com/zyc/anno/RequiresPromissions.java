package com.zyc.anno;

import com.zyc.enums.Logical;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者:ZYC
 * DATE:2024/8/26
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:自定义注解，用于判断用户是否有访问该接口的权限
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE })
public @interface RequiresPromissions
{
    /**
     * 需要校验的权限码
     */
    String[] value() default {};

    /**
     * 验证模式：AND | OR，默认AND
     */
    Logical logical() default Logical.AND;
}
