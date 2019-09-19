/**
* @项目名称: SCMS
* @文件名称: ClassesDao.java
* @Date: 2019年8月16日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import cn.edu.tyust.scms.mapper.ClassesMapper;
import cn.edu.tyust.scms.model.ClassesInfo;
import cn.edu.tyust.scms.model.Classes;
import cn.edu.tyust.scms.util.DBUtil;

/**
 * ClassesDao类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class ClassesDao {
    /**
     * 添加班级
     * 
     * @param clase 班级对象（clase是法语中的班级）
     * @return 添加成功返回true,失败返回false
     */
    public boolean insertClass(Classes clase) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            ClassesMapper classesMapper = sqlSession.getMapper(ClassesMapper.class);
            mysql_affected_rows = classesMapper.insertClass(clase);
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
     * 删除班级
     * 
     * @param classid 班级的编号
     * @return 删除成功返回true,失败返回false
     */
    public boolean deleteClass(String classid) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            ClassesMapper classesMapper = sqlSession.getMapper(ClassesMapper.class);
            mysql_affected_rows = classesMapper.deleteClass(classid);
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
     * 批量删除班级
     * 
     * @param classIDList 班级ID集合
     * @return 批量删除成功返回true,失败返回false
     */
    public boolean deleteClassList(List<String> classIDList) {
        if(classIDList.size() == 0) {
            return true;
        }
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            ClassesMapper classesMapper = sqlSession.getMapper(ClassesMapper.class);
            for (String classid : classIDList) {
                mysql_affected_rows += classesMapper.deleteClass(classid);
            }
            sqlSession.commit();
        } catch (Exception e) {
            sqlSession.rollback();
            mysql_affected_rows = 0;
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        //System.out.println(mysql_affected_rows);
        result = mysql_affected_rows != 0 ? true : false;
        return result;
    }

    /**
     * 修改班级
     * 
     * @param clase 班级对象（clase是法语中的班级）
     * @return 修改成功返回true,失败返回false
     */
    public boolean updateClass(Classes clase) {
        boolean result = false;
        int mysql_affected_rows = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            ClassesMapper classesMapper = sqlSession.getMapper(ClassesMapper.class);
            mysql_affected_rows = classesMapper.updateClass(clase);
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
     * 查询班级(分页显示)
     * 
     * @param currpage 当前页码
     * @param pagesize 每页记录个数
     * @param map      查询条件集合
     * @return 查询到的班级信息集合
     */
    public List<ClassesInfo> selectClasses(int currpage, int pagesize, Map<String, Object> map) {
        int offset = (currpage - 1) * pagesize;
        List<ClassesInfo> classesInfoList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            ClassesMapper classesMapper = sqlSession.getMapper(ClassesMapper.class);
            classesInfoList = classesMapper.selectClasses(new RowBounds(offset, pagesize), map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return classesInfoList;
    }

    /**
     * 获取满足条件的班级个数
     * 
     * @param map 查询条件集合
     * @return 满足条件的班级个数
     */
    public int getClassNumber(Map<String, Object> map) {
        int recordNum = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            ClassesMapper classesMapper = sqlSession.getMapper(ClassesMapper.class);
            recordNum = classesMapper.getClassNumber(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return recordNum;
    }

}
