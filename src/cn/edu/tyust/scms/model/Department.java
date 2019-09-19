/**
* @项目名称: SCMS
* @文件名称: Department.java
* @Date: 2019年8月16日
* @Copyright: 2019 www.tyust.edu.cn Inc. All rights reserved.
* 注意：本内容仅限于ychs公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.model;

/**
 * 院系实体类
 * 
 * @author: liuhao
 * @version V1.0
 */
public class Department {
    private String deptid;
    private String deptname;
    private String deptremark;

    public Department() {
        super();
    }

    public Department(String deptid, String deptname, String deptremark) {
        super();
        this.deptid = deptid;
        this.deptname = deptname;
        this.deptremark = deptremark;
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

    public String getDeptremark() {
        return deptremark;
    }

    public void setDeptremark(String deptremark) {
        this.deptremark = deptremark;
    }

    @Override
    public String toString() {
        return "Department [deptid=" + deptid + ", deptname=" + deptname + ", deptremark=" + deptremark + "]";
    }

}
