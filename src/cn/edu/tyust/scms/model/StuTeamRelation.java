/**
* @项目名称: SCMS
* @文件名称: StuTeamRelation.java
* @Date: 2019年8月21日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.model;

/**
 * 学生团体关系实体类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class StuTeamRelation {
    private String stid;
    private String stuid;
    private String teamid;
    private String sturole;
    private String oldstuid = "";

    public StuTeamRelation() {
        super();
    }

    public StuTeamRelation(String stuid, String teamid, String sturole) {
        super();
        this.stuid = stuid;
        this.teamid = teamid;
        this.sturole = sturole;
        this.oldstuid = stuid;
    }

    public StuTeamRelation(String stuid, String teamid, String sturole, String oldstuid) {
        super();
        this.stuid = stuid;
        this.teamid = teamid;
        this.sturole = sturole;
        this.oldstuid = oldstuid;
    }

    public StuTeamRelation(String stid, String stuid, String teamid, String sturole, String oldstuid) {
        super();
        this.stid = stid;
        this.stuid = stuid;
        this.teamid = teamid;
        this.sturole = sturole;
        this.oldstuid = oldstuid;
    }

    public String getStid() {
        return stid;
    }

    public void setStid(String stid) {
        this.stid = stid;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }

    public String getSturole() {
        return sturole;
    }

    public void setSturole(String sturole) {
        this.sturole = sturole;
    }

    public String getOldstuid() {
        return oldstuid;
    }

    public void setOldstuid(String oldstuid) {
        this.oldstuid = oldstuid;
    }

    @Override
    public String toString() {
        return "Stuteamrelation [stid=" + stid + ", stuid=" + stuid + ", teamid=" + teamid + ", sturole=" + sturole
                + "]";
    }

}
