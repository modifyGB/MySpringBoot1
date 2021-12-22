/*
* @Description: 统一处理异常处理类
* @Version: 1.0
* @Autor: Renhetian
* @Date: 2021-12-16 00:28:48
 * @LastEditors: Renhetian
 * @LastEditTime: 2021-12-16 13:17:45
*/
package springboot.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import springboot.common.ExceptionCode;
import springboot.util.BaseException;
import springboot.util.ResponseResult;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    
    @ExceptionHandler(BaseException.class)
    public ResponseResult exceptionHandler(BaseException e) {
        return new ResponseResult(e.getCode(),e.getMessage());
    }

    @ExceptionHandler(UnknownAccountException.class)
    public ResponseResult exceptionHandler(UnknownAccountException e) {
        return new ResponseResult(ExceptionCode.LOGIN, "用户不存在");
    }

    @ExceptionHandler(IncorrectCredentialsException.class)
    public ResponseResult exceptionHandler(IncorrectCredentialsException e) {
        return new ResponseResult(ExceptionCode.LOGIN, "密码错误");
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult exceptionHandler(Exception e) {
        return new ResponseResult(ExceptionCode.OTHER, "未知错误", e);
    }
}