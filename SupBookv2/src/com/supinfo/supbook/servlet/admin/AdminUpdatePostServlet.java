package com.supinfo.supbook.servlet.admin;

import com.supinfo.supbook.DAL.PostDAO;
import com.supinfo.supbook.entity.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminUpdatePostServlet",urlPatterns = "/admin/updatepost")
public class AdminUpdatePostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Post post = null;
        int id = Integer.parseInt(request.getParameter("id"));
        post = PostDAO.getPostById(Integer.parseInt(request.getParameter("id")));
        post.setImage(request.getParameter("image"));
        post.setContent(request.getParameter("description"));
        PostDAO.updatePost(post);

        response.sendRedirect(request.getContextPath() + "/admin/post");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Post post = null;
        post = PostDAO.getPostById(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("post", post);
        request.getRequestDispatcher("/jsp/user/updatePost.jsp").forward(request, response);
    }
}
