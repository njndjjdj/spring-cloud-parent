package com.zyc.client.impl;

import com.zyc.client.StudentClient;
import com.zyc.utils.R;
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
@Component
public class StudentClientImpl implements StudentClient {
    @Override
    public R findAllStudent() {
        return R.error().message("服务迷路啦，真不好意思~~StudentClientImpl");
    }
}
