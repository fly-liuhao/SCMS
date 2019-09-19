/**
* @项目名称: SCMS
* @文件名称: StudentDao.java
* @Date: 2019年8月21日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import cn.edu.tyust.scms.mapper.StudentMapper;
import cn.edu.tyust.scms.model.StuCompetition;
import cn.edu.tyust.scms.model.Student;
import cn.edu.tyust.scms.model.StudentInfo;
import cn.edu.tyust.scms.util.DBUtil;

/**
 * StudentDao类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class StudentDao {

    /**
     * 添加团队成员
     * 
     * @param student 团队成员对象
     * @return 添加团队成员成功返回true,失败返回false
     */
    public boolean insertStudent(Student student) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            mysql_affected_rows = studentMapper.insertStudent(student);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        result = mysql_affected_rows != 0 ? true : false;
        return result;
    }

    /**
     * 删除团队成员
     * 
     * @param stuid 成员学号
     * @return 删除成员成功返回true,失败返回false
     */
    public boolean deleteStudent(String stuid) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            mysql_affected_rows = studentMapper.deleteStudent(stuid);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        result = mysql_affected_rows != 0 ? true : false;
        return result;
    }

    /**
     * 删除团队所有成员
     * 
     * @param stuIDList 成员学号集合
     * @return 删除成员成功返回true,失败返回false
     */
    public boolean deleteStudentList(List<String> stuIDList) {
        if (stuIDList.size() == 0) {
            return true;
        }
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            for (String stuid : stuIDList) {
                mysql_affected_rows += studentMapper.deleteStudent(stuid);
            }
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            mysql_affected_rows = 0;
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        System.out.println(mysql_affected_rows);
        result = mysql_affected_rows != 0 ? true : false;
        return result;
    }

    /**
     * 修改团队成员
     * 
     * @param student 团队成员对象
     * @return 修改成员成功返回true,失败返回false
     */
    public boolean updateStudent(Student student) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            mysql_affected_rows = studentMapper.updateStudent(student);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        result = mysql_affected_rows != 0 ? true : false;
        return result;
    }

    /**
     * 查找团队成员
     * 
     * @param map 查询条件集合
     * @return 查询到的团队成员集合
     */
    public List<Student> selectStudents(Map<String, Object> map) {
        List<Student> stuList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            stuList = studentMapper.selectStudents(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return stuList;
    }

    /**
     * 查询团队成员信息
     * 
     * @param map 查询条件集合
     * @return 查询到的团队成员信息集合
     */
    public List<StudentInfo> selectStudentInfos(Map<String, Object> map) {
        List<StudentInfo> stuInfoList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            stuInfoList = studentMapper.selectStudentInfos(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return stuInfoList;
    }

    /**
     * 查询团队成员信息（带分页）
     * 
     * @param currpage 当前页码
     * @param pagesize 每页记录个数
     * @param map      查询条件集合
     * @return 查询到的团队成员信息集合
     */
    public List<StudentInfo> selectStudentInfos(int currpage, int pagesize, Map<String, Object> map) {
        int offset = (currpage - 1) * pagesize;
        List<StudentInfo> stuInfoList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            stuInfoList = studentMapper.selectStudentInfos(new RowBounds(offset, pagesize), map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return stuInfoList;
    }

    /**
     * 查询正在录入团队的成员信息
     * 
     * @return 查询到的团队成员信息集合
     */
    public List<StudentInfo> selectStuInfosByTeam() {
        List<StudentInfo> stuInfoList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            stuInfoList = studentMapper.selectStuInfosByTeam();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return stuInfoList;
    }
    
    /**
     * 根据团队ID查询该团队的所有成员信息
     * 
     * @param teamid 团队ID
     * @return 查询到的该团队的所有成员信息
     */
    public List<StudentInfo> selectStuInfosByTeamid(String teamid) {
        List<StudentInfo> stuInfoList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            stuInfoList = studentMapper.selectStuInfosByTeamid(teamid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return stuInfoList;
    }

    /**
     * 查询学生参与的赛事
     * 
     * @param stuid 学生ID
     * @return 查询到的学生参与的赛事
     */
    public List<StuCompetition> selectStudentCompetitions(String stuid) {
        List<StuCompetition> stucompetList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            stucompetList = studentMapper.selectStudentCompetitions(stuid);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return stucompetList;
    }

}
