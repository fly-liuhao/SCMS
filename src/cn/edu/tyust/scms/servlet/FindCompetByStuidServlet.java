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
import com.alibaba.fastjson.JSONObject;

import cn.edu.tyust.scms.model.StuCompetition;
import cn.edu.tyust.scms.service.StudentService;
import cn.edu.tyust.scms.service.StudentServiceImpl;

/**
 * Servlet implementation class FindCompetByStuid
 */
@WebServlet("/FindCompetByStuidServlet")
public class FindCompetByStuidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindCompetByStuidServlet() {
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
	    String stuid = request.getParameter("stuid");
	    List<StuCompetition> stucompetList = studentService.findStudentCompetitions(stuid);
	    
        // 使用阿里的插件，转为JSON字符串
        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("data", stucompetList);

        String jsonStr = JSON.toJSONString(obj);
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
