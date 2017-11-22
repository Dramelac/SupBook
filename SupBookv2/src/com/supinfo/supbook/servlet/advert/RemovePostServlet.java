package com.supinfo.supbook.servlet.post;

import com.supinfo.supbook.DAL.PostDAO;
import com.supinfo.supbook.entity.Post;
import javassist.NotFoundException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemovePostServlet", urlPatterns = "/user/removepost")
public class RemovePostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Post post = PostDAO.getAndCheck(Integer.parseInt(request.getParameter("id")),
                    (int) request.getSession().getAttribute("userId"));
            PostDAO.removePostByPost(post);
            response.sendRedirect(request.getContextPath() + "/user/postmanager");
        } catch (NotFoundException e){
            response.sendError(404);
        } catch (IllegalAccessException e){
            response.sendError(403);
        }

    }
}
