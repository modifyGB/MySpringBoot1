/*
 * @Description: shiro realm类，用于实现账户验证与账户授权
 * @Version: 1.0
 * @Autor: Renhetian
 * @Date: 2021-12-12 20:55:07
 * @LastEditors: Renhetian
 * @LastEditTime: 2021-12-16 13:22:48
 */
package springboot.util;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import springboot.entity.User;
import springboot.service.ShiroService;

public class UserRealm extends AuthorizingRealm{

    @Autowired
    ShiroService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token){
        User user = userService.authenticate(token);
        if (user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),"UserRealm");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermissions(userService.authorize(principals));
        return authorizationInfo;
    }
}
