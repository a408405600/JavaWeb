package servlet;

import dao.UserDao;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    UserDao dao = new UserDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用dao中的相关方法，获取所有数据
        List<User> users = new ArrayList<>();
        users = dao.getAllUsers();
        //把获取的数据存入到请求域中 储存表示为lisUsers
        request.setAttribute("lstUsers",users);
        //请求转发到页面/WEB_INF/list.jsp进行数据显示
        request.getRequestDispatcher("/WEB-INF/list.jsp").forward(request,response);
    }
}
