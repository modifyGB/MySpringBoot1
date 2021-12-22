/*
 * @Description: shiro controller类，shiro实现的账户功能
 * @Version: 1.0
 * @Autor: Renhetian
 * @Date: 2021-12-12 22:54:20
 * @LastEditors: Renhetian
 * @LastEditTime: 2021-12-22 01:03:41
 */
package springboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import springboot.common.ExceptionCode;
import springboot.entity.User;
import springboot.service.ShiroService;
import springboot.util.BaseException;
import springboot.util.ResponseResult;
import springboot.util.UtilMethod;
import springboot.util.Validator;

@Slf4j
@RestController
@RequestMapping("shiro")
public class ShiroController {

    @Autowired
    ShiroService userService;

    @PostMapping("login")
    public Object login(@Validated User user, BindingResult bindingResult) throws BaseException{
        Validator.fieldValidate(bindingResult);
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated() || subject.isRemembered()) {
            throw new BaseException(ExceptionCode.LOGIN, "你已登录");
        }
        userService.login(user);
        log.info("用户登录：" + ((User) subject.getPrincipal()));
        return new ResponseResult("登录成功");
    }

    @GetMapping("logout")
    public Object logout() throws BaseException {
        Subject subject = SecurityUtils.getSubject();
        UtilMethod.checkLogin();
        log.info("用户退出：" + ((User) subject.getPrincipal()));
        subject.logout();
        return new ResponseResult("退出成功");
    }

    @PostMapping("register")
    public Object register(@Validated User user, BindingResult bindingResult) throws BaseException{
        Validator.fieldValidate(bindingResult);
        userService.register(user);
        log.info("用户注册：" + user);
        return new ResponseResult("注册成功");
    }

    @GetMapping("delete")
    public Object delete() throws BaseException{
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        UtilMethod.checkLogin();
        userService.delete(user);
        log.info("用户注销：" + user);
        subject.logout();
        return new ResponseResult("注销成功");
    }

    @PostMapping("change/{arg}")
    public Object changePassword(@PathVariable("arg") String arg, User user) throws BaseException {
        Subject subject = SecurityUtils.getSubject();
        UtilMethod.checkLogin();
        userService.change(arg, user);
        log.info("用户账号修改：" + ((User) subject.getPrincipal()));
        subject.logout();
        return new ResponseResult("修改成功,请重新登录");
    }

    @GetMapping("state")
    public Object state() throws BaseException {
        Subject subject = SecurityUtils.getSubject();
        UtilMethod.checkLogin();
        return subject.getPrincipal();
    }
}
