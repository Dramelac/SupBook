package com.zenika.supbook.servlet;

import com.zenika.supbook.DAL.UserDAO;
import com.zenika.supbook.model.User;
import com.zenika.supbook.service.SecurityUtils;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "HomeServlet",urlPatterns = "/home")
public class HomeServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("userId") != null) {
            request.getRequestDispatcher("/jsp/home.jsp").forward(request, response);

        }
        else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected List<User> getUserFromSearch(String inputText)
    {
        Session session = null;
        Query query = session.createQuery(String.format("select login from User like %s", inputText));
        List result = query.list();
        return result ;
    }

}
