/**
* @项目名称: SCMS
* @文件名称: DepartmentServiceImpl.java
* @Date: 2019年8月16日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.service;

import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.dao.DepartmentDao;
import cn.edu.tyust.scms.model.Department;

/**
 * 院系Service接口
 * 
 * @author: liuhao
 * @version V1.0
 */
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentDao departmentDao = new DepartmentDao();

    @Override
    public List<Department> findDepartments(Map<String, Object> map) {
        return departmentDao.selectDepartments(map);
    }

}
