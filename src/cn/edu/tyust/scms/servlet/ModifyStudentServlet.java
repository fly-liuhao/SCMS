package cn.edu.tyust.scms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.edu.tyust.scms.model.Student;
import cn.edu.tyust.scms.service.StudentService;
import cn.edu.tyust.scms.service.StudentServiceImpl;

/**
 * Servlet implementation class ModifyStudentServlet
 */
@WebServlet("/ModifyStudentServlet")
public class ModifyStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyStudentServlet() {
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
        boolean result = false;

        String stuid = request.getParameter("stuid");
        String oldstuid = request.getParameter("oldstuid");
        String stuname = request.getParameter("stuname");
        String sex = request.getParameter("sex");
        String mobile = request.getParameter("mobile");
        String classid = request.getParameter("clase");
        Student student = new Student(stuid, classid, stuname, sex, mobile, oldstuid);
        result = studentService.modifyStudent(student);

        // 使用阿里的插件，转为JSON字符串
        String jsonStr = JSON.toJSONString(result);
        System.out.println(jsonStr);
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
