package cn.edu.tyust.scms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
import cn.edu.tyust.scms.service.StudentService;
import cn.edu.tyust.scms.service.StudentServiceImpl;

/**
 * Servlet implementation class RemoveStudentSevlet
 */
@WebServlet("/RemoveStudentServlet")
public class RemoveStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveStudentServlet() {
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
        StuTeamRelationService stuTeamRelationService = new StuTeamRelationServiceImpl();
        Map<String, Object> map = new HashMap<String, Object>();
        boolean result = false;

        String status = request.getParameter("status");
        if (status.equals("single")) {
            String stuid = request.getParameter("stuid");
            map.put("stuid", stuid);
            if(stuTeamRelationService.findStuTeamRelation(map).size() == 1) {
                result = studentService.removeStudent(stuid);
            }else {
                result = true;
            }
        }
        if (status.equals("multiple")) {
            String teamid = request.getParameter("teamid");
            map.put("teamid", teamid);
            List<StuTeamRelation> relationList = stuTeamRelationService.findStuTeamRelation(map);
            List<String> stuIDList = new ArrayList<String>();
            Map<String, Object> map2 = new HashMap<String, Object>();
            for (StuTeamRelation relation : relationList) {
                System.out.println(relation);
                map2.put("stuid", relation.getStuid());
                if(stuTeamRelationService.findStuTeamRelation(map2).size() == 1) {
                    stuIDList.add(relation.getStuid());
                }
            }
            result = studentService.removeStudentList(stuIDList);
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
