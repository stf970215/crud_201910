package com.sys.servlet;

import com.sys.Page;
import com.sys.entity.User;
import com.sys.service.UserService;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/sys/user/list")
public class UserListServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        List<User> list = userService.listAll();
//        request.setAttribute("list", list);
//        request.getRequestDispatcher("/userList.jsp").forward(request, response);
        //查询条件
        String account = request.getParameter("account");
        account = StringUtils.isEmpty(account) ? "" : account;

        Page page = new Page();

        //总记录数
        Integer count = userService.count(account);
        page.setCount(count);

        //当前页
        Integer pageCurrent = 1;
        String pageStr = request.getParameter("page");
        if (!StringUtils.isEmpty(pageStr)) {
            pageCurrent = Integer.valueOf(pageStr);
        }
        page.setPage(pageCurrent);
        List<User> list = userService.listAll(account, page);

        request.setAttribute("list", list);
        request.setAttribute("account", account);
        request.setAttribute("page", page);
        request.getRequestDispatcher("/userList.jsp").forward(request, response);
    }
}
