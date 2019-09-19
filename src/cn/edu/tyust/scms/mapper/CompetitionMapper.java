/**
* @项目名称: SCMS
* @文件名称: CompetitionMapper.java
* @Date: 2019年8月21日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import cn.edu.tyust.scms.model.Competition;

/**
 * 赛事映射接口
 * 
 * @author: liuhao
 * @version V1.0
 */
public interface CompetitionMapper {

    /**
     * 添加赛事
     * 
     * @param competition 赛事对象
     * @return 添加赛事后数据库受影响的行数
     */
    public int insertCompetition(Competition competition);

    /**
     * 删除赛事
     * 
     * @param competitionid 赛事的编号
     * @return 删除赛事后数据库受影响的行数
     */
    public int deleteCompetition(String competitionid);

    /**
     * 修改赛事
     * 
     * @param competition 赛事对象
     * @return 修改赛事后数据库受影响的行数
     */
    public int updateCompetition(Competition competition);

    /**
     * 查询班级
     * 
     * @param rowBounds MyBatis自带分页类
     * @param map       查询条件集合
     * @return 查询到的班级信息集合
     */

    /**
     * 查询赛事,带分页
     * 
     * @param rowBounds MyBatis自带分页类
     * @param map       查询条件集合
     * @return 询到的赛事信息集合
     */
    public List<Competition> selectCompetitions(RowBounds rowBounds, Map<String, Object> map);
    
    /**
     * 查询赛事
     * 
     * @param map       查询条件集合
     * @return 询到的赛事信息集合
     */
    public List<Competition> selectCompetitions2(Map<String, Object> map);

    /**
     * 获取满足条件的赛事个数
     * 
     * @param map 查询条件集合
     * @return 满足条件的赛事个数
     */
    public int getCompetitionNumber(Map<String, Object> map);

    /**
     * 检查赛事是否存在
     * 
     * @param competitionname 赛事名称
     * @return 数据库中同名的赛事个数
     */
    public int checkCompetition(String competitionname);

}
