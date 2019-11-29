package com.sys.servlet;

import com.sys.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/sys/user/delete")
public class UserDeleteServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id == null) {
            return;
        }
        userService.delById(Integer.valueOf(id));
        //删除成功后跳转到list
        response.sendRedirect("/sys/user/list");

    }
}
