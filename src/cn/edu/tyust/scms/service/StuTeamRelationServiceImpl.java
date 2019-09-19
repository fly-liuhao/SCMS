/**
* @项目名称: SCMS
* @文件名称: StuTeamRelationServiceImpl.java
* @Date: 2019年8月22日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.service;

import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.dao.StuTeamRelationDao;
import cn.edu.tyust.scms.model.StuTeamRelation;

/**
 * StuTeamRelationService实现类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class StuTeamRelationServiceImpl implements StuTeamRelationService {
    private StuTeamRelationDao stuTeamRelationDao = new StuTeamRelationDao();

    @Override
    public boolean addStuTeamRelation(StuTeamRelation relation) {
        return stuTeamRelationDao.insertStuTeamRelation(relation);
    }

    @Override
    public boolean removeStuTeamRelation(Map<String, Object> map) {
        return stuTeamRelationDao.deleteStuTeamRelation(map);
    }

    @Override
    public boolean modifyStuTeamRelation(StuTeamRelation relation) {
        return stuTeamRelationDao.updateStuTeamRelation(relation);
    }

    @Override
    public boolean modifyStuTeamRelationInStuid(String stuid, String oldstuid) {
        return stuTeamRelationDao.updateStuTeamRelationInStuid(stuid, oldstuid);
    }

    @Override
    public List<StuTeamRelation> findStuTeamRelation(Map<String, Object> map) {
        return stuTeamRelationDao.selectStuTeamRelation(map);
    }

}
