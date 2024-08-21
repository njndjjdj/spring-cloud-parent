package com.zyc.controller;

import com.zyc.utils.R;
import com.zyc.service.StudentService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
@RestController("studentController")
@RequestMapping("/student")
@RefreshScope
public class StudentController {

    @Resource
    private StudentService studentService;

    @GetMapping("/findAllStudent")
    public R findAllStudent() {
        return R.ok().data("studentList", studentService.list());
    }

}
