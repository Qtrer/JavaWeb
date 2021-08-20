package com.example.servlets;

import com.example.utils.DBExecutes;
import com.example.vo.PerInfo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginServlet", value = "/login.do")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        System.out.println(name);
        String sql = "select * from perInfo where name=? and pwd=?";
        List<PerInfo> list = DBExecutes.executeQuery(sql, name, pwd);
        if (!list.isEmpty()) response.sendRedirect("db.do");
        else response.sendRedirect("index.html");
    }
}
