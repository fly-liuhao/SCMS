/**
* @项目名称: SCMS
* @文件名称: UserService.java
* @Date: 2019年8月12日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.service;

import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.model.User;

/**
 * 用户service接口
 * 
 * @author: liuhao
 * @version V1.0
 */
public interface UserService {

    /**
     * 添加用户
     * 
     * @param user 用户对象
     * @return 添加成功返回true, 失败返回false
     */
    public boolean insertUser(User user);

    /**
     * 删除用户
     * 
     * @param userid 用户ID
     * @return 删除成功返回true, 失败返回false
     */
    public Boolean removeUser(String userid);

    /**
     * 查询用户
     * 
     * @param map 查询条件map结合
     * @return 查询到的用户集合
     */
    public List<User> selectUsers(Map<String, Object> map);

    /**
     * 修改用户信息
     * 
     * @param user 修改后的用户对象
     * @return 修改成功返回true, 失败返回false
     */
    public boolean modifyUser(User user);

    /**
     * 禁用用户
     * 
     * @param userid 用户ID
     * @return 禁用成功返回true,失败返回false
     */
    public boolean banUser(String userid);

    /**
     * 用户登陆验证
     * 
     * @param username 用户姓名
     * @param userpwd  用户密码
     * @return 登陆成功返回true，失败返回false
     */
    public boolean checkUser(String username, String userpwd);

}
