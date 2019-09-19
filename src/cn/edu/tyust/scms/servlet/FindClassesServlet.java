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

import cn.edu.tyust.scms.model.ClassesInfo;
import cn.edu.tyust.scms.service.ClassesService;
import cn.edu.tyust.scms.service.ClassesServiceImpl;

/**
 * Servlet implementation class FinClassesServlet
 */
@WebServlet("/FindClassesServlet")
public class FindClassesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindClassesServlet() {
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
        Map<String, Object> map = new HashMap<String, Object>();
        int page = Integer.parseInt(request.getParameter("page"));// 获取当前页码
        int limit = Integer.parseInt(request.getParameter("limit"));// 获取每页条数

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

        // 得到满足条件的总记录条数
        int count = classesService.getClassNumber(map);
        // 得到数据可以分为多少页
        int pageNum = count / limit;
        if (count % limit != 0) {
            pageNum++;
        }
        // 确保删除时当前页会超过总页数
        if (page > pageNum) {
            page = pageNum;
            System.out.println(page);
        }
        // 查询满足条件的分页后的数据
        List<ClassesInfo> classesInfoList = classesService.findClasses(page, limit, map);

        JSONObject obj = new JSONObject();
        obj.put("code", 0);
        obj.put("msg", "");
        obj.put("count", count);
        obj.put("data", classesInfoList);
        String jsonStr = JSON.toJSONString(obj);

        /*********************** 第二种方式直接拼接 *********************************/
//        // 使用阿里的插件，转为JSON字符串
//        String jsonStr = JSON.toJSONString(classesInfoList);      
//        //"code": res.status, //解析接口状态
//        //"msg": res.message, //解析提示文本
//        //"count": res.total, //解析数据长度
//        //"data": res.data.item //解析数据列表
//        jsonStr = "{\"code\": 0,"
//                + "\"msg\": \"\","
//                + " \"count\": "+count+","
//                + " \"data\":"+jsonStr+"}";
        /************************************************************************/
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
