package cn.edu.tyust.scms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class FindCompetitionAllServlet
 */
@WebServlet("/FindCompetitionAllServlet")
public class FindCompetitionAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCompetitionAllServlet() {
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
        CompetitionService competitionService = new CompetitionServiceImpl();
        // 得到所有赛事，并排序（时间降序）
        List<Competition> competitionList = competitionService.findCompetitions(null);
        String jsonStr = JSON.toJSONString(competitionList);

        // System.out.println(jsonStr);
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
