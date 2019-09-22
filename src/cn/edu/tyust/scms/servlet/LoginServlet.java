package cn.edu.tyust.scms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import cn.edu.tyust.scms.model.Loginlog;
import cn.edu.tyust.scms.model.User;
import cn.edu.tyust.scms.service.LoginlogService;
import cn.edu.tyust.scms.service.LoginlogServiceImpl;
import cn.edu.tyust.scms.service.UserService;
import cn.edu.tyust.scms.service.UserServiceImpl;
import cn.edu.tyust.scms.util.EncodingUtil;
import cn.edu.tyust.scms.util.MyMD5Util;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        UserService userService = new UserServiceImpl();
        String jsonStr = JSON.toJSONString(null);

        // 用户操作状态
        String status = EncodingUtil.changeEncoding(request.getParameter("status"));
        // 用户登陆
        if (status.equals("login")) {
            // 记录用户登陆状态  1：登陆成功；  0：登陆失败 ； -1：用户被禁用
            int resultStatus = 0;
            // 获得验证参数（用户名以及密码）
            String username = EncodingUtil.changeEncoding(request.getParameter("username"));
            String userpwd = EncodingUtil.changeEncoding(request.getParameter("userpwd"));
            userpwd = MyMD5Util.getEncryptedPwd(userpwd);

            // 开始验证（true：密码正确，false：密码错误）
            boolean result = userService.checkUser(username, userpwd);
            if(result) {
                resultStatus = 1;// 先设置为登陆成功，接下来验证该用户是否被禁用
            }
            // 获取当前用户的所有信息，判断是否被禁用
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("username", username);
            map.put("userpwd", userpwd);
            List<User> userList = userService.selectUsers(map);
            User user = null;// 用户记录登陆者的信息
            if(userList.size() != 0) {
                user = userList.get(0);
                // 判断用户状态是否为禁用
                if(user.getStatus().equals("0")) {
                    resultStatus = -1;// 设置该用户被禁用的返回值
                    result = false;// 登陆失败
                }
            }
            
            // 用户登陆成功
            if (result) {
                // 判断是否勾选记住密码
                String rememberMe = EncodingUtil.changeEncoding(request.getParameter("rememberMe"));
                if (rememberMe.equals("true")) {
                    // 创建两个cookie，分别用于存放用户名以及密码
                    Cookie cookie1 = new Cookie("username", username);
                    Cookie cookie2 = new Cookie("userpwd", userpwd);
                    // 指定Cookie绑定的路径，注意：这里指定的路径要求必须添加上项目名称request.getcontextpath()
                    // cookie1.setPath(request.getContextPath() + "/username");
                    // cookie2.setPath(request.getContextPath() + "/userpwd");

                    // 设置Cookie有效期，参数为一个整型值，单位为秒
                    // 该值大于0，表示将Cookie存放到客户端的硬盘
                    // 该值小于0，与不设置效果相同，会将Cookie存放到浏览器缓存中
                    // 该值等于0，表示Cookie一生成，马上失效
                    cookie1.setMaxAge(60 * 60 * 24 * 10);// 设置Cookie有效期为10天
                    cookie2.setMaxAge(60 * 60 * 24);// 设置Cookie有效期为1天
                    // 向响应中添加Cookie
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);
                }

                if (user != null) {
                    HttpSession session = request.getSession();// 获取Sesson
                    session.setMaxInactiveInterval(60 * 30);// 设置session有效时间为30分钟
                    session.setAttribute("user", user);
                }
                // 记录登陆日志
                String userid = userList.get(0).getUserid();
                addLoginlog(userid, request);
            }
            jsonStr = JSON.toJSONString(resultStatus);
        }
        // 用户退出
        if (status.equals("exit")) {
            HttpSession session = request.getSession();// 获取Sesson
            // 从但当前sesson中取出userName属性
            session.setAttribute("user", null);
            session.removeAttribute("user");
            jsonStr = JSON.toJSONString("true");
        }

        out.print(jsonStr);
        out.close();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    /**
     * 保存登陆日志
     * 
     * @param userid  用户ID
     * @param request 请求对象
     */
    public void addLoginlog(String userid, HttpServletRequest request) {
        // 获取浏览器信息
        String ua = request.getHeader("User-Agent");
        // 转成UserAgent对象
        UserAgent userAgent = UserAgent.parseUserAgentString(ua);
        // 获取浏览器信息
        Browser browser = userAgent.getBrowser();
        // 获取系统信息
        OperatingSystem os = userAgent.getOperatingSystem();
        // 系统名称
        String system = os.getName();
        // 浏览器名称
        String browserName = browser.getName();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
        String datetime = df.format(new Date());// 获得当前日期

        // 获取登陆IP地址
        String loginip = request.getParameter("loginip");
        // 获取登陆地点
        String loginsite = request.getParameter("loginsite");

//        System.out.println("当前用户ID：" + userid);
//        System.out.println("当前日期：" + datetime);
//        System.out.println("登陆地点：" + loginsite);
//        System.out.println("登陆IP：" + loginip);
//        System.out.println("系统名称：" + system);
//        System.out.println("浏览器名称：" + browserName);

        Loginlog loginlog = new Loginlog(userid, datetime, loginsite, loginip, system, browserName, null);
//        System.out.println(loginlog);
        LoginlogService loginlogService = new LoginlogServiceImpl();
        loginlogService.addLoginlog(loginlog);
    }

}
