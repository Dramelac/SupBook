package com.supinfo.supbook.servlet.user;

import com.supinfo.supbook.DAL.UserDAO;
import com.supinfo.supbook.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "SearchUserServlet", urlPatterns = "/search")
public class SearchUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String p = request.getParameter("q");
        List<User> result = UserDAO.getAllLike(p);

        request.setAttribute("resultList", result);
        request.setAttribute("filter", p);

        request.getRequestDispatcher("/jsp/user/userResult.jsp").forward(request, response);
    }
}
