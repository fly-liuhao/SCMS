/**
* @项目名称: SCMS
* @文件名称: LoginlogDaoTest.java
* @Date: 2019年8月27日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import cn.edu.tyust.scms.dao.LoginlogDao;
import cn.edu.tyust.scms.model.Loginlog;
import cn.edu.tyust.scms.model.LoginlogInfo;

/**
 * LoginlogDaoTest测试类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class LoginlogDaoTest {
    private LoginlogDao loginlogDao = new LoginlogDao();
    private Logger logger = Logger.getLogger(LoginlogDaoTest.class);

    /* 测试添加登陆日志 */
//    @Test
    public void testInsertLoginlog() {
        Loginlog loginlog = new Loginlog("5", "2019-08-30 10:20:35", "山西 太原", "192.168.1.152", "Windows 10",
                "Chrom 8.0", "这是一位有灵魂的登陆者...");
        boolean result = loginlogDao.insertLoginlog(loginlog);
        logger.info(result);
    }
    /* 测试添加登陆日志 */
//    @Test
    public void testDeleteLoginlog() {
        boolean result = loginlogDao.deleteLoginlog("1");
        logger.info(result);
    }
    /* 测试添加登陆日志 */
//    @Test
    public void testSelectLoginlog() {
        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("username", "iaocao");
        map.put("userid", "20");
        List<LoginlogInfo> loginlogInfoList = loginlogDao.selectLoginlogInfos(map);
        for(LoginlogInfo loginlogInfo : loginlogInfoList) {
            System.out.println(loginlogInfo);
        }
        logger.info(loginlogInfoList.size());
    }

}
