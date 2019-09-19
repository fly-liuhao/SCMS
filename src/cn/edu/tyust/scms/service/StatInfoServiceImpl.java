/**
* @项目名称: SCMS
* @文件名称: StatInfoServiceImpl.java
* @Date: 2019年9月9日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.service;

import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.dao.StatInfoDao;
import cn.edu.tyust.scms.model.StatInfo;

/**
 * 竞赛信息Service接口实现类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class StatInfoServiceImpl implements StatInfoService {
    private StatInfoDao statINfoDao = new StatInfoDao();

    @Override
    public List<StatInfo> findStatInfos(Map<String, Object> map) {
        return statINfoDao.selectStatInfos(map);
    }

    @Override
    public List<StatInfo> findStatInfos(int currpage, int pagesize, Map<String, Object> map) {
        return statINfoDao.selectStatInfos(currpage, pagesize, map);
    }

    @Override
    public int findStatInfoCount(Map<String, Object> map) {
        return statINfoDao.selectStatInfoCount(map);
    }

    @Override
    public List<StatInfo> findWinStatInfo(Map<String, Object> map) {
        return statINfoDao.selectWinStatInfo(map);
    }

}
