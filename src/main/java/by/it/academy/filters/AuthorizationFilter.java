package by.it.academy.filters;

import by.it.academy.enteties.User;
import by.it.academy.enteties.UserType;
import by.it.academy.repositories.UserRepositoryImpl;
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
import java.util.ArrayList;
import java.util.List;

@WebFilter(urlPatterns = {"/user/read"})
public class AuthorizationFilter extends HttpFilter {
    private static final long serialVersionUID = 5992383557775358650L;
    private UserService userService;

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession(true);
        if (null != session && null != session.getAttribute("userType")) {
            UserType userType = (UserType) session.getAttribute("userType");
            if (userType == UserType.Admin) {
                chain.doFilter(req, res);

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
        List<User> users = new ArrayList<>();
        userService = new UserServiceImpl(new UserRepositoryImpl(users));
        config.getServletContext().setAttribute("userService", userService);
    }

    @Override
    public void destroy() {

    }
}
