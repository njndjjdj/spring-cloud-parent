package com.zyc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyc.entity.Student;
import com.zyc.service.StudentService;
import com.zyc.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【student】的数据库操作Service实现
* @createDate 2024-08-21 16:24:55
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

}




