package com.zyc.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 作者:ZYC
 * DATE:2024/8/26
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */
@Data
public class SearchVO {

    private String stuno;

    /**
     *
     */
    private String stuname;

    /**
     *
     */
    private String classno;

    /**
     *
     */
    private String sex;

    /**
     *
     */
    private Integer age;

    /**
     *
     */
    private String classname;
}
