/**
* @项目名称: SCMS
* @文件名称: CompetitionServiceImpl.java
* @Date: 2019年8月21日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.service;

import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.dao.CompetitionDao;
import cn.edu.tyust.scms.model.Competition;

/**
 * CompetitionService接口实现类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class CompetitionServiceImpl implements CompetitionService {
    private CompetitionDao competitionDao = new CompetitionDao();

    @Override
    public boolean addCompetition(Competition competition) {
        return competitionDao.insertCompetition(competition);
    }

    @Override
    public boolean removeCompetition(String competitionid) {
        return competitionDao.deleteCompetition(competitionid);
    }
    

    @Override
    public boolean removeCompetitionList(List<String> competitionIDList) {
        return competitionDao.deleteCompetitionList(competitionIDList);
    }

    @Override
    public boolean modifyCompetition(Competition competition) {
        return competitionDao.updateCompetition(competition);
    }

    @Override
    public List<Competition> findCompetitions(int currpage, int pagesize, Map<String, Object> map) {
        return competitionDao.selectCompetitions(currpage, pagesize, map);
    }

    @Override
    public List<Competition> findCompetitions(Map<String, Object> map) {
        return competitionDao.selectCompetitions(map);
    }

    @Override
    public int getCompetitionNumber(Map<String, Object> map) {
        return competitionDao.getCompetitionNumber(map);
    }

    @Override
    public boolean checkCompetition(String competitionname) {
        return competitionDao.checkCompetition(competitionname);
    }
    

}
