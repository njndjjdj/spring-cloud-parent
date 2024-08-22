package com.zyc.client.factory;

import com.zyc.client.StudentClient;
import com.zyc.utils.R;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

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
// @Component
// public class StudentFallbackFactory implements FallbackFactory<StudentClient> {
//
//     @Override
//     public StudentClient create(Throwable cause) {
//         return new StudentClient() {
//             @Override
//             public R findAllStudent() {
//                 return R.error().message("不好意思服务迷路啦，StudentFallbackFactory~~");
//             }
//         };
//     }
// }
