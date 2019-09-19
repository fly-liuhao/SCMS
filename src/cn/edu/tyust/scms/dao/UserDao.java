/**
* @项目名称: SCMS
* @文件名称: UserDao.java
* @Date: 2019年8月11日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.edu.tyust.scms.mapper.UserMapper;
import cn.edu.tyust.scms.model.User;
import cn.edu.tyust.scms.util.DBUtil;

/**
 * UserDao类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class UserDao {

    /**
     * 添加用户
     * 
     * @param user 用户对象
     * @return 添加成功返回true, 失败返回false
     */
    public boolean insertUser(User user) {
        boolean result = false;
        SqlSession sqlSession = null;
        int mysql_affected_rows = 0;

        try {
            sqlSession = DBUtil.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            mysql_affected_rows = userMapper.insertUser(user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        result = mysql_affected_rows != 0 ? true : false;
        return result;
    }

    /**
     * 删除用户
     * 
     * @param userid 用户ID
     * @return 删除成功返回true, 失败返回false
     */
    public Boolean deleteUser(String userid) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            mysql_affected_rows = userMapper.deleteUser(userid);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        result = mysql_affected_rows != 0 ? true : false;
        return result;
    }

    /**
     * 查询用户
     * 
     * @param map 查询条件map结合
     * @return 查询到的用户集合
     */
    public List<User> selectUsers(Map<String, Object> map) {
        List<User> userList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            userList = userMapper.selectUsers(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return userList;
    }

    /**
     * 修改用户信息
     * 
     * @param user 修改后的用户对象
     * @return 修改成功返回true, 失败返回false
     */
    public boolean modifyUser(User user) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            mysql_affected_rows = userMapper.modifyUser(user);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        result = mysql_affected_rows != 0 ? true : false;
        return result;
    }

    /**
     * 禁用用户
     * 
     * @param userid 用户ID
     * @return 禁用成功返回true,失败返回false
     */
    public boolean banUser(String userid) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            mysql_affected_rows = userMapper.banUser(userid);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        result = mysql_affected_rows != 0 ? true : false;
        return result;
    }

}
