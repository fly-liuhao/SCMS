## 太原科技大学创新竞赛管理平台
###  一、登陆访问
- 项目演示：[[项目入口：点击进入]](http://119.3.62.93/:8080/SCMS/)
- 普通用户：
   - 用户名：`user`密码：`123456`
- 管理员：
   - 用户名：`admin`  密码：`123456`
    		- 用户名：`super`  密码：`123456`

### 二、项目实现
#### （一）前端设计
- 参考网友开源的前端Layui模板：[[查看请移步]](https://gitee.com/zhongshaofa/layuimini)
  > 界面设计的个人很喜欢，感谢这个网友，大家可以多多 star、fork 支持一下

- 放上一张界面图
	![Layui模板界面](https://gitee.com/fly-liuhao/Image/raw/master/SCMS/LayuiTemplate.png)

####  （二）系统模块
1. 登陆
	![登陆界面](https://gitee.com/fly-liuhao/Image/raw/master/SCMS/login.png)
2. 班级管理
	包括添加班级和查询班级，其中查询搬家中，可以对查询到的纪律进行修改以及删除，还可通过左侧勾选框进行批量删除	
	![查询班级界面](https://gitee.com/fly-liuhao/Image/raw/master/SCMS/findclass.png)
2. 赛事管理
	同上，包含查询班级和删除班级
	![查询赛事界面](https://gitee.com/fly-liuhao/Image/raw/master/SCMS/competition.png)
3. 团队管理
- 这里是本项目的难点，因为是团队和成员是多对多的关系，所以添加的过程中逻辑上需要好好考虑一下怎么实现，我是先在，我是先再`team`表中添加一条记录（进入参加团队是会添加，且织田家一次），之后没添加一个学生就分别添向`student`表和`stu_team`表（关系表）添加一条数据，之后团队数据，点击提交会将`team`表中虚线准备好的数据进行修改，继而完成团队的录入。
	![录入团队界面](https://gitee.com/fly-liuhao/Image/raw/master/SCMS/addteam.png)
	![查询团队界面](https://gitee.com/fly-liuhao/Image/raw/master/SCMS/finteam.png)
4. 查询统计
- 此部分用到了ECharts，没用过的小伙伴可以看一下项目中的源码是怎么使用的
	![统计图表界面](https://gitee.com/fly-liuhao/Image/raw/master/SCMS/statistic.png)
5. 用户管理
- 包含基础的添加和查看用户，有一个亮点就是可以查看用户最近的登陆记录（包含：登陆IP、登陆地点、登陆时间、登陆使用的操作系统、以及登陆所使用的浏览器）
  ![用户管理界面](https://gitee.com/fly-liuhao/Image/raw/master/SCMS/user.png)
  ![用户登陆日志界面](https://gitee.com/fly-liuhao/Image/raw/master/SCMS/loginlog.png)


### 二、项目部署
#### （一）环境
1. 软件环境
- JDK 1.8.0_211
- Tomcat 8.5.43
- MySQL 8.0.13
2. 硬件环境
- Windows 10
- Linux Ubuntu
3. 开发环境
- Eclipse

#### （二）部署流程
1. 创建`scms`数据库（注意编码，使用utf-8）,运行SQL文件创建相关表和视图
2. 向Tomcat中部署SCMC.war到webapps目录下，如果需要修改数据库密码 / 连接字符，串，打开WAR包找到文件：`WEB-INF/classes/jdbc.properties`修改即可
3. 启动Tomcat，访问项目（`http://localhost(或者自己的服务器IP):8080/SCMS/`）
