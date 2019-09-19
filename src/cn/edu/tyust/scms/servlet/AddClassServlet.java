package cn.edu.tyust.scms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.edu.tyust.scms.model.Classes;
import cn.edu.tyust.scms.service.ClassesService;
import cn.edu.tyust.scms.service.ClassesServiceImpl;

/**
 * Servlet implementation class AddClassServlet
 */
@WebServlet("/AddClassServlet")
public class AddClassServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClassServlet() {
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
        ClassesService classesService = new ClassesServiceImpl();

        String classid = request.getParameter("classid");
        String majorid = request.getParameter("major");
        String classname = request.getParameter("classname");
        String grade = request.getParameter("grade");
        String classremark = request.getParameter("remark");
        Classes clase = new Classes(classid, majorid, classname, grade, classremark);
        boolean result = classesService.addClass(clase);

        // 使用阿里的插件，转为JSON字符串
        String jsonStr = JSON.toJSONString(result);
//        System.out.println(jsonStr);
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
