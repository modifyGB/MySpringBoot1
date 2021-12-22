/*
* @Description: 基础错误类
* @Version: 1.0
* @Autor: Renhetian
* @Date: 2021-12-16 00:32:04
 * @LastEditors: Renhetian
 * @LastEditTime: 2021-12-16 13:21:58
*/
package springboot.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseException extends Exception {

    private int code;

    private String message;

}