/**
* @项目名称: SCMS
* @文件名称: UserServiceImpl.java
* @Date: 2019年8月13日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.dao.UserDao;
import cn.edu.tyust.scms.model.User;

/**
 * 
 * @author: liuhao
 * @version V1.0
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDao();

    @Override
    public boolean insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public Boolean removeUser(String userid) {
        return userDao.deleteUser(userid);
    }

    @Override
    public List<User> selectUsers(Map<String, Object> map) {
        return userDao.selectUsers(map);
    }

    @Override
    public boolean modifyUser(User user) {
        return userDao.modifyUser(user);
    }

    @Override
    public boolean banUser(String userid) {
        return userDao.banUser(userid);
    }

    @Override
    public boolean checkUser(String username, String userpwd) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("username", username);
        map.put("userpwd", userpwd);
        List<User> userList = userDao.selectUsers(map);
        if (userList.size() != 0) {
            return true;
        }
        return false;
    }

}
