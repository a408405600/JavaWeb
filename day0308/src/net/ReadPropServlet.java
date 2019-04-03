package net;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet( "/toXML")
public class ReadPropServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/xml;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        out.println("<jdbc>");
        InputStream is = getServletContext().getResourceAsStream("/WEB_INF/classes/jdbc.properties");
        Properties ps=new Properties();
        ps.load(is);
        String username = ps.getProperty("username");
        String password = ps.getProperty("password");
        out.println("<username>");
        out.println(username);
        out.println("</username>");
        out.println("<password>");
        out.println(password);
        out.println("</password>");
        out.println("</jdbc>");
    }
}
