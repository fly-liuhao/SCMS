/**
* @项目名称: SCMS
* @文件名称: StudentService.java
* @Date: 2019年8月22日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.service;

import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.model.StuCompetition;
import cn.edu.tyust.scms.model.Student;
import cn.edu.tyust.scms.model.StudentInfo;

/**
 * StudentService类
 * 
 * @author: liuhao
 * @version V1.0
 */
public interface StudentService {

    /**
     * 添加团队成员
     * 
     * @param student 团队成员对象
     * @return 添加团队成员成功返回true,失败返回false
     */
    public boolean addStudent(Student student);

    /**
     * 删除团队成员
     * 
     * @param stuid 成员学号
     * @return 删除成员成功返回true,失败返回false
     */
    public boolean removeStudent(String stuid);

    /**
     * 删除团队所有成员
     * 
     * @param stuIDList 成员学号集合
     * @return 删除成员成功返回true,失败返回false
     */
    public boolean removeStudentList(List<String> stuIDList);

    /**
     * 修改团队成员
     * 
     * @param student 团队成员对象
     * @return 修改成员成功返回true,失败返回false
     */
    public boolean modifyStudent(Student student);

    /**
     * 查找团队成员
     * 
     * @param map 查询条件集合
     * @return 查询到的团队成员集合
     */
    public List<Student> findStudents(Map<String, Object> map);

    /**
     * 查询团队成员信息(带分页)
     * 
     * @param currpage 页码
     * @param pagesize 每页记录条数
     * @param map 查询条件集合
     * @return 查询到的团队成员信息集合
     */
    public List<StudentInfo> findStudentInfos(int currpage, int pagesize, Map<String, Object> map);
    
    /**
     * 查询团队成员信息
     * 
     * @param map 查询条件集合
     * @return 查询到的团队成员信息集合
     */
    public List<StudentInfo> findStudentInfos(Map<String, Object> map);

    /**
     * 查询正在录入团队的成员信息
     * 
     * @return 查询到的团队成员信息集合
     */
    public List<StudentInfo> findStuInfosByTeam();
    
    /**
     * 根据团队ID查询该团队的所有成员信息
     * 
     * @param teamid 团队ID
     * @return 查询到的该团队的所有成员信息
     */
    public List<StudentInfo> findStuInfosByTeamid(String teamid);
    
    /**
     * 查询学生参与的赛事
     * 
     * @param stuid 学生ID
     * @return 查询到的学生参与的赛事
     */
    public List<StuCompetition> findStudentCompetitions(String stuid);
    
    /**
     * 根据学号查询姓名
     * @param stuid 学生学号
     * @return 查询到的学生姓名
     */
    public String getStunameByStuid(String stuid);

}
