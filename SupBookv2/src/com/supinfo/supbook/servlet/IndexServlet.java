package com.supinfo.supbook.servlet;

import com.supinfo.supbook.DAL.AdvertDAO;
import com.supinfo.supbook.DAL.UserDAO;
import com.supinfo.supbook.entity.Categorie;
import com.supinfo.supbook.entity.Advert;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;


@WebServlet(name = "IndexServlet", urlPatterns = "/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("userCount", UserDAO.getUserCount());
        request.setAttribute("advertCount", AdvertDAO.getAdvertCount());
        request.setAttribute("categorieList", Categorie.CategorieList);
        request.setAttribute("list", AdvertDAO.getTenAdvertsOrderByPublishDate());

        request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
    }
}
