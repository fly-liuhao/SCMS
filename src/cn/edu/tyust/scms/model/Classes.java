/**
* @项目名称: SCMS
* @文件名称: Classes.java
* @Date: 2019年8月16日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.model;

/**
 * 班级实体类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class Classes {
    private String classid;
    private String majorid;
    private String classname;
    private String grade;
    private String classremark;
    private String oldclassid = "";// 修改班级编号时旧的班级编号

    public Classes() {
        super();
    }

    public Classes(String classid, String majorid, String classname, String grade, String classremark) {
        super();
        this.classid = classid;
        this.majorid = majorid;
        this.classname = classname;
        this.grade = grade;
        this.classremark = classremark;
    }

    public Classes(String classid, String majorid, String classname, String grade, String classremark,
            String oldclassid) {
        super();
        this.classid = classid;
        this.majorid = majorid;
        this.classname = classname;
        this.grade = grade;
        this.classremark = classremark;
        this.oldclassid = oldclassid;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getMajorid() {
        return majorid;
    }

    public void setMajorid(String majorid) {
        this.majorid = majorid;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getClassremark() {
        return classremark;
    }

    public void setClassremark(String classremark) {
        this.classremark = classremark;
    }

    @Override
    public String toString() {
        return "Classes [classid=" + classid + ", majorid=" + majorid + ", classname=" + classname + ", grade=" + grade
                + ", classremark=" + classremark + "]";
    }

}
