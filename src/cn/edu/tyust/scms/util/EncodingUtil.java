/**
* @项目名称: J1012Web
* @文件名称: EncodingUtil.java
* @Date: 2019年7月28日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.util;

import java.io.UnsupportedEncodingException;

/**
 * 处理中文乱码
 * 
 * @author: liuhao
 * @version 1.0
 */
public class EncodingUtil {

    public static String changeEncoding(String oldStr) {
        String newStr = "";
        try {
            newStr = new String(oldStr.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return newStr;
    }

}
