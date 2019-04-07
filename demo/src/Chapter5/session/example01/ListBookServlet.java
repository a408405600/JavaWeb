package Chapter5.session.example01;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;


public class ListBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Collection<Book> books = BookDB.getAll();
        out.println("本站提供的图书有：<br/>");
        for(Book book : books){
            String url = "/PurchaseServlet?id=" +book.getId();
            HttpSession s = request.getSession();
            String newUrl = response.encodeRedirectURL(url);
            out.write(book.getName()+"<a href='"+newUrl+"'>点击购买</a><br />");
        }
    }
}
