/**
* @项目名称: SCMS
* @文件名称: ClassesServiceImpl.java
* @Date: 2019年8月16日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.service;

import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.dao.ClassesDao;
import cn.edu.tyust.scms.model.Classes;
import cn.edu.tyust.scms.model.ClassesInfo;

/**
 * 班级Service接口实现类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class ClassesServiceImpl implements ClassesService {
    private ClassesDao classesDao = new ClassesDao();

    @Override
    public boolean addClass(Classes clase) {
        return classesDao.insertClass(clase);
    }

    @Override
    public boolean removeClass(String classid) {
        return classesDao.deleteClass(classid);
    }

    @Override
    public boolean removeClassList(List<String> classIDList) {
        return classesDao.deleteClassList(classIDList);
    }

    @Override
    public boolean modifyClass(Classes clase) {
        return classesDao.updateClass(clase);
    }

    @Override
    public List<ClassesInfo> findClasses(int currpage, int pagesize, Map<String, Object> map) {
        return classesDao.selectClasses(currpage, pagesize, map);
    }

    @Override
    public int getClassNumber(Map<String, Object> map) {
        return classesDao.getClassNumber(map);
    }

}
