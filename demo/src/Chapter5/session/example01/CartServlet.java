package Chapter5.session.example01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //变量cart 引用用户的购物车
        List<Book> cart = null;
        //变量purFlag 标记用户是否买过商品
        boolean purFlag = true;
        //获得用户的Session
        HttpSession session = request.getSession();
        //如果session为null, purFlag置为false
        if(session == null){
            purFlag = false;
        }else{
            //获得用户购物车
            cart = (List)session.getAttribute("cart");
            //如果用户购物车为null 则purFlag置为false
            if(cart == null){
                purFlag = false;
            }
        }

        //如果purFlag为false 表面用户没有购买过图书 从定向到 ListServlet
        if(!purFlag){
            out.write("对不起您没有购买过任何商品！");
        }else {
            //否则显示用户商品信息
            out.write("您购买的图书有:<br/>");
            double price = 0;
            for(Book book : cart){
                out.write(book.getName()+"<br/>");
            }
        }
    }
}
