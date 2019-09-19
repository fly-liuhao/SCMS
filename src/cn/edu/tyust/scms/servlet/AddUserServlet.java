package cn.edu.tyust.scms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.edu.tyust.scms.model.User;
import cn.edu.tyust.scms.service.UserService;
import cn.edu.tyust.scms.service.UserServiceImpl;
import cn.edu.tyust.scms.util.MyMD5Util;

/**
 * Servlet implementation class AddUserServlct
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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
        String username = request.getParameter("username");
        String userpwd = request.getParameter("userpwd");
        userpwd = MyMD5Util.getEncryptedPwd(userpwd);
        String role = request.getParameter("role");
        String realname = request.getParameter("realname");
        String remark = request.getParameter("remark");
        User user = new User(role, username, userpwd, realname, remark);
        boolean result = userService.insertUser(user);
        
        // 使用阿里的插件，转为JSON字符串
        String jsonStr = JSON.toJSONString(result);
        System.out.println(jsonStr);
        out.print(jsonStr);
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

}
