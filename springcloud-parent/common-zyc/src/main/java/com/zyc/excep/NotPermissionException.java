package com.zyc.excep;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者:ZYC
 * DATE:2024/8/26
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use: 自定义无权访问异常
 */
@Data
@NoArgsConstructor
public class NotPermissionException extends RuntimeException {
    private String message;

    public NotPermissionException(String message) {
        super(message);
        this.message = message;
    }

}