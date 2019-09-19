/**
* @项目名称: SCMS
* @文件名称: StatInfo.java
* @Date: 2019年9月8日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.model;

/**
 * 统计用的信息实体类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class StatInfo {

    private String stuid;
    private String stuname;
    private String classid;
    private String classname;
    private String majorid;
    private String majorname;
    private String grade;

    private String teamid;
    private String teamname;
    private String sturole;
    private String competitionid;
    private String competitionname;
    private String competitiondate;
    private String adviser;
    private String award;

    public StatInfo() {
        super();
    }

    public StatInfo(String stuid, String stuname, String classid, String classname, String majorid, String majorname,
            String grade, String teamid, String teamname, String sturole, String competitionid, String competitionname,
            String competitiondate, String adviser, String award) {
        super();
        this.stuid = stuid;
        this.stuname = stuname;
        this.classid = classid;
        this.classname = classname;
        this.majorid = majorid;
        this.majorname = majorname;
        this.grade = grade;
        this.teamid = teamid;
        this.teamname = teamname;
        this.sturole = sturole;
        this.competitionid = competitionid;
        this.competitionname = competitionname;
        this.competitiondate = competitiondate;
        this.adviser = adviser;
        this.award = award;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getMajorid() {
        return majorid;
    }

    public void setMajorid(String majorid) {
        this.majorid = majorid;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTeamid() {
        return teamid;
    }

    public void setTeamid(String teamid) {
        this.teamid = teamid;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getSturole() {
        return sturole;
    }

    public void setSturole(String sturole) {
        this.sturole = sturole;
    }

    public String getCompetitionid() {
        return competitionid;
    }

    public void setCompetitionid(String competitionid) {
        this.competitionid = competitionid;
    }

    public String getCompetitionname() {
        return competitionname;
    }

    public void setCompetitionname(String competitionname) {
        this.competitionname = competitionname;
    }

    public String getCompetitiondate() {
        return competitiondate;
    }

    public void setCompetitiondate(String competitiondate) {
        this.competitiondate = competitiondate;
    }

    public String getAdviser() {
        return adviser;
    }

    public void setAdviser(String adviser) {
        this.adviser = adviser;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    @Override
    public String toString() {
        return "StatInfo [stuid=" + stuid + ", stuname=" + stuname + ", classid=" + classid + ", classname=" + classname
                + ", majorid=" + majorid + ", majorname=" + majorname + ", grade=" + grade + ", teamid=" + teamid
                + ", teamname=" + teamname + ", sturole=" + sturole + ", competitionid=" + competitionid
                + ", competitionname=" + competitionname + ", competitiondate=" + competitiondate + ", adviser="
                + adviser + ", award=" + award + "]";
    }

}
