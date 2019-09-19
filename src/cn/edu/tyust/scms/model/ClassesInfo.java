/**
* @项目名称: SCMS
* @文件名称: ClassesInfo.java
* @Date: 2019年8月17日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.model;

/**
 * 班级信息实体类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class ClassesInfo {
    private String grade;
    private String majorid;
    private String majorname;
    private String deptid;
    private String deptname;
    private String classid;
    private String classname;
    private String classremark;

    public ClassesInfo() {
        super();
    }

    public ClassesInfo(String grade, String majorid, String majorname, String deptid, String deptname, String classid,
            String classname, String classremark) {
        super();
        this.grade = grade;
        this.majorid = majorid;
        this.majorname = majorname;
        this.deptid = deptid;
        this.deptname = deptname;
        this.classid = classid;
        this.classname = classname;
        this.classremark = classremark;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    public String getClassremark() {
        return classremark;
    }

    public void setClassremark(String classremark) {
        this.classremark = classremark;
    }

    @Override
    public String toString() {
        return "ClassInfo [grade=" + grade + ", majorid=" + majorid + ", majorname=" + majorname + ", deptid=" + deptid
                + ", deptname=" + deptname + ", classid=" + classid + ", classname=" + classname + ", classremark="
                + classremark + "]";
    }

}
