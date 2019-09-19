/**
* @项目名称: SCMS
* @文件名称: ClassesMapper.java
* @Date: 2019年8月16日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import cn.edu.tyust.scms.model.ClassesInfo;
import cn.edu.tyust.scms.model.Classes;

/**
 * 班级映射接口
 * 
 * @author: liuhao
 * @version V1.0
 */
public interface ClassesMapper {

    /**
     * 添加班级
     * 
     * @param clase 班级对象（clase是法语中的班级）
     * @return 添加班级后数据库受影响的行数
     */
    public int insertClass(Classes clase);

    /**
     * 删除班级
     * 
     * @param classid 班级的编号
     * @return 删除班级后数据库受影响的行数
     */
    public int deleteClass(String classid);

    /**
     * 修改班级
     * 
     * @param clase 班级对象（clase是法语中的班级）
     * @return 修改班级后数据库受影响的行数
     */
    public int updateClass(Classes clase);

    /**
     * 查询班级
     * 
     * @param rowBounds MyBatis自带分页类
     * @param map 查询条件集合
     * @return 查询到的班级信息集合
     */
    public List<ClassesInfo> selectClasses(RowBounds rowBounds, Map<String, Object> map);
    
    /**
     * 获取满足条件的班级个数
     * 
     * @param map 查询条件集合
     * @return 满足条件的班级个数
     */
    public int getClassNumber(Map<String, Object> map);

}
