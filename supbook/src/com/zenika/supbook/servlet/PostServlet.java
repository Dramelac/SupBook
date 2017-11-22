package com.zenika.supbook.servlet;

import com.zenika.supbook.DAL.UserDAO;
import com.zenika.supbook.model.Post;
import com.zenika.supbook.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet(name = "PostServlet", urlPatterns = "/post/submit")
public class PostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("userId") == null){
            response.sendRedirect("/login");
            return;
        }

        String content = request.getParameter("content");
        String image = request.getParameter("image");

        Post post = new Post();
        post.setContent(content);
        post.setCreateAt(new Date());
        post.setImage(image);

        User user = UserDAO.getUserById((int) request.getSession().getAttribute("userId"));
        post.setUserOwner(user);

        post.setUserPage(user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/index");
    }
}
