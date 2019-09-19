/**
* @项目名称: SCMS
* @文件名称: StatInfoDaoTest.java
* @Date: 2019年9月9日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import cn.edu.tyust.scms.dao.StatInfoDao;
import cn.edu.tyust.scms.model.StatInfo;

/**
 * 统计用的信息测试类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class StatInfoDaoTest {
    Logger logger = Logger.getLogger(StatInfoDaoTest.class);
    StatInfoDao statInfoDao = new StatInfoDao();

    /**
     * 测试查询统计信息
     */
//    @Test
    public void testSelectStatInfos() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("award", "特等奖");
        List<StatInfo> statInfoList = statInfoDao.selectStatInfos(map);
        for(StatInfo statInfo : statInfoList) {
            System.out.println(statInfo);
        }
        logger.info(statInfoList.size());
    }
    /**
     * 测试查询统计信息（分页）
     */
//    @Test
    public void testSelectStatInfoPage() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("award", "特等奖");
        List<StatInfo> statInfoList = statInfoDao.selectStatInfos(1, 2, map);
        for(StatInfo statInfo : statInfoList) {
            System.out.println(statInfo);
        }
        logger.info(statInfoList.size());
    }
    /**
     * 测试查询统计信息数量
     */
//    @Test
    public void testSelectStatInfoCount() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("award", "特等奖");
        int count = statInfoDao.selectStatInfoCount(map);
        logger.info(count);
    }
}
