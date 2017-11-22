package com.supinfo.supbook.servlet.post;

import com.supinfo.supbook.DAL.PostDAO;
import com.supinfo.supbook.entity.Post;
import com.supinfo.supbook.entity.Categorie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "SearchTextServlet", urlPatterns = "/search")
public class SearchTextServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = request.getParameter("q");
        List<Post> result = null;
        try {
            Categorie categorie = Categorie.valueOf(txt);
            result = PostDAO.searchByCategorie(categorie);
        } catch (IllegalArgumentException e){
            result = PostDAO.searchFullText(txt);
        }
        request.setAttribute("resultList", result);
        request.setAttribute("filter", txt);

        request.getRequestDispatcher("/jsp/searchResult.jsp").forward(request, response);
    }
}
