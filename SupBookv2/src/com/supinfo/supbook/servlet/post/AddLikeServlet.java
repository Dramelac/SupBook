package com.supinfo.supbook.servlet.post;

import com.supinfo.supbook.DAL.LikeDAO;
import com.supinfo.supbook.DAL.PostDAO;
import com.supinfo.supbook.entity.Post;
import com.supinfo.supbook.entity.PostLike;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;


@WebServlet(name = "AddLikeServlet", urlPatterns = "/user/postlike")
public class AddLikeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int postid = Integer.parseInt(request.getParameter("id"));
        String add = request.getParameter("action");
        Post post = PostDAO.getPostById(postid);
        PostLike like = LikeDAO.getLikeByPost(post);
        if (like == null){
            like = new PostLike();
            like.setPost(post);
            if (Objects.equals(add, "like")){
                like.setAction(true);
            } else if (Objects.equals(add, "dislike")){
                like.setAction(false);
            }

            LikeDAO.addLike(like);
        }
        response.sendRedirect("/index");

    }
}
