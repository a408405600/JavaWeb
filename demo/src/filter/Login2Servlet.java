package filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Login2Servlet")
public class Login2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //检查用户名密码
        if("admin".equals(username) &&  "123456".equals(password)){
            //登录成功 将用户状态user对象存入session域
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            request.getSession().setAttribute("user",user);
            //发送自动登录的cookie
            String autoLogin = request.getParameter("autologin");
            if(autoLogin != null){
                Cookie cookie = new Cookie("autologin",username+"-"+password);
                cookie.setMaxAge(Integer.parseInt(autoLogin));
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
            }
            //跳转到首页
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            request.setAttribute("errerMsg","用户名密码登录");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
