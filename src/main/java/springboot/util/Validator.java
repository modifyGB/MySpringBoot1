/*
 * @Description: 后台数据校验工具类
 * @Version: 1.0
 * @Autor: Renhetian
 * @Date: 2021-12-16 11:51:45
 * @LastEditors: Renhetian
 * @LastEditTime: 2021-12-21 22:58:27
 */
package springboot.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import springboot.common.ExceptionCode;

public class Validator {

    public static void fieldValidate(BindingResult errorResult) throws BaseException {
        if (errorResult.hasErrors()) {
            for (FieldError fieldError : errorResult.getFieldErrors()) {
                String errorMessage = fieldError.getDefaultMessage();
                String code = fieldError.getCode();
                
                if (code.equals("NotBlank")) {
                    throw new BaseException(ExceptionCode.NULL, errorMessage);
                }
                if (code.equals("NotNull")) {
                    throw new BaseException(ExceptionCode.NULL, errorMessage);
                }
                if (code.equals("Pattern")) {
                    throw new BaseException(ExceptionCode.FORMAT, errorMessage);
                }
                if (code.equals("Min")) {
                    throw new BaseException(ExceptionCode.FORMAT, errorMessage);
                }
            }
        }
    }
}
