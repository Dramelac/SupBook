package com.supinfo.supbook.servlet.admin;

import com.supinfo.supbook.DAL.PostDAO;
import com.supinfo.supbook.entity.Post;
import javassist.NotFoundException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminRemovePostServlet", urlPatterns = "/admin/removepost")
public class AdminRemovePostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request ,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Post post = PostDAO.getPostById(Integer.parseInt(request.getParameter("id")));
        PostDAO.removePostByPost(post);
        response.sendRedirect(request.getContextPath() + "/admin/post");
    }
}
