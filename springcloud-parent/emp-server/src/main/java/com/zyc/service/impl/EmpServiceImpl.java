package com.zyc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyc.entity.Emp;
import com.zyc.service.EmpService;
import com.zyc.mapper.EmpMapper;
import com.zyc.utils.R;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Admin
 * @description 针对表【emp】的数据库操作Service实现
 * @createDate 2024-08-21 17:15:43
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp>
        implements EmpService {

    @Resource
    private RestTemplate restTemplate;

    /**
     * 使用RestTemplate调用外部服务
     *
     * @return
     */
    @Override
    public R findStudentBySid() {
        String url = "http://student-server/student/findAllStudent";

        ResponseEntity<R> response = restTemplate.exchange(url, HttpMethod.GET, null, R.class);
        return response.getBody();
    }
}




