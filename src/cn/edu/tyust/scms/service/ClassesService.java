/**
* @项目名称: SCMS
* @文件名称: ClassesService.java
* @Date: 2019年8月16日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.service;

import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.model.Classes;
import cn.edu.tyust.scms.model.ClassesInfo;

/**
 * 班级Service接口
 * 
 * @author: liuhao
 * @version V1.0
 */
public interface ClassesService {
    /**
     * 添加班级
     * 
     * @param clase 班级对象（clase是法语中的班级）
     * @return 添加成功返回true,失败返回false
     */
    public boolean addClass(Classes clase);

    /**
     * 删除班级
     * 
     * @param classid 班级的编号
     * @return 删除成功返回true,失败返回false
     */
    public boolean removeClass(String classid);

    /**
     * 批量删除班级
     * 
     * @param classIDList 班级ID集合
     * @return 批量删除成功返回true,失败返回false
     */
    public boolean removeClassList(List<String> classIDList);

    /**
     * 修改班级
     * 
     * @param clase 班级对象（clase是法语中的班级）
     * @return 修改成功返回true,失败返回false
     */
    public boolean modifyClass(Classes clase);

    /**
     * 查询班级
     * 
     * @param currpage 当前页码
     * @param pagesize 每页的记录条数
     * @param map      查询条件集合
     * @return 查询到的班级信息集合
     */
    public List<ClassesInfo> findClasses(int currpage, int pagesize, Map<String, Object> map);

    /**
     * 获取满足条件的班级个数
     * 
     * @param map 查询条件集合
     * @return 满足条件的班级个数
     */
    public int getClassNumber(Map<String, Object> map);

}
