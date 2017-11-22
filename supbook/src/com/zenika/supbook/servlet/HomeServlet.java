package com.zenika.supbook.servlet;

import com.zenika.supbook.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/HomeServlet")

public class HomeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HomeServlet homeServlet = new HomeServlet();

        request.getRequestDispatcher("/public/home.jsp").forward(request, response);

        if (request.getParameter("button1") != null) {
            homeServlet.getUsersFromSearch();
        }
        request.getRequestDispatcher("/WEB-INF/some-result.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    private List<User> getUsersFromSearch()
    {
        ArrayList<User> userList = new ArrayList<>();
        return userList;

    }
}
