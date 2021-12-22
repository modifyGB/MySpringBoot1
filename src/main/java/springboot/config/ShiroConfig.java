/*
 * @Description: shiro配置类，用于将shiro特定配置载入bean
 * @Version: 1.0
 * @Autor: Renhetian
 * @Date: 2021-12-12 21:02:06
 * @LastEditors: Renhetian
 * @LastEditTime: 2021-12-21 01:51:02
 */
package springboot.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springboot.util.Encrypt;
import springboot.util.UserRealm;

@Configuration
public class ShiroConfig {

    public final static String ENCRYPT(String password){
        if (password == null) {
            return null;
        }
        //密码加密方式
        return Encrypt.passwordEncrypt1(password, "MD5", "123456", 2);
    }

    @Bean
    public UserRealm userRealm() {
        UserRealm myShiroRealm = new UserRealm();
        return myShiroRealm;
    }

    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager getDefaultWebSecurityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(getDefaultWebSecurityManager);
        //拦截器列表
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();

        //TODO
        // //anon:所有url都可以匿名访问
        // filterChainDefinitionMap.put("/user/login", "anon");
        // //authc:所有url都必须认证通过才可以访问
        // filterChainDefinitionMap.put("/**", "authc");
        // //logout:退出登录,退出代码Shiro已经实现
        // filterChainDefinitionMap.put("/logout", "logout");
        // // 如果没有登录，则跳转到登录界面
        // bean.setLoginUrl("/user/login");
        // // 登录成功后要跳转的链接
        // bean.setSuccessUrl("/");
        // //未授权界面;
        // bean.setUnauthorizedUrl("/403");

        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }

}
