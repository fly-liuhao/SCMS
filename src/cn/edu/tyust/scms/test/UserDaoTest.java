/**
* @项目名称: SCMS
* @文件名称: UserDaoTest.java
* @Date: 2019年8月11日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import cn.edu.tyust.scms.dao.UserDao;
import cn.edu.tyust.scms.model.User;

/**
 * 用户测试类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class UserDaoTest {
    UserDao userDao = new UserDao();
    Logger logger = Logger.getLogger(UserDaoTest.class);

    /**
     * 测试添加用户
     */
//    @Test
    public void testInsertUser() {
        User user = new User("老师", "xiaocao", "xiaocao", "小草", "1", "小草的做视频里讲的一口流利的重庆话");
        boolean result = userDao.insertUser(user);
        logger.info(result);
    }

    /* 测试删除用户 */
//  @Test
    public void testDeleteUser() {
        String stuid = "2";
        boolean result = userDao.deleteUser(stuid);
        logger.info(result);
    }

    /**
     * 测试查询用户
     */
//    @Test
    public void testSelect() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", "fly");
        map.put("userpwd", "123456");
        List<User> userList = userDao.selectUsers(map);
        for (User user : userList) {
            System.out.println(user);
        }
        logger.info(userList.size());
    }

    /**
     * 测试修改用户
     */
//    @Test
    public void testModifyUser() {
        User user = new User("1", "老师", "xiaocao", "xiaocao", "小草", "1", "小草的做视频里讲的一口流利的重庆话");
        boolean result = userDao.modifyUser(user);
        logger.info(result);
    }

    /**
     * 测试禁用用户
     */
//    @Test
    public void testbanUser() {
        String userid = "1";
        boolean result = userDao.banUser(userid);
        logger.info(result);
    }

}
