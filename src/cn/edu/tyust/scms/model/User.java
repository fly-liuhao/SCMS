/**
* @项目名称: SCMS
* @文件名称: User.java
* @Date: 2019年8月11日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.model;

/**
 * 用户实体类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class User {
    private String userid;
    private String userrole;
    private String username;
    private String userpwd;
    private String realname;
    private String status = "1";
    private String userremark;

    public User() {
        super();
    }

    public User(String userrole, String username, String userpwd, String realname, String userremark) {
        super();
        this.userrole = userrole;
        this.username = username;
        this.userpwd = userpwd;
        this.realname = realname;
        this.userremark = userremark;
    }

    public User(String userrole, String username, String userpwd, String realname, String status, String userremark) {
        super();
        this.userrole = userrole;
        this.username = username;
        this.userpwd = userpwd;
        this.realname = realname;
        this.status = status;
        this.userremark = userremark;
    }

    public User(String userid, String userrole, String username, String userpwd, String realname, String status,
            String userremark) {
        super();
        this.userid = userid;
        this.userrole = userrole;
        this.username = username;
        this.userpwd = userpwd;
        this.realname = realname;
        this.status = status;
        this.userremark = userremark;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserrole() {
        return userrole;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserremark() {
        return userremark;
    }

    public void setUserremark(String userremark) {
        this.userremark = userremark;
    }

    @Override
    public String toString() {
        return "User [userid=" + userid + ", userrole=" + userrole + ", username=" + username + ", userpwd=" + userpwd
                + ", realname=" + realname + ", status=" + status + ", userremark=" + userremark + "]";
    }

}
