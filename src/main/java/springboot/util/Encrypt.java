/*
 * @Description: 加密工具类
 * @Version: 1.0
 * @Autor: Renhetian
 * @Date: 2021-12-15 14:15:01
 * @LastEditors: Renhetian
 * @LastEditTime: 2021-12-16 13:22:13
 */
package springboot.util;

import org.apache.shiro.crypto.hash.SimpleHash;

public class Encrypt {

    public final static String passwordEncrypt1(String password, String hashAlgorithmName, String salt, int hashIterations) {
        SimpleHash simpleHash = new SimpleHash(hashAlgorithmName, password, salt, hashIterations);
        return simpleHash.toHex();
    }
    
}
