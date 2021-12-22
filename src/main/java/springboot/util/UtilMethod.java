/*
 * @Description: file description
 * @Version: 1.0
 * @Autor: Renhetian
 * @Date: 2021-12-21 13:27:53
 * @LastEditors: Renhetian
 * @LastEditTime: 2021-12-22 13:19:28
 */
package springboot.util;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import springboot.common.ExceptionCode;

public class UtilMethod {

    public static void checkLogin() throws BaseException{
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated() && !subject.isRemembered()) {
            throw new BaseException(ExceptionCode.LOGIN, "未登录");
        }
    }

    public static void checkAuthorize(Integer useId, Integer ownId) throws BaseException{
        if (!useId.equals(ownId)) {
            throw new BaseException(ExceptionCode.AUTHORIZE, "无权限");
        }
    }

    public static void checkBlank(String str) throws BaseException{
        if (str == null || str.equals("")) {
            throw new BaseException(ExceptionCode.NULL, "参数不能为空");
        }
    }

    public static void checkBlank(Integer id) throws BaseException{
        if (id == null || id <= 0) {
            throw new BaseException(ExceptionCode.NULL, "参数范围错误");
        }
    }
}
