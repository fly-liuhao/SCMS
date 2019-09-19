/**
* @项目名称: SCMS
* @文件名称: JsonToJavaBeanUtil.java
* @Date: 2019年8月18日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.util;

import java.util.List;

/**
 * 将JSON字符串转化成List集合工具类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class JsonToJavaBeanUtil {
    /**
     * 将JSON字符串转化成List集合
     * 
     * @param <T>        泛型
     * @param stringJson json字符串
     * @param javaBean   实体类
     * @return 生成的List实体
     */
    public static <T> List<T> jsonToJavaBean(String stringJson, Class<T> javaBean) {
        return (List<T>) com.alibaba.fastjson.JSONArray.parseArray(stringJson, javaBean);
    }

}
