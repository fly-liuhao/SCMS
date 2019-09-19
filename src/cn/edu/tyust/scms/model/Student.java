/**
* @项目名称: SCMS
* @文件名称: Student.java
* @Date: 2019年8月21日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.model;

/**
 * 参赛学生实体类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class Student {
    private String stuid;
    private String classid;
    private String stuname;
    private String sex;
    private String mobile;
    private String oldstuid = "";
    

    public Student() {
        super();
    }

    public Student(String stuid, String classid, String stuname, String sex, String mobile) {
        super();
        this.stuid = stuid;
        this.classid = classid;
        this.stuname = stuname;
        this.sex = sex;
        this.mobile = mobile;
    }
    

    public Student(String stuid, String classid, String stuname, String sex, String mobile, String oldstuid) {
        super();
        this.stuid = stuid;
        this.classid = classid;
        this.stuname = stuname;
        this.sex = sex;
        this.mobile = mobile;
        this.oldstuid = oldstuid;
    }

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
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

    @Override
    public String toString() {
        return "Student [stuid=" + stuid + ", classid=" + classid + ", stuname=" + stuname + ", sex=" + sex
                + ", mobile=" + mobile + "]";
    }

}
