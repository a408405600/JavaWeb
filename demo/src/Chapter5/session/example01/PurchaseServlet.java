package Chapter5.session.example01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获得用户购买的商品
        String id = request.getParameter("id");
        System.out.println(id);
        if(id == null){
            //如果id为null,从定向到ListBookServlet页面
            String url = "/ListBookServlet";
            response.sendRedirect(url);
            return;
        }
        Book book =BookDB.getBook(id);
        //创建或者获得用户的Session对象
        HttpSession session =request.getSession();
        //从Session对象中获得用户的购物车
        List<Book> cart = (List) session.getAttribute("cart");
        if(cart == null) {
            //首次购买为用户创建一个购物车（List集合模拟购物车）
            cart = new ArrayList<Book>();
            //将购物车存入Session对象
            session.setAttribute("cart", cart);
        }
            //将商品放入购物车
            cart.add(book);
            //创建Cookie存放Session的表示号
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            cookie.setMaxAge(60*30);
            cookie.setPath("/");
            response.addCookie(cookie);
            //重定向购物车页面
            String url = "/CartServlet";
            String newUrl = response.encodeRedirectURL(url);
            response.sendRedirect(url);

    }
}
