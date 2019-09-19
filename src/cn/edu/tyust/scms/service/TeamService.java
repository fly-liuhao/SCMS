/**
* @项目名称: SCMS
* @文件名称: TeamService.java
* @Date: 2019年8月22日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.service;

import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.model.Team;
import cn.edu.tyust.scms.model.TeamInfo;

/**
 * TeamService接口
 * 
 * @author: liuhao
 * @version V1.0
 */
public interface TeamService {

    /**
     * 添加团队
     * 
     * @param team 团队对象
     * @return 添加团队成功返回true,失败返回false
     */
    public boolean addTeam(Team team);

    /**
     * 删除团队
     * 
     * @param teamid 团队编号
     * @return 删除团队成功返回true,失败返回false
     */
    public boolean removeTeam(String teamid);

    /**
     * 修改团队
     * 
     * @param team 团队对象
     * @return 修改团队成功返回true,失败返回false
     */
    public boolean modifyTeam(Team team);

    /**
     * 查找团队
     * 
     * @param map 查询条件集合
     * @return 查询到的团队集合
     */
    public List<TeamInfo> findTeamInfos(Map<String, Object> map);
    
    /**
     * 查找团队（带分页）
     * 
     * @param currpage 页码
     * @param pagesize 每页记录条数
     * @param map 查询条件集合
     * @return 查询到的团队集合
     */
    public List<TeamInfo> findTeamInfos(int currpage, int pagesize, Map<String, Object> map);

    /**
     * 查找预准备的团队
     * 
     * @param competitionid 团队参与的赛事ID
     * @return 查到的预准备的团队对象
     */
    public Team findTeamUnique(String competitionid);
    
    /**
     * 根据团队ID查找团队
     * 
     * @param teamid 团队ID
     * @return 查到的预准备的团队对象
     */
    public Team findTeamByTeamid(String teamid);
}
