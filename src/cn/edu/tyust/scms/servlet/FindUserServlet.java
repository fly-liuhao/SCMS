package cn.edu.tyust.scms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.edu.tyust.scms.model.User;
import cn.edu.tyust.scms.service.UserService;
import cn.edu.tyust.scms.service.UserServiceImpl;

/**
 * Servlet implementation class FindUserServlet
 */
@WebServlet("/FindUserServlet")
public class FindUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        UserService userService = new UserServiceImpl();
        Map<String, Object> map = new HashMap<String, Object>();

        String username = request.getParameter("username");
        if(!username.equals("")) {
            map.put("username", username);
        }
        String realname = request.getParameter("realname");
        if(!realname.equals("")) {
            map.put("realname", realname);
        }
        String userrole = request.getParameter("userrole");
        if(!userrole.equals("")) {
            map.put("userrole", userrole);
        }
        
        List<User> userList = userService.selectUsers(map);
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("data", userList);
	    
        // 使用阿里的插件，转为JSON字符串
        String jsonStr = JSON.toJSONString(obj);
        out.print(jsonStr);
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
