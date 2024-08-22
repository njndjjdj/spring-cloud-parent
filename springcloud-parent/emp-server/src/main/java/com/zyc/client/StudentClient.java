package com.zyc.client;

import com.zyc.client.impl.StudentClientImpl;
import com.zyc.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 作者:ZYC
 * DATE:2024/8/22
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use:
 */

/**
 * value指定微服务的名称，其作用与name一致
 * 1、熔断方式一
 * fallback 设置熔断策略，当student-sever挂了的时候不会影响到sem-server，并且起到提示的作用
 * 2、熔断方式二
 * fallbackFactory ，使用工厂进行统一处理
 *
 * 同时openfeign还有负载均衡的作用，默认采用的是轮询策略
 */
@FeignClient(value = "student-server", fallback = StudentClientImpl.class)
public interface StudentClient {

    /**
     * 查询所有学生
     *
     * @return
     */
    @GetMapping("/student/findAllStudent")
    R findAllStudent();
}
