package com.supinfo.supbook.servlet.admin;

import com.supinfo.supbook.DAL.PostDAO;
import com.supinfo.supbook.entity.Post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminPostServlet",urlPatterns = "/admin/post")
public class AdminPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Post> postList = PostDAO.getAllPostsOrderByPublishDate();
        request.setAttribute("postList", postList);
        request.getRequestDispatcher("/jsp/admin/postlist.jsp").forward(request, response);
    }
}
