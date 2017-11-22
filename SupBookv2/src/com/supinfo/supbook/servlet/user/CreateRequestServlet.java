package com.supinfo.supbook.servlet.user;

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
import java.util.Date;


@WebServlet(name = "CreateRequestServlet", urlPatterns = "/user/friendrequest")
public class CreateRequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int myid = (int) request.getSession().getAttribute("userId");
        User otherUser = UserDAO.getUserById(id);
        if (otherUser == null || id == myid){
            response.sendRedirect("/index");
            return;
        }
        User user = UserDAO.getUserById(myid);

        FriendRequest fr = new FriendRequest();
        fr.setCreateAt(new Date());
        fr.setOwner(user);
        fr.setReceiver(otherUser);
        fr.setStatus(false);
        FriendRequestDAO.addFriendRequest(fr);
        UserDAO.updateUser(user);
        UserDAO.updateUser(otherUser);

        response.sendRedirect("/index");
    }
}
