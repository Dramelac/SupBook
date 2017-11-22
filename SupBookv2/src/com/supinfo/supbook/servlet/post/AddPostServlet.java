package com.supinfo.supbook.servlet.post;

import com.supinfo.supbook.DAL.PostDAO;
import com.supinfo.supbook.DAL.UserDAO;
import com.supinfo.supbook.entity.Post;
import com.supinfo.supbook.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet(name = "AddPostServlet",urlPatterns = "/user/addpost")
public class AddPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = UserDAO.getUserById((int) request.getSession().getAttribute("userId"));
        Post post = new Post();
        post.setImage(request.getParameter("image"));
        post.setContent(request.getParameter(" content"));
        post.setCreateAt(new Date());
        post.setUserPage(user);
        post.setUserOwner(user);
        PostDAO.addPost(post);
        UserDAO.updateUser(user);
        response.sendRedirect(request.getContextPath() + "/index");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/user/addpost.jsp").forward(request, response);
    }
}
