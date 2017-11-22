package com.supinfo.supbook.servlet.post;

import com.supinfo.supbook.DAL.CommentDAO;
import com.supinfo.supbook.DAL.PostDAO;
import com.supinfo.supbook.DAL.UserDAO;
import com.supinfo.supbook.entity.Comment;
import com.supinfo.supbook.entity.Post;
import com.supinfo.supbook.entity.User;
import com.supinfo.supbook.utils.EmailUtility;
import javassist.NotFoundException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewPostServlet", urlPatterns = "/view")
public class ViewPostServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
                Post post = PostDAO.getPostById(Integer.parseInt(request.getParameter("id")));

                User senderuser = UserDAO.getUserById((int) request.getSession().getAttribute("userId"));
                String recipient = post.getUserOwner().getEmail();
                String subject = senderuser.getEmail() + " from SupBook sent you a message";
                String content = request.getParameter("email_content");

                try {
                    EmailUtility.sendEmail(recipient, subject, content);
                    request.setAttribute("message_mail", "The e-mail was sent successfully");
                    request.setAttribute("success_mail", true);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    request.setAttribute("message_mail", "There were an error.");
                    request.setAttribute("failed_mail", true);
                } finally {
                    getServletContext().getRequestDispatcher("/jsp/viewPost.jsp").forward(request, response);
                }
        } catch (Exception e){
            response.sendError(404);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Post post = PostDAO.getPostById(Integer.parseInt(request.getParameter("id")));
            if (post == null){
                throw new NotFoundException("Post no found");
            }
            Object userId = request.getSession().getAttribute("userId");
            if (userId != null && userId.equals(post.getUserOwner().getId())){
                request.setAttribute("isOwner", true);
            }
            List<Comment> comments = CommentDAO.getCommentsForPost(Integer.parseInt(request.getParameter("id")));
            request.setAttribute("post", post);
            request.setAttribute("comments", comments);
            request.setAttribute("owner", post.getUserOwner());
            request.getRequestDispatcher("/jsp/viewPost.jsp").forward(request, response);
        } catch (Exception e){
            response.sendError(404);
        }
    }
}
