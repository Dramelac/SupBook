package com.supinfo.supbook.servlet.comment;

import com.supinfo.supbook.DAL.PostDAO;
import com.supinfo.supbook.DAL.UserDAO;
import com.supinfo.supbook.DAL.CommentDAO;
import com.supinfo.supbook.entity.Post;
import com.supinfo.supbook.entity.User;
import com.supinfo.supbook.entity.Comment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "AddCommentServlet",urlPatterns = "/comment/add")
public class AddCommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = UserDAO.getUserById((int) request.getSession().getAttribute("userId"));
        Post post = PostDAO.getPostById(Integer.parseInt(request.getParameter("postId")));
        Comment comment = new Comment();
        comment.setOwner(user);
        comment.setPost(post);
        comment.setContent(request.getParameter("comment"));
        CommentDAO.addComment(comment);
        response.setStatus(200);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
