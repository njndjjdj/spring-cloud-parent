package com.zyc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyc.entity.Emp;
import com.zyc.service.EmpService;
import com.zyc.mapper.EmpMapper;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【emp】的数据库操作Service实现
* @createDate 2024-08-21 17:15:43
*/
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp>
    implements EmpService{

}




