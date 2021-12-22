/*
 * @Description: 基础响应体类
 * @Version: 1.0
 * @Autor: Renhetian
 * @Date: 2021-12-15 13:18:59
 * @LastEditors: Renhetian
 * @LastEditTime: 2021-12-16 13:22:24
 */
package springboot.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import springboot.common.ExceptionCode;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult{

    private int code = ExceptionCode.SUCCESS;

    private String msg = "success";

    private Object data;

    public ResponseResult(Object data) {
        this.data = data;
    }

    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
