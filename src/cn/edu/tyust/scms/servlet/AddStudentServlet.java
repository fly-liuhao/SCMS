package cn.edu.tyust.scms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

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
 * Servlet implementation class AddStudentServlet
 */
@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentServlet() {
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
        boolean result = false;

        String status = request.getParameter("status");
        if(status.equals("check")) {
            Map<String, Object> map = new HashMap<String, Object>();
            String stuid = request.getParameter("stuid");
            map.put("stuid", stuid);
            result = studentService.findStudents(map).size() != 0 ? true : false;
        } else if (status.equals("add")) {
            String stuid = request.getParameter("stuid");
            String stuname = request.getParameter("stuname");
            String sex = request.getParameter("sex");
            String mobile = request.getParameter("mobile");
            String classid = request.getParameter("clase");
            Student student = new Student(stuid, classid, stuname, sex, mobile);
            result = studentService.addStudent(student);
        }
        
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
