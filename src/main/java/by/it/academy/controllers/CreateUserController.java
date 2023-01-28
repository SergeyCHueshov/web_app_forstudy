package by.it.academy.controllers;

import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/create", loadOnStartup = 1)//фишечка отложенной реализации
public class CreateUserController extends HttpServlet {

    private final static long serialVersionUID = 2324052530258205L;
    private static final String USERS_URI = "/user/read";
    private UserService userService;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String secondname = req.getParameter("secondname");
        String login = req.getParameter("login");
        int age = Integer.parseInt(req.getParameter("age"));
        int password = Integer.parseInt(req.getParameter("password"));
        userService.createUser(firstname, secondname, login, age, password);
        req.getRequestDispatcher(USERS_URI).forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = (UserServiceImpl) config.getServletContext().getAttribute("userService");
    }


}
