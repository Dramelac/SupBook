package com.supinfo.supbook.servlet;

import com.supinfo.supbook.DAL.PostDAO;
import com.supinfo.supbook.DAL.UserDAO;
import com.supinfo.supbook.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userCount", UserDAO.getUserCount());
        request.setAttribute("postCount", PostDAO.getPostCount());
        User user = UserDAO.getUserById((int) request.getSession().getAttribute("userId"));
        List<User> friends = UserDAO.getFriends(user);
        friends.add(user);
        request.setAttribute("list", PostDAO.getFriendPostsOrderByPublishDate(friends));

        request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
    }
}
