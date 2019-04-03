package net;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "Servlet02")
public class Servlet02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig servletConfig = this.getServletConfig();
        String initParameter = servletConfig.getInitParameter("ip");

        int post = Integer.parseInt(servletConfig.getInitParameter("port"));
        System.out.println(initParameter+":"+post);
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()){
            String s = initParameterNames.nextElement();
            System.out.println(s+":"+servletConfig.getInitParameter(s));
        }


    }


    //读配置文件 jdbc.properties
    //username=root
    //password=123456
    //url=jdbc:mysql:///itcast
    //servlet读出来,生成xml文件
    //<jdbc><username>root</usrname><password>123456</password><url>qwqq</url><jdbc>

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        doPost(request,response);
    }
}
