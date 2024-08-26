package com.zyc.service;

import com.zyc.dto.StudentDTO;
import com.zyc.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zyc.vo.SearchVO;

import java.util.List;

/**
* @author Admin
* @description 针对表【student】的数据库操作Service
* @createDate 2024-08-21 16:24:55
*/
public interface StudentService extends IService<Student> {

    /**
     * 分页带参数查询
     * @param page
     * @param pageSize
     * @param vo
     * @return
     */
    List<StudentDTO> findStudentByPage(int page, int pageSize, SearchVO vo);
}
