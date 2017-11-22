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
        User user = UserDAO.getUserById(5);
        User user2 = UserDAO.getUserById(9);

        // Invoke FirstServlet's job here.
        FriendRequest friendRequest = new FriendRequest();
        friendRequest.setOwner(user);
        friendRequest.setReceiver(user2);
        Date actuelle = new Date();
        //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        friendRequest.setCreateAt(actuelle);
        FriendRequestDAO.addFriendRequest(friendRequest);
        request.getRequestDispatcher("/jsp/user/friendRequest.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id =Integer.parseInt(request.getSession().getAttribute("userId").toString());
        User user = UserDAO.getUserById(id );

        try {
            request.setAttribute("list", FriendRequestDAO.getRequestByReceiverID(user));
        }
        catch (Exception e){
            System.out.println("No request");
        }
        request.getRequestDispatcher("/jsp/user/friendRequest.jsp").forward(request, response);
    }
}
