package servlet;

import dao.UserDao;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {
    UserDao dao = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //1.通过request对象，收集表单数据"
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sex =request.getParameter("sex");
        String _age =request.getParameter("age");
        int age = 20;
        if(_age != null && !_age.equals("")){

            try {
                age = Integer.parseInt(_age);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        String[] hobbys = request.getParameterValues("hobbys");
        //2.把表单数据封装成一个User对象
        User user = new User(username,password,sex,age,hobbys);
        //3.调用dao的addUser方法，添加用户数据
        boolean flag = dao.addUser(user);
        //4.根据第3步结果，执行相应处理
        //4.1 返回true 在请求域中保存用户名，请求转发到登录页
        if(flag){
            request.setAttribute("username",user.getUsername());
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }else {
            request.setAttribute("error","用户名已存在，不允许重复注册");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }
        //4.2 返回false 用户名已存在，则在请求域中保存错误消息，请求转发到注册页，显示错误信息
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
