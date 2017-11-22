package com.supinfo.supbook.servlet.user;

import com.sun.deploy.net.protocol.javascript.JavaScriptURLConnection;
import com.supinfo.supbook.DAL.FriendRequestDAO;
import com.supinfo.supbook.DAL.UserDAO;
import com.supinfo.supbook.entity.FriendRequest;
import com.supinfo.supbook.entity.User;

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
        User user = UserDAO.getUserById((int) request.getSession().getAttribute("userId"));
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
        User user = UserDAO.getUserById((int) request.getSession().getAttribute("userId"));
        request.setAttribute("list", FriendRequestDAO.getRequestByReceiverID(user.getId()));
        request.getRequestDispatcher("/jsp/friendRequest.jsp").forward(request, response);
    }
}
