/**
* @项目名称: SCMS
* @文件名称: DepartmentDaoTest.java
* @Date: 2019年8月16日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import cn.edu.tyust.scms.dao.DepartmentDao;
import cn.edu.tyust.scms.model.Department;

/**
 * 院系Dao测试类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class DepartmentDaoTest {
    private DepartmentDao departmentDao = new DepartmentDao();
    private Logger logger = Logger.getLogger(DepartmentDaoTest.class);

    /** 测试查询院系 */
    @Test
    public void testSelectDepartments() {
        List<Department> deptList = departmentDao.selectDepartments(null);
        for (Department dept : deptList) {
            System.out.println(dept);
        }
        logger.info(deptList.size());

    }

}
