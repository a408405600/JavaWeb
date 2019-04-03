import dao.UserDao;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    UserDao dao = new UserDao();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Map<String, Object> result = dao.login(username, password);
        boolean flag = Boolean.valueOf(result.get("flag").toString());
        if (flag){
            System.out.println("成功");
            response.setContentType("text/html;charset=utf-8");
            response.setHeader("Refresh","5;url=list");
            response.getWriter().println("5秒后跳转到列表页,<a href='list'>列表页</a>");
        }else {
            String error  =result.get("msg").toString();
            System.out.println(error);
            //请求转发(数据) 重定向
            request.setAttribute("error",error);//把数据放在请求域中，只要还是同一个请求，就能取到该数据
            //请求转发(依然还是同一个请求)
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            //跳转会到登录页，并且把error带回到login页进行显示
        }
        System.out.println(username +" : "+ password);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //tomcat 8以下
        //System.out.println(new String(username.getBytes("iso-8859-1"),"utf-8"));
    }
}
