/**
* @项目名称: SCMS
* @文件名称: Team.java
* @Date: 2019年8月21日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.model;

/**
 * 团队信息实体类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class TeamInfo {
    private String teamid;
    private String teamgroup;
    private String teamname;
    private String leader;
    private String adviser;
    private String registusername;
    private String registdate;
    private String award;
    private String competitionname;

    public TeamInfo() {
        super();
    }

    public TeamInfo(String teamid, String teamgroup, String teamname, String leader, String adviser,
            String registusername, String registdate, String award, String competitionname) {
        super();
        this.teamid = teamid;
        this.teamgroup = teamgroup;
        this.teamname = teamname;
        this.leader = leader;
        this.adviser = adviser;
        this.registusername = registusername;
        this.registdate = registdate;
        this.award = award;
        this.competitionname = competitionname;
    }

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }

    public String getTeamgroup() {
        return teamgroup;
    }

    public void setTeamgroup(String teamgroup) {
        this.teamgroup = teamgroup;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getAdviser() {
        return adviser;
    }

    public void setAdviser(String adviser) {
        this.adviser = adviser;
    }

    public String getRegistusername() {
        return registusername;
    }

    public void setRegistusername(String registusername) {
        this.registusername = registusername;
    }

    public String getRegistdate() {
        return registdate;
    }

    public void setRegistdate(String registdate) {
        this.registdate = registdate;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getCompetitionname() {
        return competitionname;
    }

    public void setCompetitionname(String competitionname) {
        this.competitionname = competitionname;
    }

    @Override
    public String toString() {
        return "TeamInfo [teamid=" + teamid + ", teamgroup=" + teamgroup + ", teamname=" + teamname + ", leader="
                + leader + ", adviser=" + adviser + ", registusername=" + registusername + ", registdate=" + registdate
                + ", award=" + award + ", competitionname=" + competitionname + "]";
    }

}
