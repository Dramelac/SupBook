package com.supinfo.supbook.servlet.post;

import com.supinfo.supbook.DAL.PostDAO;
import com.supinfo.supbook.entity.Post;
import com.supinfo.supbook.entity.Categorie;
import javassist.NotFoundException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "UpdatePostServlet", urlPatterns = "/user/updatepost")
public class UpdatePostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Post post = null;
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            post = PostDAO.getAndCheck(id,
                    (int) request.getSession().getAttribute("userId"));
        } catch (NotFoundException e){
            response.sendError(404);
            return;
        } catch (IllegalAccessException e){
            response.sendError(403);
            return;
        }
        post.setName(request.getParameter("postname"));
        post.setImageUrl(request.getParameter("image"));
        post.setDescription(request.getParameter("description"));
        String cat = request.getParameter("categorie");
        if (!cat.isEmpty()){
            post.setCategorie(Categorie.valueOf(request.getParameter("categorie")));
        }
        post.setPrice(Double.parseDouble(request.getParameter("price")));
        PostDAO.updatePost(post);

        response.sendRedirect(request.getContextPath() + "/view?id=" + id);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Post post = null;
        try {
            post = PostDAO.getAndCheck(Integer.parseInt(request.getParameter("id")),
                    (int) request.getSession().getAttribute("userId"));
        } catch (NotFoundException e){
            response.sendError(404);
            return;
        } catch (IllegalAccessException e){
            response.sendError(403);
            return;
        }
        request.setAttribute("categorieList", Categorie.CategorieList);
        request.setAttribute("post", post);

        request.getRequestDispatcher("/jsp/user/updatePost.jsp").forward(request, response);
    }
}
