/**
* @项目名称: SCMS
* @文件名称: StatInfoDao.java
* @Date: 2019年9月9日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import cn.edu.tyust.scms.mapper.StatInfoMapper;
import cn.edu.tyust.scms.model.StatInfo;
import cn.edu.tyust.scms.util.DBUtil;

/**
 * StatInfoDao类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class StatInfoDao {
    /**
     * 查找竞赛信息
     * 
     * @param map 查询条件集合
     * @return 查询到的竞赛信息集合
     */
    public List<StatInfo> selectStatInfos(Map<String, Object> map) {
        List<StatInfo> statInfoList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            StatInfoMapper statInfoMapper = sqlSession.getMapper(StatInfoMapper.class);
            statInfoList = statInfoMapper.selectStatInfos(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return statInfoList;
    }

    /**
     * 查找竞赛信息（带分页）
     * 
     * @param currpage 页码
     * @param pagesize 每页记录条数
     * @param map      查询条件集合
     * @return 查询到的竞赛信息集合
     */
    public List<StatInfo> selectStatInfos(int currpage, int pagesize, Map<String, Object> map) {
        int offset = (currpage - 1) * pagesize;
        List<StatInfo> statInfoList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            StatInfoMapper statInfoMapper = sqlSession.getMapper(StatInfoMapper.class);
            statInfoList = statInfoMapper.selectStatInfoPage(new RowBounds(offset, pagesize), map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return statInfoList;
    }

    /**
     * 查找竞赛信息数量
     * 
     * @param map 查询条件集合
     * @return 查询到的竞赛信息数量
     */
    public int selectStatInfoCount(Map<String, Object> map) {
        int count = 0;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            StatInfoMapper statInfoMapper = sqlSession.getMapper(StatInfoMapper.class);
            count = statInfoMapper.selectStatInfoCount(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return count;
    }

    /**
     * 查找获奖的竞赛信息
     * 
     * @param map 查询条件集合
     * @return 查询到的竞赛信息
     */
    public List<StatInfo> selectWinStatInfo(Map<String, Object> map) {
        List<StatInfo> statInfoList = null;
        SqlSession sqlSession = null;

        try {
            sqlSession = DBUtil.getSession();
            StatInfoMapper statInfoMapper = sqlSession.getMapper(StatInfoMapper.class);
            statInfoList = statInfoMapper.selectWinStatInfo(map);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeSession(sqlSession);
        }

        return statInfoList;
    }
    
}
