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

import cn.edu.tyust.scms.model.StatInfo;
import cn.edu.tyust.scms.service.StatInfoService;
import cn.edu.tyust.scms.service.StatInfoServiceImpl;

/**
 * Servlet implementation class FindStatInfoServlet
 */
@WebServlet("/FindStatInfoServlet")
public class FindStatInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindStatInfoServlet() {
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
        StatInfoService statInfoService = new StatInfoServiceImpl();
        List<StatInfo> statInfoList = null;
        int count = 0;

        String status = request.getParameter("status");
        if (status.equals("findstatinfo")) {
            int page = Integer.parseInt(request.getParameter("page"));// 获取当前页码
            int limit = Integer.parseInt(request.getParameter("limit"));// 获取每页条数
            Map<String, Object> map = new HashMap<String, Object>();
            String stuid = request.getParameter("stuid");
            if (!stuid.equals("")) {
                map.put("stuid", stuid);
            }
            String classid = request.getParameter("classid");
            if (!classid.equals("")) {
                map.put("classid", classid);
            }
            String majorid = request.getParameter("majorid");
            if (!majorid.equals("")) {
                map.put("majorid", majorid);
            }
            String grade = request.getParameter("grade");
            if (!grade.equals("")) {
                map.put("grade", grade);
            }
            String competitionid = request.getParameter("competitionid");
            if (!competitionid.equals("")) {
                map.put("competitionid", competitionid);
            }
            String adviser = request.getParameter("adviser");
            if (!adviser.equals("")) {
                map.put("adviser", adviser);
            }
            String award = request.getParameter("award");
            if (!award.equals("")) {
                map.put("award", award);
            }
            String daterange = request.getParameter("daterange");
            if (!daterange.equals("")) {
                String[] dateArray = daterange.split("~");
                String startdate = dateArray[0];
                String enddate = dateArray[1];
                map.put("startdate", startdate);
                map.put("enddate", enddate);
            }

            statInfoList = statInfoService.findStatInfos(page, limit, map);
            count = statInfoService.findStatInfoCount(map);
        }

        // 使用阿里的插件，转为JSON字符串
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count", count);
        obj.put("data", statInfoList);

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
