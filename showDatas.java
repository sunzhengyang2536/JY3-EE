package com.neuedu.controller;

import com.neuedu.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "showDatas",urlPatterns = "/show.do")
public class showDatas extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String userName = request.getParameter("username");
        String psw = request.getParameter("psw");
        int result = Integer.parseInt(id);
        User user = new User(result,userName,psw);
        request.setAttribute("user",user);
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }
}
