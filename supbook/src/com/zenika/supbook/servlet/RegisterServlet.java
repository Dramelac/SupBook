package com.zenika.supbook.servlet;

import com.zenika.supbook.DAL.UserDAO;
import com.zenika.supbook.model.User;
import com.zenika.supbook.service.SecurityUtils;

import javax.persistence.RollbackException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("failed", false);
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordverif = request.getParameter("passwordverif");

        if (username.isEmpty() || password.isEmpty() || passwordverif.isEmpty() || email.isEmpty()){
            request.setAttribute("failed", true);
            request.setAttribute("message", "Required field is missing.");
            redirectToForm(request, response);
            return;
        }
        if (!SecurityUtils.validateEmailAddress(email)){
            request.setAttribute("failed", true);
            request.setAttribute("message", "E-mail is invalid.");
            redirectToForm(request, response);
            return;
        }
        if (password.length() < 8){
            request.setAttribute("failed", true);
            request.setAttribute("message", "Password is too weak (< 8).");
            redirectToForm(request, response);
            return;
        }
        if (!password.equals(passwordverif)){
            request.setAttribute("failed", true);
            request.setAttribute("message", "Password not match.");
            redirectToForm(request, response);
            return;
        }

        User user = new User();
        user.setEmail(email);
        user.setLogin(username);

        user.setPassword(SecurityUtils.getHashfromPassword(password));

        try {
            UserDAO.addUser(user);
            request.getSession().setAttribute("username", username);
            request.getSession().setAttribute("userId", user.getId());
            request.getSession().setAttribute("isAdmin", user.isAdmin());
            response.sendRedirect(request.getContextPath() + "/index");
        } catch (RollbackException e) {
            request.setAttribute("failed", true);
            request.setAttribute("message", "This account or email already exist.");
            redirectToForm(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/registerForm.jsp").forward(request, response);
    }

    private void redirectToForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("username", request.getParameter("username"));
        request.setAttribute("email", request.getParameter("email"));
        doGet(request, response);
    }
}
