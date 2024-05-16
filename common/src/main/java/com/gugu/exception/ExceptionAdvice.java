package com.gugu.exception;

import com.gugu.common.ResultResponse;
import com.gugu.exception.myException.NotLoginException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Gugu
 * @create 2023-04-24 10:15
 * @purpose
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(NotLoginException.class)
    public ResultResponse doNotLoginException(NotLoginException e){
        return ResultResponse.error("您未登录");
    }
}
