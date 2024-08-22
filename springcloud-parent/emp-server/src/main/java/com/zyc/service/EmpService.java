package com.zyc.service;

import com.zyc.entity.Emp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyc.utils.R;

/**
* @author Admin
* @description 针对表【emp】的数据库操作Service
* @createDate 2024-08-21 17:15:43
*/
public interface EmpService extends IService<Emp> {

    R findStudentBySid();
}
