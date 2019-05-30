package com.neuedu.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet2",urlPatterns = "/lo.do")
public class LoginServlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String psw = req.getParameter("psw");
        if (null!=username && username.length()>0 && null!=psw && psw.length()>0)
        {
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            Cookie cookie = new Cookie("JSESSIONID",session.getId());
            cookie.setMaxAge(60);
            resp.addCookie(cookie);
            resp.sendRedirect("welcome.jsp");
        }else {
            resp.sendRedirect("Login2.jsp");
        }
    }
}
