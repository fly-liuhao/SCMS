/**
* @项目名称: SCMS
* @文件名称: StudentMapper.java
* @Date: 2019年8月21日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import cn.edu.tyust.scms.model.StuCompetition;
import cn.edu.tyust.scms.model.Student;
import cn.edu.tyust.scms.model.StudentInfo;

/**
 * 团队成员映射接口
 * 
 * @author: liuhao
 * @version V1.0
 */
public interface StudentMapper {

    /**
     * 添加团队成员
     * 
     * @param student 团队成员对象
     * @return 添加团队成员后数据库受影响的行数
     */
    public int insertStudent(Student student);

    /**
     * 删除团队成员
     * 
     * @param stuid 成员学号
     * @return 删除成员后数据库受影响的行数
     */
    public int deleteStudent(String stuid);

    /**
     * 修改团队成员
     * 
     * @param student 团队成员对象
     * @return 修改后数据库受影响的行数
     */
    public int updateStudent(Student student);

    /**
     * 查找团队成员
     * 
     * @param map 查询条件集合
     * @return 查询到的团队成员集合
     */
    public List<Student> selectStudents(Map<String, Object> map);

    /**
     * 查询团队成员信息
     * 
     * @param map 查询条件集合
     * @return 查询到的团队成员信息集合
     */
    public List<StudentInfo> selectStudentInfos(Map<String, Object> map);

    /**
     * 查询团队成员信息
     * 
     * @param rowBounds MyBatis自带分页类
     * @param map       查询条件集合
     * @return 查询到的团队成员信息集合
     */
    public List<StudentInfo> selectStudentInfos(RowBounds rowBounds, Map<String, Object> map);

    /**
     * 查询正在录入团队的成员信息
     * 
     * @return 查询到的团队成员信息集合
     */
    public List<StudentInfo> selectStuInfosByTeam();

    /**
     * 根据团队ID查询该团队的所有成员信息
     * 
     * @param teamid 团队ID
     * @return 查询到的该团队的所有成员信息
     */
    public List<StudentInfo> selectStuInfosByTeamid(String teamid);

    /**
     * 查询学生参与的赛事
     * 
     * @param stuid 学生ID
     * @return 查询到的学生参与的赛事
     */
    public List<StuCompetition> selectStudentCompetitions(String stuid);

}
