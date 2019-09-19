package cn.edu.tyust.scms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.edu.tyust.scms.model.Competition;
import cn.edu.tyust.scms.service.CompetitionService;
import cn.edu.tyust.scms.service.CompetitionServiceImpl;

/**
 * Servlet implementation class ModifyCompetitionServlet
 */
@WebServlet("/ModifyCompetitionServlet")
public class ModifyCompetitionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyCompetitionServlet() {
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

        String competitionid = request.getParameter("competitionid");
        String competitionname = request.getParameter("competitionname");
        String competitiondate = request.getParameter("competitiondate")+"-01";
        String competitionlevel = request.getParameter("competitionlevel");
        String competitiontype = request.getParameter("competitiontype");
        String competitiondescribe = request.getParameter("competitiondescribe");
        Competition competition = new Competition(competitionid, competitionname, competitiondate, competitionlevel,
                competitiontype, competitiondescribe);
        boolean result = competitionService.modifyCompetition(competition);

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
