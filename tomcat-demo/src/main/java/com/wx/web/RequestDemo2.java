package com.wx.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
@WebServlet("/req2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        for (String s : parameterMap.keySet()) {
            System.out.print(s+":");
            String[] strings = parameterMap.get(s);
            for (String string : strings) {
                System.out.print(string+" ");
            }
            System.out.println();
        }

        System.out.println("--------------------------------------");
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }
        System.out.println("--------------------------------------");
        String password = req.getParameter("password");
        String username = req.getParameter("username");
        System.out.println(password);
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost~");
        this.doGet(req,resp);
    }
}
