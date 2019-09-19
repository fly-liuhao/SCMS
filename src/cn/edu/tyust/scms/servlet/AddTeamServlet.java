package cn.edu.tyust.scms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import cn.edu.tyust.scms.model.StuTeamRelation;
import cn.edu.tyust.scms.model.Team;
import cn.edu.tyust.scms.model.User;
import cn.edu.tyust.scms.service.StuTeamRelationService;
import cn.edu.tyust.scms.service.StuTeamRelationServiceImpl;
import cn.edu.tyust.scms.service.StudentService;
import cn.edu.tyust.scms.service.StudentServiceImpl;
import cn.edu.tyust.scms.service.TeamService;
import cn.edu.tyust.scms.service.TeamServiceImpl;

/**
 * Servlet implementation class AddTeamServlet
 */
@WebServlet("/AddTeamServlet")
public class AddTeamServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeamServlet() {
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
        boolean result = false;

        String status = request.getParameter("status");
        if (status.equals("prepare")) {
            if (teamService.findTeamUnique("0")!=null) {
                result = true;
            } else {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
                String datetime = df.format(new Date());// 获得当前日期
                // 添加团队前先向数据库添加一条准备数据
                Team team = new Team("0", "xxx", "xxx", "xxx", "xxx", "xxx", datetime, "xxx");
                result = teamService.addTeam(team);
            }
        } else if (status.equals("add")) {
            StudentService studentService = new StudentServiceImpl();

            String teamid = request.getParameter("teamid");
            String competitionid = request.getParameter("competition");
            String teamgroup = request.getParameter("teamgroup");
            String teamname = request.getParameter("teamname");
            String adviser = request.getParameter("adviser");
            String award = request.getParameter("award");
            String leaderid = request.getParameter("leader");
            String leadername = studentService.getStunameByStuid(leaderid);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
            String registdate = df.format(new Date());// 获得当前日期

            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            if(user != null) {
                String registusername = user.getRealname();
                // 确定团队中的组长
                modifyStuRole(leaderid, teamid);
                // 真正添加团队（修改准备的团队记录）
                Team team = new Team(teamid, competitionid, teamgroup, teamname,leadername, adviser, registusername, registdate,
                        award);
                result = teamService.modifyTeam(team);
            }
        } else if (status.equals("modify")) {
            StudentService studentService = new StudentServiceImpl();

            String teamid = request.getParameter("teamid");
            String competitionid = request.getParameter("competition");
            String teamgroup = request.getParameter("teamgroup");
            String teamname = request.getParameter("teamname");
            String adviser = request.getParameter("adviser");
            String award = request.getParameter("award");
            String leaderid = request.getParameter("leader");
            String leadername = studentService.getStunameByStuid(leaderid);

            // 修改团队
            Team team = new Team(teamid, competitionid, teamgroup, teamname,leadername, adviser, null, null,
                        award);
            result = teamService.modifyTeam(team);
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

    /**
     * 确定小组组长
     * 
     * @param leaderid 组长ID
     * @param teamid 团队ID
     */
    public void modifyStuRole(String leaderid, String teamid) {
        String sturole = "组长";
        StuTeamRelation relation = new StuTeamRelation(leaderid, teamid, sturole);
        
        // 修改数据库
        StuTeamRelationService stuTeamRelationService = new StuTeamRelationServiceImpl();
        stuTeamRelationService.modifyStuTeamRelation(relation);
    }
}
