/**
* @项目名称: SCMS
* @文件名称: CompetitionService.java
* @Date: 2019年8月21日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.service;

import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.model.Competition;

/**
 * 赛事Service接口
 * 
 * @author: liuhao
 * @version V1.0
 */
public interface CompetitionService {
    /**
     * 添加赛事
     * 
     * @param competition 赛事对象
     * @return 添加成功返回true,失败返回false
     */
    public boolean addCompetition(Competition competition);

    /**
     * 删除赛事
     * 
     * @param competitionid 赛事的编号
     * @return 删除成功返回true,失败返回false
     */
    public boolean removeCompetition(String competitionid);

    /**
     * 批量删除赛事
     * 
     * @param competitionIDList 赛事ID集合
     * @return 批量删除成功返回true,失败返回false
     */
    public boolean removeCompetitionList(List<String> competitionIDList);

    /**
     * 修改赛事
     * 
     * @param competition 赛事对象
     * @return 修改成功返回true,失败返回false
     */
    public boolean modifyCompetition(Competition competition);

    /**
     * 查询赛事，带分页
     * 
     * @param currpage 页码
     * @param pagesize 每页记录条数
     * @param map      查询条件
     * @return 查询到的赛事集合
     */
    public List<Competition> findCompetitions(int currpage, int pagesize, Map<String, Object> map);

    /**
     * 查询赛事
     * 
     * @param map 查询条件
     * @return 查询到的赛事集合
     */
    public List<Competition> findCompetitions(Map<String, Object> map);

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
     * @return 赛事已存在返回true, 不存在返回false
     */
    public boolean checkCompetition(String competitionname);

}
