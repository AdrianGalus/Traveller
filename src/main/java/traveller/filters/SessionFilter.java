package traveller.filters;

import org.springframework.web.filter.OncePerRequestFilter;
import traveller.dtos.UserDTO;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SessionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException,
                                    ServletException {

        String requestPath = req.getRequestURI();
        if(sessionRequired(requestPath)) {
            HttpSession session = req.getSession();
            UserDTO user = (UserDTO) session.getAttribute("loggedUser");
            if(user == null) {
                res.sendRedirect("/");
                return;
            }
        }
        chain.doFilter(req, res);
    }
    private boolean sessionRequired(String requestPath) {

        List<String> sessionNotRequiredPaths = Arrays.asList("/login", "/register", "/");
        for(String path : sessionNotRequiredPaths) {
            if(requestPath.equalsIgnoreCase(path)) {
                return false;
            }
        }
        return true;
    }
}
