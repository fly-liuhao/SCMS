package cn.edu.tyust.scms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import cn.edu.tyust.scms.model.User;
import cn.edu.tyust.scms.service.UserService;
import cn.edu.tyust.scms.service.UserServiceImpl;
import cn.edu.tyust.scms.util.EncodingUtil;

/**
 * Servlet implementation class AutoLoginServlet
 */
@WebServlet("/AutoLoginServlet")
public class AutoLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoLoginServlet() {
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

        String username = EncodingUtil.changeEncoding(request.getParameter("username"));
        String userpwd = EncodingUtil.changeEncoding(request.getParameter("userpwd"));
        
        HttpSession session = request.getSession();
        User loginuser = (User) session.getAttribute("user");

        boolean result = userService.checkUser(username, userpwd);
        if (result && loginuser!=null) {
            System.out.println("自动登陆成功！");
        } else {
            Cookie cookie1 = new Cookie("username", null);
            Cookie cookie2 = new Cookie("userpwd", null);
            cookie1.setMaxAge(0);// 设置Cookie有效期为0毫秒
            cookie2.setMaxAge(0);// 设置Cookie有效期为0毫秒
            // 向响应中添加Cookie（实际是覆盖）
            response.addCookie(cookie1);
            response.addCookie(cookie2);
            result = false;
        }
        String jsonStr = JSON.toJSONString(result);

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

}
