package com.zyc.handler;

import com.zyc.excep.BusinessException;
import com.zyc.excep.NotPermissionException;
import com.zyc.utils.R;
import com.zyc.utils.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 作者:ZYC
 * DATE:2024/8/26
 * 快捷键:
 * ctrl+alt+l 自动格式化
 * alt+a/w 光标移至行首/行尾
 * alt+s 转换大小写
 * ctrl+f 在本类中查找
 * use: 自定义全局异常捕获
 */
@RestControllerAdvice
@Slf4j
public class MyGlobalExceptionHandler {

    /**
     * 捕获无权访问异常
     * @param e
     * @return
     */
    @ExceptionHandler(NotPermissionException.class)
    public R handlerNotPermissionException(NotPermissionException e) {
        log.error("出现了异常：{}", e.getMessage());
        return R.error().message(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        log.error(e.getMessage(), e);
        return R.error();
    }

    /**
     * 特定异常(sql语法错误)
     */
    @ExceptionHandler(BadSqlGrammarException.class)
    public R handleBadSqlGrammarException(BadSqlGrammarException e) {
        log.error(e.getMessage(), e);
        return R.setResult(ResponseEnum.BAD_SQL_GRAMMAR_ERROR);
    }

    /**
     * SQL异常(字段列名指代不明确)
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public R handleSqlException(DataIntegrityViolationException e) {
        log.error("异常信息：{}", e.getMessage());
        return R.setResult(ResponseEnum.BAD_SQL_AMBIGUOUS);
    }

    /**
     * 自定义异常
     */
    @ExceptionHandler(BusinessException.class)
    public R handleBusinessException(BusinessException e) {
        log.error(e.getMessage(), e);
        return R.error().message(e.getMessage()).code(e.getCode());
    }

    /**
     * Controller上一层相关异常
     */
    @ExceptionHandler({
            NoHandlerFoundException.class,
            HttpRequestMethodNotSupportedException.class,
            HttpMediaTypeNotSupportedException.class,
            MissingPathVariableException.class,
            MissingServletRequestParameterException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            MethodArgumentNotValidException.class,
            HttpMediaTypeNotAcceptableException.class,
            ServletRequestBindingException.class,
            ConversionNotSupportedException.class,
            MissingServletRequestPartException.class,
            AsyncRequestTimeoutException.class
    })
    public R handleServletException(Exception e) {
        log.error(e.getMessage(), e);
        // SERVLET_ERROR(-102, "servlet请求异常"),
        return R.error().message(ResponseEnum.SERVLET_ERROR.getMessage()).code(ResponseEnum.SERVLET_ERROR.getCode());
    }
}