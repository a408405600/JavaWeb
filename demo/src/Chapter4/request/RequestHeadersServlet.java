package Chapter4.request;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


public class RequestHeadersServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out =  response.getWriter();
        //获取请求信息中所有头字段
        Enumeration headerNames = request.getHeaderNames();
        //使用循环遍历所有请求头，并通过getHeader() 方法获取一个指定名称的头字段
        while (headerNames.hasMoreElements()){
            String headerName = (String)headerNames.nextElement();
            out.println(headerName+":"+request.getHeader(headerName)+"<br />");
        }
    }
}
