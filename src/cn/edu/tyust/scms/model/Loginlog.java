/**
* @项目名称: SCMS
* @文件名称: Loginlog.java
* @Date: 2019年8月27日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.model;

/**
 * 登陆日志实体类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class Loginlog {
    private String logid;
    private String userid;
    private String logintime;
    private String loginsite;
    private String loginip;
    private String loginos;
    private String loginbrowser;
    private String loginremark;

    public Loginlog() {
        super();
    }

    public Loginlog(String userid, String logintime, String loginsite, String loginip, String loginos,
            String loginbrowser, String loginremark) {
        super();
        this.userid = userid;
        this.logintime = logintime;
        this.loginsite = loginsite;
        this.loginip = loginip;
        this.loginos = loginos;
        this.loginbrowser = loginbrowser;
        this.loginremark = loginremark;
    }

    public Loginlog(String logid, String userid, String logintime, String loginsite, String loginip, String loginos,
            String loginbrowser, String loginremark) {
        super();
        this.logid = logid;
        this.userid = userid;
        this.logintime = logintime;
        this.loginsite = loginsite;
        this.loginip = loginip;
        this.loginos = loginos;
        this.loginbrowser = loginbrowser;
        this.loginremark = loginremark;
    }

    public String getLogid() {
        return logid;
    }

    public void setLogid(String logid) {
        this.logid = logid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getLogintime() {
        return logintime;
    }

    public void setLogintime(String logintime) {
        this.logintime = logintime;
    }

    public String getLoginsite() {
        return loginsite;
    }

    public void setLoginsite(String loginsite) {
        this.loginsite = loginsite;
    }

    public String getLoginip() {
        return loginip;
    }

    public void setLoginip(String loginip) {
        this.loginip = loginip;
    }

    public String getLoginos() {
        return loginos;
    }

    public void setLoginos(String loginos) {
        this.loginos = loginos;
    }

    public String getLoginbrowser() {
        return loginbrowser;
    }

    public void setLoginbrowser(String loginbrowser) {
        this.loginbrowser = loginbrowser;
    }

    public String getLoginremark() {
        return loginremark;
    }

    public void setLoginremark(String loginremark) {
        this.loginremark = loginremark;
    }

    @Override
    public String toString() {
        return "Loginlog [logid=" + logid + ", userid=" + userid + ", logintime=" + logintime + ", loginsite="
                + loginsite + ", loginip=" + loginip + ", loginos=" + loginos + ", loginbrowser=" + loginbrowser
                + ", loginremark=" + loginremark + "]";
    }

}
