package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "AutoLoginFilter")
public class AutoLoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        //获得一个名为autologin 的 cookie
        Cookie[] cookies = request.getCookies();
        String autologin = null;
        for (int i = 0; cookies != null && i < cookies.length; i++) {
            if("autologin".equals(cookies[i].getName())){
                //找到了指定的cookie
                autologin = cookies[i].getValue();
                break;
            }
        }
        if(autologin != null){
            //做自动登录
            String[] parts = autologin.split("-");
            String username = parts[0];
            String password = parts[1];
            //检查用户名密码
            if(("admin").equals(username)  && ("123456").equals(password)){
                //登录成功，将用户状态user对象存入session域
                User user = new User();
                System.out.println(username);
                user.setUsername("admin");
                user.setPassword("123456");
                request.getSession().setAttribute("user",user);
            }
        }
        //放行
        chain.doFilter(request, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
