package cn.edu.tyust.scms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.edu.tyust.scms.model.ClassesInfo;
import cn.edu.tyust.scms.service.ClassesService;
import cn.edu.tyust.scms.service.ClassesServiceImpl;
import cn.edu.tyust.scms.util.JsonToJavaBeanUtil;

/**
 * Servlet implementation class RemoveClassSevlet
 */
@WebServlet("/RemoveClassSevlet")
public class RemoveClassSevlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveClassSevlet() {
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
        boolean result = false;

        String status = request.getParameter("status");
        if (status.equals("single")) {
            String classid = request.getParameter("classid");
            result = classesService.removeClass(classid);
        }
        if (status.equals("multiple")) {
            String classlist = request.getParameter("classlist");
            System.out.println(classlist);

            // 将前端传来的JSON数组字符串转化为List集合（内置对象）
            List<ClassesInfo> classInfoList = JsonToJavaBeanUtil.jsonToJavaBean(classlist, ClassesInfo.class);
            List<String> classIDList = new ArrayList<String>();
            for (ClassesInfo classesInfo : classInfoList) {
                //System.out.println(classesInfo);
                classIDList.add(classesInfo.getClassid());
            }
            result = classesService.removeClassList(classIDList);
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
