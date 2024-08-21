package com.zyc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyc.entity.Dept;
import com.zyc.service.DeptService;
import com.zyc.mapper.DeptMapper;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【dept】的数据库操作Service实现
* @createDate 2024-08-21 17:15:43
*/
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept>
    implements DeptService{

}




