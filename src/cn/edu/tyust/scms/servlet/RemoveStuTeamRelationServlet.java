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

import cn.edu.tyust.scms.model.Team;
import cn.edu.tyust.scms.service.StuTeamRelationService;
import cn.edu.tyust.scms.service.StuTeamRelationServiceImpl;
import cn.edu.tyust.scms.service.TeamService;
import cn.edu.tyust.scms.service.TeamServiceImpl;

/**
 * Servlet implementation class RemoveStuTeamRelationServlet
 */
@WebServlet("/RemoveStuTeamRelationServlet")
public class RemoveStuTeamRelationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveStuTeamRelationServlet() {
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
        Map<String, Object> map = new HashMap<String, Object>();
        boolean result = false;

        String status = request.getParameter("status");
        if (status.equals("single")) {
            String teamid = request.getParameter("teamid");
            String stuid = request.getParameter("stuid");
            String stuname = request.getParameter("stuname");
            map.put("teamid", teamid);
            map.put("stuid", stuid);
            
            // 如果这个学生是该团队的组长，删除该成员后，该团队组长设为"无"
            TeamService teamService = new TeamServiceImpl();
            Team team =teamService.findTeamByTeamid(teamid);
            if(team.getLeader().equals(stuname)) {
                team.setLeader("无");
                teamService.modifyTeam(team);
            }
            
            
            result = stuTeamRelationService.removeStuTeamRelation(map);
        }
        if (status.equals("multiple")) {
            String teamid = request.getParameter("teamid");
            map.put("teamid", teamid);
            result = stuTeamRelationService.removeStuTeamRelation(map);
        }

        // 使用阿里的插件，转为JSON字符串
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
