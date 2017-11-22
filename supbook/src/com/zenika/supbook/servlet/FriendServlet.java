package com.zenika.supbook.servlet;

import com.sun.deploy.net.protocol.javascript.JavaScriptURLConnection;
import com.zenika.supbook.DAL.FriendRequestDAO;
import com.zenika.supbook.DAL.UserDAO;
import com.zenika.supbook.model.FriendRequest;
import com.zenika.supbook.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "FriendServlet", urlPatterns = "/friend")
public class FriendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = UserDAO.getUserById(1);
        User user2 = UserDAO.getUserById(2);

        // Invoke FirstServlet's job here.
        FriendRequest friendRequest = new FriendRequest();
        friendRequest.setOwner(user);
        friendRequest.setReceiver(user2);
        Date actuelle = new Date();
        //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        friendRequest.setCreateAt(actuelle);
        FriendRequestDAO.addFriendRequest(friendRequest);
        request.getRequestDispatcher("/jsp/friendRequest.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/jsp/friendRequest.jsp").forward(request, response);
    }
}
