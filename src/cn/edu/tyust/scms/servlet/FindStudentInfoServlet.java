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

import cn.edu.tyust.scms.model.StudentInfo;
import cn.edu.tyust.scms.service.StudentService;
import cn.edu.tyust.scms.service.StudentServiceImpl;

/**
 * Servlet implementation class FindStudentInfoServlet
 */
@WebServlet("/FindStudentInfoServlet")
public class FindStudentInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindStudentInfoServlet() {
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
        StudentService studentService = new StudentServiceImpl();
        List<StudentInfo> studentInfoList = null;
        int count = 0;

        String status = request.getParameter("status");
        if (status.equals("addTeamBefore")) {
            studentInfoList = studentService.findStuInfosByTeam();
        } else if (status.equals("addTeamLater")) {
            String teamid = request.getParameter("teamid");
            studentInfoList = studentService.findStuInfosByTeamid(teamid);
        } else if (status.equals("findstudent")) {
            int page = Integer.parseInt(request.getParameter("page"));// 获取当前页码
            int limit = Integer.parseInt(request.getParameter("limit"));// 获取每页条数
            Map<String, Object> map = new HashMap<String, Object>();
            String stuid = request.getParameter("stuid");
            if (!stuid.equals("")) {
                map.put("stuid", stuid);
            } 
            String stuname = request.getParameter("stuname");
            if (!stuname.equals("")) {
                map.put("stuname", stuname);
            } 
            studentInfoList = studentService.findStudentInfos(page, limit, map);
            count = studentService.findStudentInfos(map).size();
        } else if (status.equals("findstuinfosbyteamid")) {
            String teamid = request.getParameter("teamid");
            studentInfoList = studentService.findStuInfosByTeamid(teamid);
        }

        // 使用阿里的插件，转为JSON字符串
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count", count);
        obj.put("data", studentInfoList);

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
