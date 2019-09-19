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

import cn.edu.tyust.scms.model.ClassesInfo;
import cn.edu.tyust.scms.service.ClassesService;
import cn.edu.tyust.scms.service.ClassesServiceImpl;

/**
 * Servlet implementation class FindClassByMajorServlet
 */
@WebServlet("/FindClassByMajorServlet")
public class FindClassByMajorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindClassByMajorServlet() {
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
        ClassesService classesService = new ClassesServiceImpl();
        Map<String, Object> map = new HashMap<String, Object>();
        
        String majorid = request.getParameter("majorid");
        if (!majorid.equals("")) {
            map.put("majorid", majorid);
        }
        String grade = request.getParameter("grade");
        if (!grade.equals("")) {
            map.put("grade", grade);
        }
        
        int count = classesService.getClassNumber(map);
        List<ClassesInfo> classesInfoList = classesService.findClasses(1, count, map);
        
        
        String jsonStr = JSON.toJSONString(classesInfoList);
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
