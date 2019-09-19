/**
* @项目名称: J1012Web
* @文件名称: NetworkUtil.java
* @Date: 2019年8月7日
* @Copyright: 2019 www.xxx.com Inc. All rights reserved.
* 注意：本内容仅限于xxx公司内部传阅，禁止外泄以及用于其他的商业目的
*/
package cn.edu.tyust.scms.util;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * 常用获取客户端信息的工具
 * 
 * @author: liuhao
 * @version 1.0
 */
public final class NetworkUtil {
    /**
     * Logger for this class
     */
    private static Logger logger = Logger.getLogger(NetworkUtil.class);

    /**
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
     * 
     * @param request 请求
     * @return 请求者的IP
     */
    public final static String getIpAddress(HttpServletRequest request) {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址

        String ip = request.getHeader("X-Forwarded-For");
        if (logger.isInfoEnabled()) {
            logger.info("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if (logger.isInfoEnabled()) {
                    logger.info("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);
                }
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }

    /**
     * 使用HttpServletRequest获得客户机信息
     * 
     * @param request 用户请求
     */
    public final static void printRequestInfo(HttpServletRequest request) {
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println(NetworkUtil.getIpAddress(request));
        String requestUrl = request.getRequestURL().toString();// 得到请求的URL地址
        String requestUri = request.getRequestURI();// 得到请求的资源
        String queryString = request.getQueryString();// 得到请求的URL地址中附带的参数
        String remoteAddr = request.getRemoteAddr();// 得到来访者的IP地址
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String remoteUser = request.getRemoteUser();
        String method = request.getMethod();// 得到请求URL地址时使用的方法
        String pathInfo = request.getPathInfo();
        String localAddr = request.getLocalAddr();// 获取WEB服务器的IP地址
        String localName = request.getLocalName();// 获取WEB服务器的主机名

        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        System.out.println("获取到的客户机信息如下：");
        System.out.println("");
        System.out.println("请求的URL地址：" + requestUrl);
        System.out.println("");
        System.out.println("请求的资源：" + requestUri);
        System.out.println("");
        System.out.println("请求的URL地址中附带的参数：" + queryString);
        System.out.println("");
        System.out.println("来访者的IP地址：" + remoteAddr);
        System.out.println("");
        System.out.println("来访者的主机名：" + remoteHost);
        System.out.println("");
        System.out.println("使用的端口号：" + remotePort);
        System.out.println("");
        System.out.println("remoteUser：" + remoteUser);
        System.out.println("");
        System.out.println("请求使用的方法：" + method);
        System.out.println("");
        System.out.println("pathInfo：" + pathInfo);
        System.out.println("");
        System.out.println("localAddr：" + localAddr);
        System.out.println("");
        System.out.println("localName：" + localName);
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");

    }

}