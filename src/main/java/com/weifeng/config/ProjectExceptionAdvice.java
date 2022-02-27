package com.weifeng.config;

import com.weifeng.utils.RESTFul_R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName: ProjectExceptionAdvice
 * @Description: TODO
 * @Author: 32051
 * @Date: 2022/2/27 10:45
 * @Version
 */
//作为springmvc的异常处理器
@RestControllerAdvice
public class ProjectExceptionAdvice {

    //拦截所有的异常信息
    @ExceptionHandler
    public RESTFul_R doException(Exception e){
        //控制台输出异常信息
        e.printStackTrace();
        return new RESTFul_R("服务器异常，请稍后再试");
    }
}
