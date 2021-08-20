package com.example.servlets;

import com.example.utils.DBExecutes;
import com.example.utils.DBUtils;
import com.example.vo.PerInfo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

@WebServlet(name = "DBServlet", value = "/db.do")
public class DBServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String sql = "select id 编号,name 姓名,sex 性别,age 年龄 from perInfo";
        try(PreparedStatement ps = DBUtils.getConnection().prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter pw = response.getWriter();
            pw.println("<html><head><title>Data</title></head><body><table border='1' width='500'><tr>");
            for (int i=0;i<rsmd.getColumnCount();i++) pw.println("<td>"+rsmd.getColumnLabel(i+1)+"</td>");
            pw.println("<td>操作</td></tr>");
            while (rs.next()){
                pw.println("<tr><td>"+rs.getInt(1)+"</td>");
                pw.println("<td>"+rs.getString(2)+"</td>");
                pw.println("<td>"+rs.getString(3)+"</td>");
                pw.println("<td>"+rs.getInt(4)+"</td>");
                pw.println("<td><a href=' '>修改</a>|<a href=' '>删除</a></td></tr>");
            }
            pw.println("<tr><td><a href=' '>添加</a></td></tr></body></html>");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
