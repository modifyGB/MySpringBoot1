/*
 * @Description: shiro service类，用shiro实现的service
 * @Version: 1.0
 * @Autor: Renhetian
 * @Date: 2021-12-12 16:40:35
 * @LastEditors: Renhetian
 * @LastEditTime: 2021-12-22 01:03:03
 */
package springboot.service;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springboot.common.ExceptionCode;
import springboot.config.ShiroConfig;
import springboot.entity.User;
import springboot.mapper.UserMapper;
import springboot.util.BaseException;
import springboot.util.UtilMethod;

@Service
public class ShiroService {
    
    @Autowired
    UserMapper userMapper;
    
    //注册
    @Transactional
    public void register(User user) throws BaseException{
        User u = userMapper.selectByName(user.getName());
        if (u != null) {
            throw new BaseException(ExceptionCode.SHIRO, "用户已存在");
        } else {
            user.setPassword(ShiroConfig.ENCRYPT(user.getPassword()));
            userMapper.insertSelective(user);
        }
    }

    //注销
    @Transactional
    public void delete(User user) throws BaseException{
        userMapper.deleteByPrimaryKey(user.getId());
    }

    //登录
    @Transactional
    public void login(User user) throws BaseException{
        Subject subject = SecurityUtils.getSubject();
        user.setPassword(ShiroConfig.ENCRYPT(user.getPassword()));
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), user.getPassword(), true);
        subject.login(token);
    }

    
    //改名改密
    @Transactional
    public void change(String arg, User user) throws BaseException {
        User u = (User) SecurityUtils.getSubject().getPrincipal();
        if (arg.equals("name")) {
            String name = user.getName();
            UtilMethod.checkBlank(name);
            if (userMapper.selectByName(name) != null) {
                throw new BaseException(ExceptionCode.SHIRO, "用户名已存在");
            }
            u.setName(name);
        }
        else if (arg.equals("password")) {
            String password = user.getPassword();
            UtilMethod.checkBlank(password);
            u.setPassword(ShiroConfig.ENCRYPT(password));
        }
        else {
            throw new BaseException(ExceptionCode.FORMAT, "参数错误");
        }
        userMapper.updateByPrimaryKeySelective(u);
    }

    //登录验证
    @Transactional
    public User authenticate(AuthenticationToken token) {
        return userMapper.selectByName((String) token.getPrincipal());
    }

    //权限验证
    @Transactional
    public List<String> authorize(PrincipalCollection principals) {
        //TODO
        return null;
    }
}
