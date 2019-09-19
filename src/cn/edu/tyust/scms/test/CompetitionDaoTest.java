/**
* @项目名称: SCMS
* @文件名称: CompetitionDaoTest.java
* @Date: 2019年8月21日
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

import cn.edu.tyust.scms.dao.CompetitionDao;
import cn.edu.tyust.scms.model.Competition;

/**
 * CompetitionDao测试类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class CompetitionDaoTest {
    private CompetitionDao competitionDao = new CompetitionDao();
    Logger logger = Logger.getLogger(CompetitionDaoTest.class);

    /** 测试添加赛事 */
//    @Test
    public void testInsertCompetition() {
        Competition competition = new Competition("蓝桥杯", "2019-4", "国家级", "A类", "计算机编程类的比赛");
        boolean result = competitionDao.insertCompetition(competition);
        logger.info(result);
    }

    /** 测试删除赛事 */
//    @Test
    public void testDeleteCompetition() {
        String competitionid = "8";
        boolean result = competitionDao.deleteCompetition(competitionid);
        logger.info(result);

    }

    /** 测试修改赛事 */
//    @Test
    public void testupdateCompetition() {
        Competition competition = new Competition("3", "蓝桥杯", "2019-4", "国家级", "A类", "计算机编程类的比赛");
        boolean result = competitionDao.updateCompetition(competition);
        logger.info(result);
    }

    /** 测试查询赛事 */
//    @Test
    public void testSelectCompetition() {
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("competitionid", 1);
//        map.put("startdate", "2018-10");
//        map.put("enddate", "2019-3");
//        map.put("competitionname", "杯");
//        map.put("competitionlevel", "国家级");
//        map.put("competitiontype", "A类");
        List<Competition> competitionList = competitionDao.selectCompetitions(1, 10, map);
        Iterator<Competition> iterator = null;
        for (iterator = competitionList.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
        logger.info(competitionList.size());

    }

    /** 测试满足条件的赛事数量 */
//    @Test
    public void testGetCompetitionNumber() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("competitionid", 1);
//        map.put("startdate", "2018-10");
//        map.put("enddate", "2019-3");
//        map.put("competitionname", "杯");
//        map.put("competitionlevel", "国家级");
//        map.put("competitiontype", "A类");
        int result = competitionDao.getCompetitionNumber(map);
        logger.info(result);

    }

    /** 测试赛事是否已经存在 */
//    @Test
    public void testCheckCompetition() {
        String competitionname = "蓝桥杯";
        boolean result = competitionDao.checkCompetition(competitionname);
        logger.info(result);

    }

}
