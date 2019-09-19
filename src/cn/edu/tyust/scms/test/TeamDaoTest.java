/**
* @项目名称: SCMS
* @文件名称: TeamDaoTest.java
* @Date: 2019年8月22日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import cn.edu.tyust.scms.dao.TeamDao;
import cn.edu.tyust.scms.model.Team;
import cn.edu.tyust.scms.model.TeamInfo;

/**
 * TeamDao测试类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class TeamDaoTest {
    TeamDao teamDao = new TeamDao();
    Logger logger = Logger.getLogger(TeamDao.class);

    /** 测试添加团队 */
//    @Test
    public void testInsertTeam() {
        Team team = new Team("17", "软件杯第一组", "MoveCode","刘浩", "张麟华", "Dong", "2019-6-30 10:53:32", "待定");
        boolean result = teamDao.insertTeam(team);
        logger.info(result);
    }

    /** 测试删除团队 */
//    @Test
    public void testDeleteTeam() {
        String teamid = "2";
        boolean result = teamDao.deleteTeam(teamid);
        logger.info(result);

    }

    /** 测试修改团队 */
//    @Test
    public void testUpdateTeam() {
        Team team = new Team("1", "17", "软件杯第二组", "MoveCode", "张麟华", "Dong", "2019-6-30 10:53:32", "待定");
        boolean result = teamDao.updateTeam(team);
        logger.info(result);
    }

    /** 测试查询团队 */
    @Test
    public void testSelectTeam() {
        Map<String, Object> map = new HashMap<String, Object>();
//      map.put("teamid", "1");
//      map.put("adviser", "华");
//      map.put("competitionid", "10");
//      map.put("teamname", "Code");
//      map.put("teamgroup", "二");
//      map.put("registusername", "Dong");

        List<TeamInfo> teamList = teamDao.selectTeamInfos(2,1,map);
        Iterator<TeamInfo> iterator = null;
        for (iterator = teamList.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
        logger.info(teamList.size());
    }

    /** 测试查询预准备团队 */
//    @Test
    public void testSelectTeamUnique() {
        Team team = teamDao.selectTeamUnique("0");
        logger.info(team);
    }
    
    /** 测试查询预准备团队 */
  @Test
  public void testSelectTeamByTeamid() {
      Team team = teamDao.selectTeamByTeamid("13");
      logger.info(team);
  }

}
