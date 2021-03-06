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

import cn.edu.tyust.scms.model.Team;
import cn.edu.tyust.scms.model.TeamInfo;
import cn.edu.tyust.scms.service.TeamService;
import cn.edu.tyust.scms.service.TeamServiceImpl;

/**
 * Servlet implementation class FindTeamServlet
 */
@WebServlet("/FindTeamServlet")
public class FindTeamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindTeamServlet() {
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
        TeamService teamService = new TeamServiceImpl();
        Map<String, Object> map = new HashMap<String, Object>();
        String jsonStr = "";

        String status = request.getParameter("status");
        if (status.equals("addteambefor")) {
            // 获取团队的ID
            Team team = teamService.findTeamUnique("0");
            jsonStr = JSON.toJSONString(team);
        } else if (status.equals("addteamlater")) {
            int page = Integer.parseInt(request.getParameter("page"));// 获取当前页码
            int limit = Integer.parseInt(request.getParameter("limit"));// 获取每页条数
            String teamname = request.getParameter("teamname");
            if (!teamname.equals("")) {
                map.put("teamname", teamname);
            }
            String competitionname = request.getParameter("competitionname");
            if (!competitionname.equals("")) {
                map.put("competitionname", competitionname);
            }
            String adviser = request.getParameter("adviser");
            if (!adviser.equals("")) {
                map.put("adviser", adviser);
            }
            List<TeamInfo> teamList = teamService.findTeamInfos(page, limit, map);
            int count = teamService.findTeamInfos(map).size();
            JSONObject obj = new JSONObject();
            obj.put("code", 0);
            obj.put("msg", "");
            obj.put("count", count);
            obj.put("data", teamList);
            jsonStr = JSON.toJSONString(obj);
        }

        // System.out.println(jsonStr);
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
