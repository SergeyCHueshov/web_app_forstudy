package by.it.academy.controllers;

import by.it.academy.enteties.User;
import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = {"/user/read"}) //определяем, что данный класс будет работать на определенном хосте.
public class ReadUsersControllers extends HttpServlet {
    private static final long serialVersionUID = 5992383514475358050L; //констант для сериализации;
    private static final String USERS_PAGE = "/pages/user/user.jsp";
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(USERS_PAGE);
        List<User> users = userService.readUsers();
        req.setAttribute("users", users);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserServiceImpl) config.getServletContext().getAttribute("userService");
    }
}
