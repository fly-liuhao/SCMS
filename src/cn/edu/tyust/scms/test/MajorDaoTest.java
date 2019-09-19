/**
* @项目名称: SCMS
* @文件名称: MajorDaoTest.java
* @Date: 2019年8月16日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import cn.edu.tyust.scms.dao.MajorDao;
import cn.edu.tyust.scms.model.Major;

/**
 * 班级Dao测试类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class MajorDaoTest {
    private MajorDao majorDao = new MajorDao();
    private Logger logger = Logger.getLogger(MajorDaoTest.class);

    /** 测试查询专业 */
    @Test
    public void testSelectMajor() {
        List<Major> majorList = majorDao.selectMajors(null);
        for (Major major : majorList) {
            System.out.println(major);
        }
        logger.info(majorList.size());

    }

}
