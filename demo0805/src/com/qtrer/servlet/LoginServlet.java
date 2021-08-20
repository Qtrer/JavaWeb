package com.qtrer.servlet;

import com.qtrer.service.LoginService;
import com.qtrer.vo.Atm;
import com.qtrer.vo.Dish;
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
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");
        LoginService loginService = new LoginService();
        Atm atm = loginService.login(user, pwd);
        if (atm == null){
            response.sendRedirect("index.jsp");
        }else {
            List<Dish> list = loginService.dishlist();
            HttpSession session = request.getSession();
            session.setAttribute("account",atm);
            request.setAttribute("dishList", list);
            request.getRequestDispatcher("main.jsp").forward(request, response);
        }
    }
}
