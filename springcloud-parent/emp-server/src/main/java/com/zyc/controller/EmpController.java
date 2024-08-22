package com.zyc.controller;

import com.zyc.client.StudentClient;
import com.zyc.utils.R;
import com.zyc.service.EmpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RestController("empController")
@RequestMapping("/emp")
@RefreshScope
@Api(tags = "员工相关接口")
public class EmpController {

    @Resource
    private EmpService empService;

    @ApiOperation("查询所有员工")
    @GetMapping("/findAllEmp")
    public R findAllEmp() {
        return R.ok().data("empList", empService.list());
    }

    /**
     * 调用student-server的方法
     */
    /**
     * 方式一，通过的openfeign的client方式
     */
    @Resource
    private StudentClient studentClient;

    @ApiOperation("查询所有学生：通过的openfeign的client方式")
    @GetMapping("/getAllStudent")
    public R getAllStudent() {
        return studentClient.findAllStudent();
    }

    // 查询学生 (使用RestTemplate调用)
    @ApiOperation("查询所有学生：使用RestTemplate调用")
    @GetMapping("/getAllStudent2")
    public R findById2(){
        R r = empService.findStudentBySid();
        return  r;

    }
}
