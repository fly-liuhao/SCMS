package cn.edu.tyust.scms.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.edu.tyust.scms.model.StuTeamRelation;
import cn.edu.tyust.scms.service.StuTeamRelationService;
import cn.edu.tyust.scms.service.StuTeamRelationServiceImpl;

/**
 * Servlet implementation class ModifyStuTeamRelationServlet
 */
@WebServlet("/ModifyStuTeamRelationServlet")
public class ModifyStuTeamRelationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyStuTeamRelationServlet() {
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
        StuTeamRelationService stuTeamRelationService = new StuTeamRelationServiceImpl();
        boolean result = false;

        String status = request.getParameter("status");
        if (status.equals("modifystuid")) {
            // 准备数据
            String stuid = request.getParameter("stuid");
            String oldstuid = request.getParameter("oldstuid");
            result = stuTeamRelationService.modifyStuTeamRelationInStuid(stuid, oldstuid);
        } else if (status.equals("modifysturole")) {
            // 准备数据
            String teamid = request.getParameter("teamid");
            String oldstuid = request.getParameter("oldstuid");
            String oldsturole = "组员";
            String stuid = request.getParameter("stuid");
            String sturole = "组长";
            if (stuid.equals(oldstuid)) {
                result = true;
            } else {
                // 首先将之前的组长改为组员
                StuTeamRelation oldrelation = new StuTeamRelation(oldstuid, teamid, oldsturole);
                System.out.println("oldrelation"+oldrelation);
                boolean result1 = stuTeamRelationService.modifyStuTeamRelation(oldrelation);

                // 将新选定的组长设置成组长
                StuTeamRelation relation = new StuTeamRelation(stuid, teamid, sturole);
                System.out.println("relation"+relation);
                boolean result2 = stuTeamRelationService.modifyStuTeamRelation(relation);
                if (result1 == true && result2 == true) {
                    result = true;
                } else {
                    result = false;
                }
            }
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
    
    public static void main(String[] args) {
        StuTeamRelationService stuTeamRelationService = new StuTeamRelationServiceImpl();
        StuTeamRelation oldrelation = new StuTeamRelation("162056225", "13", "组员");
        boolean result1 = stuTeamRelationService.modifyStuTeamRelation(oldrelation);
        System.out.println(result1);
    }

}
