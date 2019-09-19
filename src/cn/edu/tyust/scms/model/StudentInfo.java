/**
* @项目名称: SCMS
* @文件名称: StudentInfo.java
* @Date: 2019年8月23日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.model;

/**
 * 团队成员信息实体类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class StudentInfo {
    private String stuid;
    private String stuname;
    private String sex;
    private String mobile;
    private String classid;
    private String classname;
    private String majorid;
    private String majorname;
    private String deptid;
    private String deptname;
    private String grade;

    public StudentInfo() {
        super();
    }

    public StudentInfo(String stuid, String stuname, String sex, String mobile, String classid, String classname,
            String majorid, String majorname, String deptid, String deptname, String grade) {
        super();
        this.stuid = stuid;
        this.stuname = stuname;
        this.sex = sex;
        this.mobile = mobile;
        this.classid = classid;
        this.classname = classname;
        this.majorid = majorid;
        this.majorname = majorname;
        this.deptid = deptid;
        this.deptname = deptname;
        this.grade = grade;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentInfo [stuid=" + stuid + ", stuname=" + stuname + ", sex=" + sex + ", mobile=" + mobile
                + ", classid=" + classid + ", classname=" + classname + ", majorid=" + majorid + ", majorname="
                + majorname + ", deptid=" + deptid + ", deptname=" + deptname + ", grade=" + grade + "]";
    }

}
