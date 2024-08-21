package com.zyc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyc.entity.Work;
import com.zyc.service.WorkService;
import com.zyc.mapper.WorkMapper;
import org.springframework.stereotype.Service;

/**
* @author Admin
* @description 针对表【work】的数据库操作Service实现
* @createDate 2024-08-21 17:15:43
*/
@Service
public class WorkServiceImpl extends ServiceImpl<WorkMapper, Work>
    implements WorkService{

}




