package com.zyc.controller;

import com.zyc.anno.RequiresPromissions;
import com.zyc.dto.StudentDTO;
import com.zyc.utils.R;
import com.zyc.service.StudentService;
import com.zyc.vo.SearchVO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Value("${server.port}")
    private String port;

    /**
     * 查询所有学生
     *
     * @return
     */
    @RequiresPromissions(value = "student:findAllStudent")
    @GetMapping("/findAllStudent")
    public R findAllStudent() {
        return R.ok().data("studentList", studentService.list()).data("port", port);
    }

    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @param vo
     * @return
     */
    @PostMapping("/findStudentByPage/{page}/{pageSize}")
    public R findStudentByPage(
            @PathVariable("page") int page,
            @PathVariable("pageSize") int pageSize,
            @RequestBody SearchVO vo) {
        List<StudentDTO> list = studentService.findStudentByPage(page, pageSize, vo);
        return R.ok().data("list", list);
    }

}
