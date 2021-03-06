package com.neuedu.server;

import com.neuedu.dao.UserDao;
import com.neuedu.dao.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "HelloServlet",urlPatterns = "/Hello.do")
public class HelloServlet extends HttpServlet {
    private UserDao ud;

    @Override
    public void init() throws ServletException {
        ud = new UserDaoImpl();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String psw = request.getParameter("psw");
        ud.register(user,psw);
        request.getRequestDispatcher("Login.html").forward(request,response);
    }
}
