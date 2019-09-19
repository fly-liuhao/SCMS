/**
* @项目名称: SCMS
* @文件名称: StudentDaoTest.java
* @Date: 2019年8月21日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import cn.edu.tyust.scms.dao.StudentDao;
import cn.edu.tyust.scms.model.StuCompetition;
import cn.edu.tyust.scms.model.Student;
import cn.edu.tyust.scms.model.StudentInfo;

/**
 * 
 * @author: liuhao
 * @version V1.0
 */
public class StudentDaoTest {
    StudentDao studentDao = new StudentDao();
    Logger logger = Logger.getLogger(StudentDaoTest.class);

    /** 测试添加团队成员 */
//    @Test
    public void testInsertStudent() {
        Student student = new Student("162056224", "1620562", "刘浩", "男", "15364925795");
        boolean result = studentDao.insertStudent(student);
        logger.info(result);

    }

    /** 测试删除团队成员 */
//    @Test
    public void testDeleteStudent() {
        String stuid = "162054124";
        boolean result = studentDao.deleteStudent(stuid);
        logger.info(result);

    }

    /** 测试修改团队成员 */
//    @Test
    public void testUpdateStudent() {
        Student student = new Student("162054124", "1620562", "刘浩", "男", "15364925795", "162056224");
        boolean result = studentDao.updateStudent(student);
        logger.info(result);
    }

    /** 测试查询团队成员 */
//    @Test
    public void testSelectStudent() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("stuid", "162054124");
        List<Student> stuList = studentDao.selectStudents(map);
        Iterator<Student> iterator = null;
        for (iterator = stuList.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
        logger.info(stuList.size());
    }

    /** 测试查询团队成员 */
//    @Test
    public void testSelectStudentInfos() {
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("stuid", "162054124");
//        map.put("deptid", "16205");
//        map.put("majorid", "162011");
        List<StudentInfo> stuInfoList = studentDao.selectStudentInfos(map);
        Iterator<StudentInfo> iterator = null;
        for (iterator = stuInfoList.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
        logger.info(stuInfoList.size());
    }
    /** 测试查询团队成员 */
//    @Test
    public void testSelectStuInfosByTeam() {
        List<StudentInfo> stuInfoList = studentDao.selectStuInfosByTeam();
        Iterator<StudentInfo> iterator = null;
        for (iterator = stuInfoList.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
        logger.info(stuInfoList.size());
    }
    
    /** 测试批量删除团队成员 */
//    @Test
    public void testDeleteStuList() {
        List<String> stuIDList = new ArrayList<String>();
        stuIDList.add("1234");
        stuIDList.add("5678");
        boolean result = studentDao.deleteStudentList(stuIDList);
        logger.info(result);
    }
    
    /** 测试查询学生参与的赛事 */
//  @Test
  public void testSelectStudentCompetitions() {
      String stuid = "162056224";
      List<StuCompetition> stucompetList = studentDao.selectStudentCompetitions(stuid);
      Iterator<StuCompetition> iterator = null;
      for (iterator = stucompetList.iterator(); iterator.hasNext();) {
          System.out.println(iterator.next());
      }
      logger.info(stucompetList.size());
  }
  
  /** 测试查询指定团队的成员 */
@Test
public void testSelectStuInfosByTeamid() {
    List<StudentInfo> stuInfoList = studentDao.selectStuInfosByTeamid("12");
    Iterator<StudentInfo> iterator = null;
    for (iterator = stuInfoList.iterator(); iterator.hasNext();) {
        System.out.println(iterator.next());
    }
    logger.info(stuInfoList.size());
}

}
