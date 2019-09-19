/**
* @项目名称: SCMS
* @文件名称: TeamDao.java
* @Date: 2019年8月22日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import cn.edu.tyust.scms.mapper.TeamMapper;
import cn.edu.tyust.scms.model.Team;
import cn.edu.tyust.scms.model.TeamInfo;
import cn.edu.tyust.scms.util.DBUtil;

/**
 * StudentDao类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class TeamDao {

    /**
     * 添加团队
     * 
     * @param team 团队对象
     * @return 添加团队成功返回true,失败返回false
     */
    public boolean insertTeam(Team team) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
            mysql_affected_rows = teamMapper.insertTeam(team);
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
     * 删除团队
     * 
     * @param teamid 团队编号
     * @return 删除团队成功返回true,失败返回false
     */
    public boolean deleteTeam(String teamid) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
            mysql_affected_rows = teamMapper.deleteTeam(teamid);
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
     * 修改团队
     * 
     * @param team 团队对象
     * @return 修改团队成功返回true,失败返回false
     */
    public boolean updateTeam(Team team) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
            mysql_affected_rows = teamMapper.updateTeam(team);
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
     * 查找团队
     * 
     * @param map 查询条件集合
     * @return 查询到的团队集合
     */
    public List<TeamInfo> selectTeamInfos(Map<String, Object> map) {
        List<TeamInfo> teamInfoList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
            teamInfoList = teamMapper.selectTeamInfos(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return teamInfoList;
    }

    /**
     * 查找团队（带分页）
     * 
     * @param currpage 当前页码
     * @param pagesize 每页记录个数
     * @param map      查询条件集合
     * @return 查询到的团队集合
     */
    public List<TeamInfo> selectTeamInfos(int currpage, int pagesize, Map<String, Object> map) {
        int offset = (currpage - 1) * pagesize;
        List<TeamInfo> teamInfoList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
            teamInfoList = teamMapper.selectTeamInfos(new RowBounds(offset, pagesize), map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return teamInfoList;
    }

    /**
     * 查找预准备的团队
     * 
     * @param competitionid 团队参与的赛事ID
     * @return 查到的预准备的团队对象
     */
    public Team selectTeamUnique(String competitionid) {
        Team team = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
            team = teamMapper.selectTeamUnique(competitionid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return team;
    }

    /**
     * 根据团队ID查找团队
     * 
     * @param teamid 团队ID
     * @return 查到的预准备的团队对象
     */
    public Team selectTeamByTeamid(String teamid) {
        Team team = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            TeamMapper teamMapper = sqlSession.getMapper(TeamMapper.class);
            team = teamMapper.selectTeamByTeamid(teamid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return team;
    }

}
