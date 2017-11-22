package com.supinfo.supbook.servlet.user;

import com.supinfo.supbook.DAL.FriendRequestDAO;
import com.supinfo.supbook.entity.FriendRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by doria on 22/11/2017.
 */
@WebServlet(name = "DenyFriendServlet",urlPatterns = "/denyfriend")
public class DenyFriendServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FriendRequest friendRequest = FriendRequestDAO.getFriendRequestByID(Integer.parseInt(request.getParameter("id")));
        FriendRequestDAO.removeFriendRequestByID(friendRequest.getId());
        response.sendRedirect(request.getContextPath() + "/friend");
    }
}
