package by.it.academy.controllers;

import by.it.academy.enteties.User;
import by.it.academy.enteties.UserType;
import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static by.it.academy.enteties.UserType.Admin;
import static by.it.academy.enteties.UserType.Users;

@WebServlet(urlPatterns = "/user/enroll", loadOnStartup = 0)
public class AuthorizationUserController extends HttpServlet {
    private final static long serialVersionUID = 2324052580258205L;
    private UserService userService;
    private static final String USAGE_URI = "/user/create";
    private static final String USAGE_URL = "/user/read";
    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserServiceImpl) config.getServletContext().getAttribute("userService");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        String firstname = req.getParameter("firstname");
        String secondname = req.getParameter("secondname");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        int age = Integer.parseInt(req.getParameter("age"));
        UserType userType = UserType.valueOf(req.getParameter("userType"));
        if (null != session && null != session.getAttribute("userType")) {
            userType = (UserType) session.getAttribute("userType");
            if (userType == Admin) {
                req.getRequestDispatcher(USAGE_URI).forward(req, resp);
            }else if (userType == Users) {
                req.getRequestDispatcher(USAGE_URL).forward(req, resp);
            } else {
                List<User> users = userService.readUsers();
                users.stream()
                        .filter(user -> user.getLogin().equals(req.getParameter("login")))
                        .findFirst()
                        .ifPresent(user -> session.setAttribute("userType", user.getUserType()));
            }
        }
        userService.createUser(firstname, secondname, age, login, password, userType);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}