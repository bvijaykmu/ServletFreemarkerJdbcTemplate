package com.zetcode.web;

import com.zetcode.bean.User;
import com.zetcode.service.DatabaseService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MyController", urlPatterns = {"/MyController"})
public class MyController extends HttpServlet {

    private static final String ADD_USER_VIEW = "addUser.ftl";
    private static final String UPDATE_USER_VIEW = "updateUser.ftl";
    private static final String LIST_USERS_VIEW = "listUsers.ftl";
    
    private static final String USER_ADDED_VIEW = "userAdded.html";
    private static final String USER_DELETED_VIEW = "userDeleted.html";
    private static final String USER_MODIFIED_VIEW = "userUpdated.html";
    
    private static final String DELETE_ACTION = "deleteUser";
    private static final String ADD_ACTION = "addUser";
    private static final String UPDATE_ACTION = "updateUser";
    private static final String LIST_ACTION = "listUsers";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String path = "";

        String action = request.getParameter("action");

        if (DELETE_ACTION.equals(action)) {
            Long userId = Long.parseLong(request.getParameter("userId"));
            DatabaseService.deleteUser(userId);

            path = USER_DELETED_VIEW;
        } else if (ADD_ACTION.equals(action)) {

            path = ADD_USER_VIEW;

        } else if (UPDATE_ACTION.equals(action)) {

            Long userId = Long.parseLong(request.getParameter("userId"));
            User user = DatabaseService.getUserById(userId);
            request.setAttribute("user", user);
            path = UPDATE_USER_VIEW;

        } else if (LIST_ACTION.equals(action)) {

            List<User> users = DatabaseService.getAllUsers();
            request.setAttribute("users", users);
            path = LIST_USERS_VIEW;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = "";

        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        if (ADD_ACTION.equals(action)) {

            User user = new User();
            user.setFirstName(request.getParameter("firstName"));
            user.setLastName(request.getParameter("lastName"));
            user.setEmail(request.getParameter("email"));

            DatabaseService.addUser(user);
            path = USER_ADDED_VIEW;

        } else if (UPDATE_ACTION.equals(action)) {

            User user = new User();
            user.setId(Long.parseLong(request.getParameter("id")));
            user.setFirstName(request.getParameter("firstName"));
            user.setLastName(request.getParameter("lastName"));
            user.setEmail(request.getParameter("email"));

            DatabaseService.updateUser(user);
            path = USER_MODIFIED_VIEW;
        }

        response.sendRedirect(path);
    }
}
