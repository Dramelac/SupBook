package com.supinfo.supbook.servlet.post;

import com.supinfo.supbook.DAL.UserDAO;
import com.supinfo.supbook.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AvertManagerServlet",urlPatterns = "/user/postmanager")
public class PostManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = UserDAO.getUserById((int) request.getSession().getAttribute("userId"));
        request.setAttribute("list", user.getPosts());
        request.getRequestDispatcher("/jsp/user/postManager.jsp").forward(request, response);
    }
}
