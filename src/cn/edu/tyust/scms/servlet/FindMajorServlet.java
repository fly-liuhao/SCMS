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

import cn.edu.tyust.scms.model.Major;
import cn.edu.tyust.scms.service.MajorService;
import cn.edu.tyust.scms.service.MajorServiceImpl;
import cn.edu.tyust.scms.util.EncodingUtil;

/**
 * Servlet implementation class FindMajorServlet
 */
@WebServlet("/FindMajorServlet")
public class FindMajorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindMajorServlet() {
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
        MajorService majorService = new MajorServiceImpl();
        Map<String, Object> map = new HashMap<String, Object>();
        String deptid = EncodingUtil.changeEncoding(request.getParameter("deptid"));
        if(deptid.equals("")) {
            // 防止未选择班级就查询全部专业
            map.put("deptid", "xxxxx");
        }else {
            map.put("deptid", deptid);
        }

        List<Major> majorList = majorService.findMajors(map);
        // 使用阿里的插件，转为JSON字符串
        String jsonStr = JSON.toJSONString(majorList);
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
