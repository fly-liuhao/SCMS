/**
* @项目名称: SCMS
* @文件名称: LoginlogService.java
* @Date: 2019年8月27日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.service;

import java.util.List;
import java.util.Map;

import cn.edu.tyust.scms.model.Loginlog;
import cn.edu.tyust.scms.model.LoginlogInfo;

/**
 * LoginlogService接口
 * 
 * @author: liuhao
 * @version V1.0
 */
public interface LoginlogService {

    /**
     * 添加用户登陆日志
     * 
     * @param loginlog 登陆日志的对象
     * @return 添加成功数据库受影响的行数
     */
    public boolean addLoginlog(Loginlog loginlog);

    /**
     * 删除登陆日志
     * 
     * @param logid 登陆日志id
     * @return 删除成功返回true，失败返回false
     */
    public boolean removeLoginlog(String logid);

    /**
     * 查询登陆日志
     * 
     * @param map 查询条件集合
     * @return 查询到的用户登陆日志集合
     */
    public List<LoginlogInfo> findLoginlogInfos(Map<String, Object> map);

}
