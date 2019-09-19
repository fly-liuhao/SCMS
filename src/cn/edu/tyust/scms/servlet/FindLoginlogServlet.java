package cn.edu.tyust.scms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

import cn.edu.tyust.scms.model.LoginlogInfo;
import cn.edu.tyust.scms.service.LoginlogService;
import cn.edu.tyust.scms.service.LoginlogServiceImpl;

/**
 * Servlet implementation class FindLoginlogServlet
 */
@WebServlet("/FindLoginlogServlet")
public class FindLoginlogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindLoginlogServlet() {
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
        LoginlogService loginlogService = new LoginlogServiceImpl();
        List<LoginlogInfo> loginlogInfoList = new ArrayList<LoginlogInfo>();
        Map<String, Object> map = new HashMap<String, Object>();

        String status = request.getParameter("status");
        if (status.equals("look")) {
            String userid = request.getParameter("userid");
            map.put("userid", userid);
            loginlogInfoList = loginlogService.findLoginlogInfos(map);
        } else if (status.equals("search")) {
            String username = request.getParameter("username");
            if (!username.equals("")) {
                map.put("username", username);
            }
            String realname = request.getParameter("realname");
            if (!realname.equals("")) {
                map.put("realname", realname);
            }
            loginlogInfoList = loginlogService.findLoginlogInfos(map);
        }
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("data", loginlogInfoList);
        String jsonStr = JSON.toJSONString(obj);
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
