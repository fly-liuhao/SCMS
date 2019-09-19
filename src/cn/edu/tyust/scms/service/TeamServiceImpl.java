/**
* @项目名称: SCMS
* @文件名称: TeamServiceImpl.java
* @Date: 2019年8月22日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.service;

import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.dao.TeamDao;
import cn.edu.tyust.scms.model.Team;
import cn.edu.tyust.scms.model.TeamInfo;

/**
 * TeamService实现类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class TeamServiceImpl implements TeamService {
    TeamDao teamDao = new TeamDao();

    @Override
    public boolean addTeam(Team team) {
        return teamDao.insertTeam(team);
    }

    @Override
    public boolean removeTeam(String teamid) {
        return teamDao.deleteTeam(teamid);
    }

    @Override
    public boolean modifyTeam(Team team) {
        return teamDao.updateTeam(team);
    }

    @Override
    public List<TeamInfo> findTeamInfos(Map<String, Object> map) {
        return teamDao.selectTeamInfos(map);
    }

    @Override
    public List<TeamInfo> findTeamInfos(int currpage, int pagesize, Map<String, Object> map) {
        return teamDao.selectTeamInfos(currpage, pagesize, map);
    }

    @Override
    public Team findTeamUnique(String competitionid) {
        return teamDao.selectTeamUnique(competitionid);
    }

    @Override
    public Team findTeamByTeamid(String teamid) {
        return teamDao.selectTeamByTeamid(teamid);
    }

}
