/*
 * @Description: 统一响应体处理类
 * @Version: 1.0
 * @Autor: Renhetian
 * @Date: 2021-12-15 23:30:26
 * @LastEditors: Renhetian
 * @LastEditTime: 2021-12-16 17:27:12
 */
 package springboot.controller;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import springboot.util.ResponseResult;

@RestControllerAdvice(basePackages = "springboot.controller")
public class BaseHandlerAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter arg1, MediaType arg2, 
        java.lang.Class<? extends org.springframework.http.converter.HttpMessageConverter<?>> arg3, 
        ServerHttpRequest arg4,ServerHttpResponse arg5) {
        if (body instanceof ResponseResult) {
            return body;
        }
        ResponseResult responseResult = new ResponseResult();
        responseResult.setData(body);
        return responseResult;
    }

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }
     
 }
 
