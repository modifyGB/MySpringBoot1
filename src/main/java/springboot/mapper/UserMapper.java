/*
 * @Description: user mapper接口类
 * @Version: 1.0
 * @Autor: Renhetian
 * @Date: 2021-12-14 16:11:54
 * @LastEditors: Renhetian
 * @LastEditTime: 2021-12-22 20:10:04
 */
package springboot.mapper;

import java.util.List;

import springboot.entity.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByName(String name);

    List<User> selectFindByName(String name);
}