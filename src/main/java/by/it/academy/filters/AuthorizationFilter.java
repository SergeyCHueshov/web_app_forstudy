package by.it.academy.filters;

import by.it.academy.enteties.User;
import by.it.academy.enteties.UserType;
import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

import static by.it.academy.enteties.UserType.Admin;
import static by.it.academy.enteties.UserType.Users;

@WebFilter(urlPatterns = {"/user/enroll"})
public class AuthorizationFilter extends HttpFilter {
    private static final long serialVersionUID = 5992383557775358650L;
    private static final String USAGE_URI = "/user/create";
    private static final String USAGE_URL = "/user/read";
    private UserService userService;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession(true);
        if (null != session && null != session.getAttribute("userType")) {
            UserType userType = (UserType) session.getAttribute("userType");
            if (userType == Admin) {
                req.getRequestDispatcher(USAGE_URL).forward(req, res);
            } else if (userType == Users) {
                req.getRequestDispatcher(USAGE_URI).forward(req, res);
            } else {
                List<User> users = userService.readUsers();
                users.stream()
                        .filter(user -> user.getLogin().equals(req.getParameter("login")))
                        .findFirst()
                        .ifPresent(user -> session.setAttribute("userType", user.getUserType()));
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        userService = (UserServiceImpl) config.getServletContext().getAttribute("userService");
    }

    @Override
    public void destroy() {

    }
}

