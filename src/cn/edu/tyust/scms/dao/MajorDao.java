/**
* @项目名称: SCMS
* @文件名称: MajorDao.java
* @Date: 2019年8月16日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.edu.tyust.scms.mapper.MajorMapper;
import cn.edu.tyust.scms.model.Major;
import cn.edu.tyust.scms.util.DBUtil;

/**
 * MajorDao类
 * @author: liuhao
 * @version V1.0
 */
public class MajorDao {

    /**
     * 查询专业
     * 
     * @param map 查询条件集合
     * @return 查询出的专业集合
     */
    public List<Major> selectMajors(Map<String, Object> map) {
        List<Major> majorList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            MajorMapper majorMapper = sqlSession.getMapper(MajorMapper.class);
            majorList = majorMapper.selectMajors(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return majorList;
    }

}
