/**
* @项目名称: UOLMyBatis
* @文件名称: DBUtil.java
* @Date: 2019年7月23日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.util;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * MyBatis工具类 数据库连接实用类
 * 
 * @author: liuhao
 * @version 1.0
 */
public class DBUtil {
    public static SqlSessionFactory sessionFactory;

    static {
        try {
            // 使用MyBatis提供的Resources类加载mybatis的配置文件
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            // 构建sqlSession的工厂
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建能执行映射文件中sql的sqlSession
     * 
     * @return 执行sql的sqlSession对象
     */
    public static SqlSession getSession() {
        return sessionFactory.openSession();
    }

    /**
     * 关闭session
     * 
     * @param session 要被关闭的session对象
     */
    public static void closeSession(SqlSession session) {
        if (session != null) {
            session.close();
        }
    }
    public static void main(String[] args) {
        SqlSession sqlSession = DBUtil.getSession();
        System.out.println(sqlSession);
    }
}
