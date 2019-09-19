/**
* @项目名称: SCMS
* @文件名称: LoginlogServiceImpl.java
* @Date: 2019年8月27日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.service;

import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.dao.LoginlogDao;
import cn.edu.tyust.scms.model.Loginlog;
import cn.edu.tyust.scms.model.LoginlogInfo;

/**
 * 
 * @author: liuhao
 * @version V1.0
 */
public class LoginlogServiceImpl implements LoginlogService {
    private LoginlogDao loginlogDao = new LoginlogDao();

    @Override
    public boolean addLoginlog(Loginlog loginlog) {
        return loginlogDao.insertLoginlog(loginlog);
    }

    @Override
    public boolean removeLoginlog(String logid) {
        return loginlogDao.deleteLoginlog(logid);
    }

    @Override
    public List<LoginlogInfo> findLoginlogInfos(Map<String, Object> map) {
        return loginlogDao.selectLoginlogInfos(map);
    }

}
