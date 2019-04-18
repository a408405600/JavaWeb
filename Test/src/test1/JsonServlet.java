package test1;

import org.json.JSONObject;

import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "JsonServlet")
public class JsonServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String origin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", origin);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Authorization");
        response.setHeader("Access-Control-Allow-Credentials", "true");


        String req = "{\"title\":\"123\"}";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("title","234567");
        response.getWriter().print(jsonObject);
    }
}
