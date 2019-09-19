/**
* @项目名称: SCMS
* @文件名称: CompetitionDao.java
* @Date: 2019年8月21日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import cn.edu.tyust.scms.mapper.CompetitionMapper;
import cn.edu.tyust.scms.model.Competition;
import cn.edu.tyust.scms.util.DBUtil;

/**
 * CompetitionDao 类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class CompetitionDao {

    /**
     * 添加赛事
     * 
     * @param competition 赛事对象
     * @return 添加成功返回true,失败返回false
     */
    public boolean insertCompetition(Competition competition) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            CompetitionMapper competitionMapper = sqlSession.getMapper(CompetitionMapper.class);
            mysql_affected_rows = competitionMapper.insertCompetition(competition);
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
     * 删除赛事
     * 
     * @param competitionid 赛事的编号
     * @return 删除成功返回true,失败返回false
     */
    public boolean deleteCompetition(String competitionid) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            CompetitionMapper competitionMapper = sqlSession.getMapper(CompetitionMapper.class);
            mysql_affected_rows = competitionMapper.deleteCompetition(competitionid);
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
     * 批量删除赛事
     * 
     * @param competitionIDList 赛事ID集合
     * @return 批量删除成功返回true,失败返回false
     */
    public boolean deleteCompetitionList(List<String> competitionIDList) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            CompetitionMapper competitionMapper = sqlSession.getMapper(CompetitionMapper.class);
            for (String competitionid : competitionIDList) {
                mysql_affected_rows += competitionMapper.deleteCompetition(competitionid);
            }
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            mysql_affected_rows = 0;
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        System.out.println(mysql_affected_rows);
        result = mysql_affected_rows != 0 ? true : false;
        return result;
    }

    /**
     * 修改赛事
     * 
     * @param competition 赛事对象
     * @return 修改成功返回true,失败返回false
     */
    public boolean updateCompetition(Competition competition) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            CompetitionMapper competitionMapper = sqlSession.getMapper(CompetitionMapper.class);
            mysql_affected_rows = competitionMapper.updateCompetition(competition);
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
     * 查询赛事，带分页
     * 
     * @param currpage 页码
     * @param pagesize 每页记录条数
     * @param map      查询条件
     * @return 查询到的赛事集合
     */
    public List<Competition> selectCompetitions(int currpage, int pagesize, Map<String, Object> map) {
        int offset = (currpage - 1) * pagesize;
        List<Competition> competitionList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            CompetitionMapper competitionMapper = sqlSession.getMapper(CompetitionMapper.class);
            competitionList = competitionMapper.selectCompetitions(new RowBounds(offset, pagesize), map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return competitionList;
    }

    /**
     * 查询赛事2
     * 
     * @param map 查询条件
     * @return 查询到的赛事集合
     */
    public List<Competition> selectCompetitions(Map<String, Object> map) {
        List<Competition> competitionList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            CompetitionMapper competitionMapper = sqlSession.getMapper(CompetitionMapper.class);
            competitionList = competitionMapper.selectCompetitions2(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return competitionList;
    }

    /**
     * 获取满足条件的赛事个数
     * 
     * @param map 查询条件集合
     * @return 满足条件的赛事个数
     */
    public int getCompetitionNumber(Map<String, Object> map) {
        int recordNum = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            CompetitionMapper competitionMapper = sqlSession.getMapper(CompetitionMapper.class);
            recordNum = competitionMapper.getCompetitionNumber(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return recordNum;
    }

    /**
     * 检查赛事是否存在
     * 
     * @param competitionname 赛事名称
     * @return 赛事已存在返回true, 不存在返回false
     */
    public boolean checkCompetition(String competitionname) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            CompetitionMapper competitionMapper = sqlSession.getMapper(CompetitionMapper.class);
            mysql_affected_rows = competitionMapper.checkCompetition(competitionname);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }
        result = mysql_affected_rows != 0 ? true : false;
        return result;
    }

}
