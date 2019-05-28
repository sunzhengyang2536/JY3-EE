package com.neuedu.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String psw = req.getParameter("psw");
        if (null != username && null != psw)
        {
            Cookie cookie = new Cookie("username",username);
            Cookie cookie1 = new Cookie("psw",psw);
            cookie.setMaxAge(60);
            cookie1.setMaxAge(60);
            resp.addCookie(cookie);
            resp.addCookie(cookie1);
        }else {
            Cookie[] cookies = req.getCookies();
            for (Cookie c: cookies){
                if ("username".equals(c.getName()))
                {
                    username = c.getValue();
                }if ("psw".equals(c.getName())){
                    psw = c.getValue();
                }
            }
        }
        if (username != null && psw != null){
            req.getRequestDispatcher("index3.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
    }
}
