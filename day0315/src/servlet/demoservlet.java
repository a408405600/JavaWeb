package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet( "/demo")
public class demoservlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("http://www.baidu.com");
        Date now = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日 hh:mm:ss");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Refresh","1");
        response.getWriter().println(sf.format(now));
    }
}
