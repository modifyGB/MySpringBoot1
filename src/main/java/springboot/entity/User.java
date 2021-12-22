/*
 * @Description: user实体类
 * @Version: 1.0
 * @Autor: Renhetian
 * @Date: 2021-12-14 16:11:53
 * @LastEditors: Renhetian
 * @LastEditTime: 2021-12-21 14:09:00
 */
package springboot.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{

    private Integer id;

    @NotBlank(message = "用户名不能为空")
    private String name;

    @NotBlank(message = "密码不能为空")
    private String password;

}