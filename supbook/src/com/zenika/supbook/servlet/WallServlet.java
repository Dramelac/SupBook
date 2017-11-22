package com.zenika.supbook.servlet;

import com.zenika.supbook.DAL.PostDAO;
import com.zenika.supbook.DAL.UserDAO;
import com.zenika.supbook.model.Post;
import com.zenika.supbook.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "WallServlet", urlPatterns = "/wall")
public class WallServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("userId") == null){
            response.sendRedirect("/login");
            return;
        }
        User user = UserDAO.getUserById((int) request.getSession().getAttribute("userId"));
        List<Post> result = PostDAO.getPostByPageId(user);
        request.setAttribute("posts", result);
        request.getRequestDispatcher("/jsp/wall.jsp").forward(request, response);
    }
}
