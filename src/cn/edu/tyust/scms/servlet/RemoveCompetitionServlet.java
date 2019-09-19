package cn.edu.tyust.scms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.edu.tyust.scms.model.Competition;
import cn.edu.tyust.scms.service.CompetitionService;
import cn.edu.tyust.scms.service.CompetitionServiceImpl;
import cn.edu.tyust.scms.util.JsonToJavaBeanUtil;

/**
 * Servlet implementation class RemoveCompetitionServlet
 */
@WebServlet("/RemoveCompetitionServlet")
public class RemoveCompetitionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveCompetitionServlet() {
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
        CompetitionService competitionService = new CompetitionServiceImpl();
        boolean result = false;

        String status = request.getParameter("status");
        if (status.equals("single")) {
            String competitionid = request.getParameter("competitionid");
            result = competitionService.removeCompetition(competitionid);
        }
        if (status.equals("multiple")) {
            String competitionlistStr = request.getParameter("competitionlist");
            System.out.println(competitionlistStr);

            // 将前端传来的JSON数组字符串转化为List集合（内置对象）
            List<Competition> competitionList = JsonToJavaBeanUtil.jsonToJavaBean(competitionlistStr, Competition.class);
            List<String> competitionIDList = new ArrayList<String>();
            for (Competition competition : competitionList) {
                System.out.println(competition);
                competitionIDList.add(competition.getCompetitionid());
            }
            result = competitionService.removeCompetitionList(competitionIDList);
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
