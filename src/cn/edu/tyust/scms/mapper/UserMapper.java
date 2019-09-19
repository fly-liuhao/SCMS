/**
* @项目名称: SCMS
* @文件名称: UserMapper.java
* @Date: 2019年8月11日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.mapper;

import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.model.User;

/**
 * 用户mapper接口
 * 
 * @author: liuhao
 * @version V1.0
 */
public interface UserMapper {

    /**
     * 添加用户
     * 
     * @param user 用户对象
     * @return 添加用户后数据库受影响的行数
     */
    public int insertUser(User user);

    /**
     * 删除用户
     * 
     * @param userid 用户ID
     * @return 删除用户后数据库受影响的行数
     */
    public int deleteUser(String userid);

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
     * @return 修改用户后数据库受影响的行数
     */
    public int modifyUser(User user);

    /**
     * 禁用用户
     * 
     * @param userid 用户ID
     * @return 修改用户后数据库受影响的行数
     */
    public int banUser(String userid);
}
