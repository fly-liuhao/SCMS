/**
* @项目名称: SCMS
* @文件名称: StuTeamRelationMapper.java
* @Date: 2019年8月22日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.mapper;

import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.model.StuTeamRelation;

/**
 * 成员团体类映射接口
 * 
 * @author: liuhao
 * @version V1.0
 */
public interface StuTeamRelationMapper {

    /**
     * 添加成员团体关系
     * 
     * @param relation 成员团体关系对象
     * @return 添加关系在数据库中影响的行数
     */
    public int insertStuTeamRelation(StuTeamRelation relation);

    /**
     * 删除成员团队关系
     * 
     * @param map 删除条件
     * @return 删除关系在数据库中影响的行数
     */
    public int deleteStuTeamRelation(Map<String, Object> map);

    /**
     * 修改成员团队关系
     * 
     * @param relation 修改条件
     * @return 修改成功数据库中影响的行数
     */
    public int updateStuTeamRelation(StuTeamRelation relation);

    /**
     * 修改成员团队关系中的学号
     * 
     * @param stuid    新学号
     * @param oldstuid 旧学号
     * @return 修改成功数据库中受影响的行数
     */
    public int updateStuTeamRelationInStuid(String stuid, String oldstuid);

    /**
     * 查询团队成员关系
     * 
     * @param map 查询条件集合
     * @return 查询到的成员团队关系集合
     */
    public List<StuTeamRelation> selectStuTeamRelation(Map<String, Object> map);

}
