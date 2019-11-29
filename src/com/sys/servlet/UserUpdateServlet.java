package com.sys.servlet;

import com.sys.entity.User;
import com.sys.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/sys/user/update")
public class UserUpdateServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String name = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        String sex = request.getParameter("sex");


        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setPwd(pwd);
        user.setSex(Integer.valueOf(sex));


        userService.uptUser(user);
        response.sendRedirect("/sys/user/list");
    }
}
