package com.sys.servlet;


import com.alibaba.fastjson.JSON;
import com.sys.entity.Area;
import com.sys.entity.User;
import com.sys.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Sheng")
public class ShengServlet extends HttpServlet {
    private UserService userService = new UserService();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        List<Area> ss = userService.ss();
        String str= JSON.toJSONString(ss);
        PrintWriter out = resp.getWriter();
        out.append(str);
    }
}
