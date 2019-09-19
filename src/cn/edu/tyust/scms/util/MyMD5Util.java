package cn.edu.tyust.scms.util;

/**
* @项目名称: EncryptionCode
* @文件名称: MyMD5Util.java
* @Date: 2019年7月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 简单的加密工具类
 * 参考：https://blog.csdn.net/flower_CSDN/article/details/80058684
 * 
 * @author: liuhao
 * @version 1.0
 */
public class MyMD5Util {

    /**
     * 对原始密码进行加密
     * 
     * @param password 原始密码
     * @return 使用MD5加密后的密码
     */
    public static String getEncryptedPwd(String password) {
        String newPassword = "";
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(password.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            newPassword = new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return newPassword;
    }

    /**
     * 验证密码是否正确
     * 
     * @param password     当前获取的密码
     * @param passwordInDb 数据库查到的密码
     * @return 验证成功返回true，失败返回false
     */
    public static boolean validatePassword(String password, String passwordInDb) {
        boolean result = false;
        if (getEncryptedPwd(password).equals(passwordInDb)) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    /**
     * @param args 加密测试
     *
     */
    public static void main(String[] args) {
        // 解密网站：https://www.cmd5.com/

        // 定义原始密码
        String oldStr = "liuhao";
        System.out.println("加密前：" + oldStr);

        // 使用MD5加密后的密码
        String newStr = getEncryptedPwd(oldStr);
        System.out.println("加密后：" + newStr);

        // 验证密码时候正确
        boolean result = validatePassword(oldStr, newStr);
        System.out.println("验证密码结果：" + result);

    }

}
