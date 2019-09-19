/**
* @项目名称: SCMS
* @文件名称: Major.java
* @Date: 2019年8月16日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.model;

/**
 * 专业实体类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class Major {
    private String majorid;
    private String deptid;
    private String majorname;
    private String majorremark;

    public Major() {
        super();
    }

    public Major(String majorid, String deptid, String majorname, String majorremark) {
        super();
        this.majorid = majorid;
        this.deptid = deptid;
        this.majorname = majorname;
        this.majorremark = majorremark;
    }

    public String getMajorid() {
        return majorid;
    }

    public void setMajorid(String majorid) {
        this.majorid = majorid;
    }

    public String getDeptid() {
        return deptid;
    }

    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    public String getMajorname() {
        return majorname;
    }

    public void setMajorname(String majorname) {
        this.majorname = majorname;
    }

    public String getMajorremark() {
        return majorremark;
    }

    public void setMajorremark(String majorremark) {
        this.majorremark = majorremark;
    }

    @Override
    public String toString() {
        return "Major [majorid=" + majorid + ", deptid=" + deptid + ", majorname=" + majorname + ", majorremark="
                + majorremark + "]";
    }

}
