package cn.edu.tyust.scms.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.edu.tyust.scms.model.User;

/**
 * https://blog.csdn.net/yuzhiqiang_1993/article/details/81288912
 * 
 * Servlet Filter implementation class AccessPermissionFilter
 */
//@WebFilter(filterName ="/AccessPermissionFilter",urlPatterns = {"/main.jsp"})
public class AccessPermissionFilter implements Filter {

    /**
     * Default constructor.
     */
    public AccessPermissionFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("accessPermissionFilter访问权限过滤器正在销毁......");
        System.out.println("--------------------------------------------------");
        System.out.println();
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("进入到accessPermissionFilter访问权限过滤器：doFilter() 方法~");
        System.out.println("--------------------------------------------------");
        System.out.println();
        
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        HttpServletResponse httpServletResponse = (HttpServletResponse)response;
        HttpSession session = httpServletRequest.getSession();
        User user = (User)session.getAttribute("user");
        System.out.println(user);
        if(user == null) {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() +  "/login.html");
        }else if(user.getStatus().equals("0")){
            session.setAttribute("user", null);
            session.removeAttribute("user");
            Cookie cookie = new Cookie("userpwd", null);
            cookie.setMaxAge(-1);
            httpServletResponse.addCookie(cookie);
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() +  "/login.html");
        } else {
            System.out.println("chain.doFilter被调用后输出的...");
            chain.doFilter(request, response);
        }
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("accessPermissionFilter访问权限过滤器初始化......");
        System.out.println("--------------------------------------------------");
        System.out.println();

    }

}
