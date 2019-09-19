/**
* @项目名称: SCMS
* @文件名称: StuTeamRelationDao.java
* @Date: 2019年8月22日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.edu.tyust.scms.mapper.StuTeamRelationMapper;
import cn.edu.tyust.scms.model.StuTeamRelation;
import cn.edu.tyust.scms.util.DBUtil;

/**
 * StuTeamRelationDao类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class StuTeamRelationDao {

    /**
     * 添加成员团体关系
     * 
     * @param relation 成员团体关系对象
     * @return 添加关系成功返回true,失败返回false
     */
    public boolean insertStuTeamRelation(StuTeamRelation relation) {
        boolean result = false;
        SqlSession sqlSession = null;
        int mysql_affected_rows = 0;

        try {
            sqlSession = DBUtil.getSession();
            StuTeamRelationMapper relationMapper = sqlSession.getMapper(StuTeamRelationMapper.class);
            mysql_affected_rows = relationMapper.insertStuTeamRelation(relation);
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
     * 删除成员团队关系
     * 
     * @param map 删除条件
     * @return 删除关系成功返回true,失败返回false
     */
    public boolean deleteStuTeamRelation(Map<String, Object> map) {
        boolean result = false;
        SqlSession sqlSession = null;
        int mysql_affected_rows = 0;

        try {
            sqlSession = DBUtil.getSession();
            StuTeamRelationMapper relationMapper = sqlSession.getMapper(StuTeamRelationMapper.class);
            mysql_affected_rows = relationMapper.deleteStuTeamRelation(map);
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
     * 修改成员团队关系
     * 
     * @param relation 修改条件
     * @return 修改成功数据库中影响的行数
     */
    public boolean updateStuTeamRelation(StuTeamRelation relation) {
        boolean result = false;
        SqlSession sqlSession = null;
        int mysql_affected_rows = 0;

        try {
            sqlSession = DBUtil.getSession();
            StuTeamRelationMapper relationMapper = sqlSession.getMapper(StuTeamRelationMapper.class);
            mysql_affected_rows = relationMapper.updateStuTeamRelation(relation);
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
     * 修改成员团队关系中的学号
     * 
     * @param stuid    新学号
     * @param oldstuid 旧学号
     * @return 修改成功数据库中受影响的行数
     */
    public boolean updateStuTeamRelationInStuid(String stuid, String oldstuid) {
        boolean result = false;
        SqlSession sqlSession = null;
        int mysql_affected_rows = 0;

        try {
            sqlSession = DBUtil.getSession();
            StuTeamRelationMapper relationMapper = sqlSession.getMapper(StuTeamRelationMapper.class);
            mysql_affected_rows = relationMapper.updateStuTeamRelationInStuid(stuid, oldstuid);
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
     * 查询团队成员关系
     * 
     * @param map 查询条件集合
     * @return 查询到的成员团队关系集合
     */
    public List<StuTeamRelation> selectStuTeamRelation(Map<String, Object> map) {
        List<StuTeamRelation> relationList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            StuTeamRelationMapper relationMapper = sqlSession.getMapper(StuTeamRelationMapper.class);
            relationList = relationMapper.selectStuTeamRelation(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return relationList;
    }

}
