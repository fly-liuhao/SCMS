/**
* @项目名称: SCMS
* @文件名称: Competition.java
* @Date: 2019年8月21日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.model;

/**
 * 每个学生对应的赛事实体类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class StuCompetition {
    private String stuid;
    private String competitionid;
    private String sturole;
    private String competitionname;
    private String competitiondate;
    private String competitionlevel;
    private String competitiontype;
    private String competitiondescribe;

    public StuCompetition() {
        super();
    }

    public StuCompetition(String stuid, String competitionid, String sturole, String competitionname,
            String competitiondate, String competitionlevel, String competitiontype, String competitiondescribe) {
        super();
        this.stuid = stuid;
        this.competitionid = competitionid;
        this.sturole = sturole;
        this.competitionname = competitionname;
        this.competitiondate = competitiondate;
        this.competitionlevel = competitionlevel;
        this.competitiontype = competitiontype;
        this.competitiondescribe = competitiondescribe;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getCompetitionid() {
        return competitionid;
    }

    public void setCompetitionid(String competitionid) {
        this.competitionid = competitionid;
    }

    public String getSturole() {
        return sturole;
    }

    public void setSturole(String sturole) {
        this.sturole = sturole;
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

    public String getCompetitionlevel() {
        return competitionlevel;
    }

    public void setCompetitionlevel(String competitionlevel) {
        this.competitionlevel = competitionlevel;
    }

    public String getCompetitiontype() {
        return competitiontype;
    }

    public void setCompetitiontype(String competitiontype) {
        this.competitiontype = competitiontype;
    }

    public String getCompetitiondescribe() {
        return competitiondescribe;
    }

    public void setCompetitiondescribe(String competitiondescribe) {
        this.competitiondescribe = competitiondescribe;
    }

    @Override
    public String toString() {
        return "StuCompetition [stuid=" + stuid + ", competitionid=" + competitionid + ", sturole=" + sturole
                + ", competitionname=" + competitionname + ", competitiondate=" + competitiondate
                + ", competitionlevel=" + competitionlevel + ", competitiontype=" + competitiontype
                + ", competitiondescribe=" + competitiondescribe + "]";
    }

}
