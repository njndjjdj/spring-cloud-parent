package com.zyc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyc.entity.Classes;
import com.zyc.service.ClassesService;
import com.zyc.mapper.ClassesMapper;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【classes】的数据库操作Service实现
* @createDate 2024-08-21 16:24:55
*/
@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes>
    implements ClassesService{

}




