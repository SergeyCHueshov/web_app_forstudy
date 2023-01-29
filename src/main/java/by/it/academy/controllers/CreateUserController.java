package by.it.academy.controllers;

import by.it.academy.enteties.User;
import by.it.academy.enteties.UserType;
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

@WebServlet(urlPatterns = "/user/create")
public class CreateUserController extends HttpServlet {

    private final static long serialVersionUID = 2324052530258205L;
    private static final String USERS_URI = "/pages/user/admin.jsp";
    private static final String USERS_URL = "/pages/user/user.jsp";
    private UserService userService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String secondname = req.getParameter("secondname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        UserType userType = UserType.valueOf(req.getParameter("userType"));
        userService.createUser(firstname, secondname, age, login, password, userType);
        req.getRequestDispatcher(USERS_URL).forward(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(USERS_URI);
        List<User> users = userService.readUsers();
        req.setAttribute("users", users);
        requestDispatcher.forward(req, resp);
    }
    public void init(ServletConfig config) throws ServletException {
        userService = (UserServiceImpl) config.getServletContext().getAttribute("userService");
    }
}
