/**
* @项目名称: SCMS
* @文件名称: TeamMapper.java
* @Date: 2019年8月21日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;

import cn.edu.tyust.scms.model.Team;
import cn.edu.tyust.scms.model.TeamInfo;

/**
 * 团队映射接口
 * 
 * @author: liuhao
 * @version V1.0
 */
public interface TeamMapper {

    /**
     * 添加团队
     * 
     * @param team 团队对象
     * @return 添加团队后数据库受影响的行数
     */
    public int insertTeam(Team team);

    /**
     * 删除团队
     * 
     * @param teamid 团队编号
     * @return 删除团队后数据库受影响的行数
     */
    public int deleteTeam(String teamid);

    /**
     * 修改团队
     * 
     * @param team 团队对象
     * @return 修改团队后数据库受影响的行数
     */
    public int updateTeam(Team team);

    /**
     * 查询团队信息
     * 
     * @param map 查询条件集合
     * @return 查询到的团队集合
     */
    public List<TeamInfo> selectTeamInfos(Map<String, Object> map);
    
    /**
     * 查询团队信息（带分页）
     * 
     * @param rowBounds MyBatis自带分页类
     * @param map 查询条件集合
     * @return 查询到的团队集合
     */
    public List<TeamInfo> selectTeamInfos(RowBounds rowBounds, Map<String, Object> map);
    
    /**
     * 查找预准备的团队
     * 
     * @param competitionid 团队参与的赛事ID
     * @return 查到的预准备的团队对象
     */
    public Team selectTeamUnique(String competitionid);
    
    /**
     * 根据团队ID查找团队
     * 
     * @param teamid 团队ID
     * @return 查到的预准备的团队对象
     */
    public Team selectTeamByTeamid(String teamid);
    

}
