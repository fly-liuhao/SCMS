package cn.edu.tyust.scms.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import cn.edu.tyust.scms.dao.ClassesDao;
import cn.edu.tyust.scms.model.Classes;
import cn.edu.tyust.scms.model.ClassesInfo;

import org.junit.Test;

/**
 * 班级Dao测试类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class ClassesDaoTest {
    private ClassesDao classesDao = new ClassesDao();
    private Logger logger = Logger.getLogger(ClassesDaoTest.class);

    /** 测试添加班级 */
//    @Test
    public void testInsertClass() {
        Classes clase = new Classes("1620541", "162054", "计算机科学与技术1班", "2016", "学霸班级！");
        boolean result = classesDao.insertClass(clase);
        logger.info(result);

    }

    /** 测试删除班级 */
//    @Test
    public void testDeleteClass() {
        String classid = "1620541";
        boolean result = classesDao.deleteClass(classid);
        logger.info(result);

    }

    /** 测试批量删除班级 */
    // INSERT INTO classes(classid, majorid, classname, grade, classremark)
    // VALUES('1620561','162056','软工1班','2016','很爱考研！');
    // INSERT INTO classes(classid, majorid, classname, grade, classremark)
    // VALUES('1620562','162056','软工2班','2016','不爱考研！');
    @Test
    public void testDeleteClassList() {
        List<String> classIDList = new ArrayList<String>();
        classIDList.add("1620561");
        classIDList.add("1620562");
        boolean result = classesDao.deleteClassList(classIDList);
        logger.info(result);

    }

    /** 测试修改班级 */
//    @Test
    public void testUpdateClass() {
        Classes clase = new Classes("1620541", "162054", "计算机科学与技术1班", "2016", "学霸班级！", "5");
        boolean result = classesDao.updateClass(clase);
        logger.info(result);

    }

    /** 测试查询班级 */
//    @Test
    public void testSelectClass() {
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("classid", "1620541");
//        map.put("classname", "软工");
        List<ClassesInfo> classesInfoList = classesDao.selectClasses(1,10,map);
        for (ClassesInfo classinfo : classesInfoList) {
            System.out.println(classinfo);
        }
        logger.info(classesInfoList.size());

    }
    
    /** 测试查询班组条件的班级数量 */
//  @Test
  public void testGetClassNum() {
      Map<String, Object> map = new HashMap<String, Object>();
//      map.put("classid", "1620541");
     map.put("classname", "软工");
     int result = classesDao.getClassNumber(map);
      logger.info(result);

  }

}
