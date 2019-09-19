package cn.edu.tyust.scms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.edu.tyust.scms.model.StuTeamRelation;
import cn.edu.tyust.scms.service.StuTeamRelationService;
import cn.edu.tyust.scms.service.StuTeamRelationServiceImpl;

/**
 * Servlet implementation class AddStuTeamRelationServlet
 */
@WebServlet("/AddStuTeamRelationServlet")
public class AddStuTeamRelationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStuTeamRelationServlet() {
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
        StuTeamRelationService stuTeamRelationService = new StuTeamRelationServiceImpl();
        boolean result = false;

        // 准备数据
        String stuid = request.getParameter("stuid");
        String teamid = request.getParameter("teamid");
        String sturole = "组员";

        String status = request.getParameter("status");
        if (status.equals("check")) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("stuid", stuid);
            map.put("teamid", teamid);
            result = stuTeamRelationService.findStuTeamRelation(map).size() != 0 ? true : false;
        } else if (status.equals("add")) {
            // 添加到数据库
            StuTeamRelation relation = new StuTeamRelation(stuid, teamid, sturole);
            result = stuTeamRelationService.addStuTeamRelation(relation);
        }

        // 使用阿里的插件，转为JSON字符串
        String jsonStr = JSON.toJSONString(result);
        System.out.println(jsonStr);
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
