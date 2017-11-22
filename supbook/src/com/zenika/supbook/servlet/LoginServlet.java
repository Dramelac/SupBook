package com.zenika.supbook.servlet;

import com.zenika.supbook.DAL.UserDAO;
import com.zenika.supbook.model.User;
import com.zenika.supbook.service.SecurityUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        User user = UserDAO.getUserByName(username);

        if (user != null && SecurityUtils.checkPassword(request.getParameter("password"), user.getPassword())){
            request.getSession().setAttribute("username", user.getLogin());
            request.getSession().setAttribute("userId", user.getId());
            request.getSession().setAttribute("isAdmin", user.isAdmin());
            response.sendRedirect(request.getContextPath()+"/index");
        }
        else {
            request.setAttribute("failed", true);
            doGet(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/private/loginForm.jsp").forward(request, response);

    }
}
