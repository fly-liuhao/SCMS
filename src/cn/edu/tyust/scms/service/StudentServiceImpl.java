/**
* @项目名称: SCMS
* @文件名称: StudentServiceImpl.java
* @Date: 2019年8月22日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.dao.StudentDao;
import cn.edu.tyust.scms.model.StuCompetition;
import cn.edu.tyust.scms.model.Student;
import cn.edu.tyust.scms.model.StudentInfo;

/**
 * StudentService实现类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDao();

    @Override
    public boolean addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public boolean removeStudent(String stuid) {
        return studentDao.deleteStudent(stuid);
    }

    @Override
    public boolean removeStudentList(List<String> stuIDList) {
        return studentDao.deleteStudentList(stuIDList);
    }

    @Override
    public boolean modifyStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    @Override
    public List<Student> findStudents(Map<String, Object> map) {
        return studentDao.selectStudents(map);
    }

    @Override
    public List<StudentInfo> findStudentInfos(int currpage, int pagesize, Map<String, Object> map) {
        return studentDao.selectStudentInfos(currpage, pagesize, map);
    }

    @Override
    public List<StudentInfo> findStudentInfos(Map<String, Object> map) {
        return studentDao.selectStudentInfos(map);
    }

    @Override
    public List<StudentInfo> findStuInfosByTeam() {
        return studentDao.selectStuInfosByTeam();
    }

    @Override
    public List<StudentInfo> findStuInfosByTeamid(String teamid) {
        return studentDao.selectStuInfosByTeamid(teamid);
    }

    @Override
    public List<StuCompetition> findStudentCompetitions(String stuid) {
        return studentDao.selectStudentCompetitions(stuid);
    }

    @Override
    public String getStunameByStuid(String stuid) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("stuid", stuid);
        List<Student> stuList = studentDao.selectStudents(map);
        if (stuList.size() != 0) {
            return stuList.get(0).getStuname();
        } else {
            return null;
        }
    }

}
