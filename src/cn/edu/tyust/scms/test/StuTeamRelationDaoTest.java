/**
* @项目名称: SCMS
* @文件名称: StuTeamRelationDaoTest.java
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

import cn.edu.tyust.scms.dao.StuTeamRelationDao;
import cn.edu.tyust.scms.model.StuTeamRelation;

/**
 * 
 * @author: liuhao
 * @version V1.0
 */
public class StuTeamRelationDaoTest {
    StuTeamRelationDao stuTeamRelationDao = new StuTeamRelationDao();
    Logger logger = Logger.getLogger(StuTeamRelationDaoTest.class);

    /** 测试添加关系 */
//    @Test
    public void testInsertStuTeamRelation() {
        StuTeamRelation relation = new StuTeamRelation("162056224", "1", "成员");
        boolean result = stuTeamRelationDao.insertStuTeamRelation(relation);
        logger.info(result);
    }

    /** 测试删除关系 */
//    @Test
    public void testDeleteStuTeamRelation() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("stuid", "162056224");
        map.put("teamid", "1");
        boolean result = stuTeamRelationDao.deleteStuTeamRelation(map);
        logger.info(result);
    }

    /** 测试修改关系 */
//  @Test
    public void testUpdateStuTeamRelation() {
        StuTeamRelation relation = new StuTeamRelation("162056224", "11111", null, "1620562");
        boolean result = stuTeamRelationDao.updateStuTeamRelation(relation);
        logger.info(result);
    }
    /** 测试修改关系中的学生学号 */
//  @Test
    public void testUpdateStuTeamRelationInStuid() {
        boolean result = stuTeamRelationDao.updateStuTeamRelationInStuid("162056233", "162056232");
        logger.info(result);
    }

    /** 测试查询关系 */
    @Test
    public void testSelectStuTeamRelation() {
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("stuid", "162056224");
        map.put("teamid", "13");
        map.put("sturole", "组长");
        List<StuTeamRelation> relationList = stuTeamRelationDao.selectStuTeamRelation(map);
        for (Iterator<StuTeamRelation> iterator = relationList.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
        logger.info(relationList.size());
    }

}
