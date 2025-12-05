package com.revature.ExpenseReport.Services;

import com.revature.ExpenseReport.Models.AppUser;
import com.revature.ExpenseReport.Repository.AppUserRepository;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.User;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;
@Component
public class BasicAuthInterceptor implements HandlerInterceptor {
    // Fields
    private final AppUserRepository repo;

    // Constructor
    public BasicAuthInterceptor(AppUserRepository repo) {
        this.repo = repo;
    }

    // Methods
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authHeader = request.getHeader("Authorization");
        // is header there, of right kind?
        if (authHeader != null && authHeader.startsWith("Basic ")) {
            // b64c = base64credentials. decode the header to base 64 string. basic wih space is 6 characters
            String b64c = authHeader.substring(6);
            // base 64 --> byte array --> string
            byte[] decoded = Base64.getDecoder().decode(b64c);
            String creds = new String(decoded, StandardCharsets.UTF_8);

            // split the "username:password". limit is 2, username and password
            String[] parts = creds.split(":", 2);
            if (parts.length == 2) {
                String username = parts[0];
                String password = parts[1];
                // check if the user is in the db, then check if password is correct
                Optional<AppUser> user = repo.findByUsername(username);
                if (user.isPresent() && user.get().getPassword().equals(password)) {
                    return true;
                }

            }
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Unauthorized: invalid credentials");
        return false;
    }


}
