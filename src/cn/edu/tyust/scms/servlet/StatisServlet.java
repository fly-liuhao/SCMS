package cn.edu.tyust.scms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;

import cn.edu.tyust.scms.model.LoginlogInfo;
import cn.edu.tyust.scms.model.User;
import cn.edu.tyust.scms.service.LoginlogService;
import cn.edu.tyust.scms.service.LoginlogServiceImpl;
import cn.edu.tyust.scms.service.StatInfoService;
import cn.edu.tyust.scms.service.StatInfoServiceImpl;
import cn.edu.tyust.scms.service.StudentService;
import cn.edu.tyust.scms.service.StudentServiceImpl;

/**
 * Servlet implementation class StatisServlet
 */
@WebServlet("/StatisServlet")
public class StatisServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatisServlet() {
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
        StudentService studentService = new StudentServiceImpl();
        StatInfoService statInfoService = new StatInfoServiceImpl();
        LoginlogService loginlogService = new LoginlogServiceImpl();
        String result = null;
        String jsonStr = JSON.toJSONString(result);
        
        String status = request.getParameter("status");
        if (status.equals("getStuNum")) {
            result = studentService.findStudentInfos(null).size()+""; 
            jsonStr = JSON.toJSONString(result);
        } else if (status.equals("getWinNum")) {
            Map<String, Object> map1 = new HashMap<String, Object>();
            map1.put("award", "未获奖");
            Map<String, Object> map2 = new HashMap<String, Object>();
            map2.put("award", "待定");
            result = statInfoService.findStatInfoCount(null)-statInfoService.findStatInfoCount(map1)-statInfoService.findStatInfoCount(map2)+"";
            jsonStr = JSON.toJSONString(result);
        } else if (status.equals("getLoserNum")) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("award", "未获奖");
            result = statInfoService.findStatInfoCount(map)+"";
            jsonStr = JSON.toJSONString(result);
        } else if(status.equals("getLoginlog")) {
            HttpSession session = request.getSession();
            User loginuser = (User) session.getAttribute("user");
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userid", loginuser.getUserid());
            List<LoginlogInfo> loginlogInfoList = loginlogService.findLoginlogInfos(map);
            jsonStr = JSON.toJSONString(loginlogInfoList);
        } else if(status.equals("histogram_1")) {
            Map<String, Object> map = new HashMap<String, Object>();
            List<Integer> countList = new ArrayList<Integer>();
            int count = 0;
            String competitionid = request.getParameter("competitionid");
            if (!competitionid.equals("")) {
                map.put("competitionid", competitionid);
            }
            String daterange = request.getParameter("daterange");
            if (!daterange.equals("")) {
                String[] dateArray = daterange.split("~");
                String startdate = dateArray[0];
                String enddate = dateArray[1];
                map.put("startdate", startdate);
                map.put("enddate", enddate);
            }
            map.put("majorid", "52");
            count = statInfoService.findStatInfoCount(map);
            countList.add(count);
            map.put("majorid", "53");
            count = statInfoService.findStatInfoCount(map);
            countList.add(count);
            map.put("majorid", "54");
            count = statInfoService.findStatInfoCount(map);
            countList.add(count);
            map.put("majorid", "55");
            count = statInfoService.findStatInfoCount(map);
            countList.add(count);
            map.put("majorid", "56");
            count = statInfoService.findStatInfoCount(map);
            countList.add(count);
            jsonStr = JSON.toJSONString(countList);
        } else if(status.equals("histogram_2")) {
            Map<String, Object> map = new HashMap<String, Object>();
            List<Integer> countList = new ArrayList<Integer>();
            int count = 0;
            String competitionid = request.getParameter("competitionid");
            if (!competitionid.equals("")) {
                map.put("competitionid", competitionid);
            }
            String daterange = request.getParameter("daterange");
            if (!daterange.equals("")) {
                String[] dateArray = daterange.split("~");
                String startdate = dateArray[0];
                String enddate = dateArray[1];
                map.put("startdate", startdate);
                map.put("enddate", enddate);
            }
            
            map.put("majorid", "52");
            count = statInfoService.findWinStatInfo(map).size();
            countList.add(count);
            map.put("majorid", "53");
            count = statInfoService.findWinStatInfo(map).size();
            countList.add(count);
            map.put("majorid", "54");
            count = statInfoService.findWinStatInfo(map).size();
            countList.add(count);
            map.put("majorid", "55");
            count = statInfoService.findWinStatInfo(map).size();
            countList.add(count);
            map.put("majorid", "56");
            count = statInfoService.findWinStatInfo(map).size();
            countList.add(count);
            jsonStr = JSON.toJSONString(countList);
        } else if(status.equals("pie_1")) {
            Map<String, Object> map = new HashMap<String, Object>();
            List<Integer> countList = new ArrayList<Integer>();
            int count = 0;
            String competitionid = request.getParameter("competitionid");
            if (!competitionid.equals("")) {
                map.put("competitionid", competitionid);
            }
            String majorid = request.getParameter("majorid");
            if (!majorid.equals("")) {
                map.put("majorid", majorid);
            }
            String classid = request.getParameter("classid");
            if (!classid.equals("")) {
                map.put("classid", classid);
            }
            int year = new Date().getYear()+1900;
            if((new Date().getMonth()+1) < 9) {
                year--;
            }
            countList.add(year);
            
            map.put("grade", year-- + "");
            count = statInfoService.findStatInfoCount(map);
            countList.add(count);
            map.put("grade", year-- + "");
            count = statInfoService.findStatInfoCount(map);
            countList.add(count);
            map.put("grade", year-- + "");
            count = statInfoService.findStatInfoCount(map);
            countList.add(count);
            map.put("grade", year-- + "");
            count = statInfoService.findStatInfoCount(map);
            countList.add(count);
            
            jsonStr = JSON.toJSONString(countList);
        } else if(status.equals("pie_2")) {
            Map<String, Object> map = new HashMap<String, Object>();
            List<Integer> countList = new ArrayList<Integer>();
            int count = 0;
            String competitionid = request.getParameter("competitionid");
            if (!competitionid.equals("")) {
                map.put("competitionid", competitionid);
            }
            String grade = request.getParameter("grade");
            if (!grade.equals("")) {
                map.put("grade", grade);
            }
            String majorid = request.getParameter("majorid");
            if (!majorid.equals("")) {
                map.put("majorid", majorid);
            }
            String classid = request.getParameter("classid");
            if (!classid.equals("")) {
                map.put("classid", classid);
            }
            
            map.put("award", "待定");
            count = statInfoService.findStatInfoCount(map);
            countList.add(count);
            map.put("award", "特等奖");
            count = statInfoService.findStatInfoCount(map);
            countList.add(count);
            map.put("award", "一等奖");
            count = statInfoService.findStatInfoCount(map);
            countList.add(count);
            map.put("award", "二等奖");
            count = statInfoService.findStatInfoCount(map);
            countList.add(count);
            map.put("award", "三等奖");
            count = statInfoService.findStatInfoCount(map);
            countList.add(count);
            map.put("award", "优秀奖");
            count = statInfoService.findStatInfoCount(map);
            countList.add(count);
            map.put("award", "未获奖");
            count = statInfoService.findStatInfoCount(map);
            countList.add(count);
            
            jsonStr = JSON.toJSONString(countList);
        }
        
        
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
