/**
* @项目名称: SCMS
* @文件名称: LoginlogDao.java
* @Date: 2019年8月27日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.edu.tyust.scms.mapper.LoginlogMapper;
import cn.edu.tyust.scms.model.Loginlog;
import cn.edu.tyust.scms.model.LoginlogInfo;
import cn.edu.tyust.scms.util.DBUtil;

/**
 * LoginlogDao
 * 
 * @author: liuhao
 * @version V1.0
 */
public class LoginlogDao {

    /**
     * 添加用户登陆日志
     * 
     * @param loginlog 登陆日志的对象
     * @return 添加成功数据库受影响的行数
     */
    public boolean insertLoginlog(Loginlog loginlog) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            LoginlogMapper loginlogMapper = sqlSession.getMapper(LoginlogMapper.class);
            mysql_affected_rows = loginlogMapper.insertLoginlog(loginlog);
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
     * 删除登陆日志
     * 
     * @param logid 登陆日志ID
     * @return 删除成功返回true，失败返回false
     */
    public boolean deleteLoginlog(String logid) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            LoginlogMapper loginlogMapper = sqlSession.getMapper(LoginlogMapper.class);
            mysql_affected_rows = loginlogMapper.deleteLoginlog(logid);
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
     * 查询登陆日志
     * 
     * @param map 查询条件集合
     * @return 查询到的用户登陆日志集合
     */
    public List<LoginlogInfo> selectLoginlogInfos(Map<String, Object> map) {
        List<LoginlogInfo> loginlogInfoList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            LoginlogMapper loginlogMapper = sqlSession.getMapper(LoginlogMapper.class);
            loginlogInfoList = loginlogMapper.selectLoginlogInfos(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return loginlogInfoList;
    }

}
