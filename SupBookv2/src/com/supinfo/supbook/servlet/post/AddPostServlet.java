package com.supinfo.supbook.servlet.post;

import com.supinfo.supbook.DAL.UserDAO;
import com.supinfo.supbook.entity.Post;
import com.supinfo.supbook.entity.Categorie;
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
        post.setName(request.getParameter("postname"));
        post.setImageUrl(request.getParameter("image"));
        post.setDescription(request.getParameter("description"));
        if (!request.getParameter("categorie").isEmpty()){
            post.setCategorie(Categorie.valueOf(request.getParameter("categorie")));
        } else {
            post.setCategorie(Categorie.Other);
        }
        post.setPublishDate(new Date());
        post.setPrice(Double.parseDouble(request.getParameter("price")));
        post.setOwner(user);
        user.getPosts().add(post);
        UserDAO.updateUser(user);
        response.sendRedirect(request.getContextPath() + "/index");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("categorieList", Categorie.CategorieList);

        request.getRequestDispatcher("/jsp/user/addpost.jsp").forward(request, response);
    }
}
