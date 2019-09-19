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

import cn.edu.tyust.scms.model.Competition;
import cn.edu.tyust.scms.service.CompetitionService;
import cn.edu.tyust.scms.service.CompetitionServiceImpl;

/**
 * Servlet implementation class FindCompetitionServlet
 */
@WebServlet("/FindCompetitionServlet")
public class FindCompetitionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCompetitionServlet() {
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
        Map<String, Object> map = new HashMap<String, Object>();
        int page = Integer.parseInt(request.getParameter("page"));// 获取当前页码
        int limit = Integer.parseInt(request.getParameter("limit"));// 获取每页条数

        String competitionname = request.getParameter("competitionname");
        if (!competitionname.equals("")) {
            map.put("competitionname", competitionname);
        }
        String daterange = request.getParameter("daterange");
        if (!daterange.equals("")) {
            String[] dateArray = daterange.split("~");
            String startdate = dateArray[0];
            String enddate = dateArray[1];
            map.put("startdate", startdate);
            map.put("enddate", enddate);
        }
        String competitionlevel = request.getParameter("competitionlevel");
        if (!competitionlevel.equals("")) {
            map.put("competitionlevel", competitionlevel);
        }
        String competitiontype = request.getParameter("competitiontype");
        if (!competitiontype.equals("")) {
            map.put("competitiontype", competitiontype);
        }

        // 得到满足条件的总记录条数
        int count = competitionService.getCompetitionNumber(map);
        // 得到数据可以分为多少页
        int pageNum = count / limit;
        if (count % limit != 0) {
            pageNum++;
        }
        // 确保删除时当前页会超过总页数
        if (page > pageNum) {
            page = pageNum;
            System.out.println(page);
        }
        // 查询满足条件的分页后的数据
        List<Competition> competitionList = competitionService.findCompetitions(page, limit, map);

        JSONObject obj = new JSONObject();

        obj.put("code", 0);// "code": res.status, //解析接口状态
        obj.put("msg", "");// "msg": res.message, //解析提示文本
        obj.put("count", count);// "count": res.total, //解析数据长度
        obj.put("data", competitionList);// "data": res.data.item //解析数据列表
        String jsonStr = JSON.toJSONString(obj);

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
