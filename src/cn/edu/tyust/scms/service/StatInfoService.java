/**
* @项目名称: SCMS
* @文件名称: StatInfoService.java
* @Date: 2019年9月9日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.service;

import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.model.StatInfo;

/**
 * 竞赛信息Service接口
 * 
 * @author: liuhao
 * @version V1.0
 */
public interface StatInfoService {
    /**
     * 查找竞赛信息
     * 
     * @param map 查询条件集合
     * @return 查询到的竞赛信息集合
     */
    public List<StatInfo> findStatInfos(Map<String, Object> map);

    /**
     * 查找竞赛信息（带分页）
     * 
     * @param currpage 页码
     * @param pagesize 每页记录条数
     * @param map 查询条件集合
     * @return 查询到的竞赛信息集合
     */
    public List<StatInfo> findStatInfos(int currpage, int pagesize, Map<String, Object> map);

    /**
     * 查找竞赛信息数量
     * 
     * @param map 查询条件集合
     * @return 查询到的竞赛信息数量
     */
    public int findStatInfoCount(Map<String, Object> map);

    /**
     * 查找获奖的竞赛信息
     * 
     * @param map 查询条件集合
     * @return 查询到的竞赛信息
     */
    public List<StatInfo> findWinStatInfo(Map<String, Object> map);
}
