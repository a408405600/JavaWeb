package chapter08;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "MyFilter")
public class MyFilter implements Filter {
    private String characterEncoding;
    FilterConfig fc;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.write("HELLO MyFilter");
        characterEncoding = fc.getInitParameter("encoding");
        System.out.println("encoding初始化参数的值为:"+characterEncoding);
        chain.doFilter(req,resp);
    }

    public void init(FilterConfig config) throws ServletException {
        //过滤器对象再初始化时调用，可以配置一些初始化参数
        this.fc = config;

    }

}
