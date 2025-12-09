package com.revature.ExpenseReport.Controllers;

import com.revature.ExpenseReport.Models.AppUser;
import com.revature.ExpenseReport.Repository.AppUserRepository;
import com.revature.ExpenseReport.Util.JwtUtil;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
 class AuthController {
    public record AuthRequest(String username, String password){}
public record AuthResponse(String token){}
    // fields
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    // constructor

    public AuthController(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    // methods
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        Optional<AppUser> user = appUserRepository.findByUsername(authRequest.username());
        // does the user exist?,
        if (user.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        // if they do, does the password match?
        if (!passwordEncoder.matches(authRequest.password(), user.get().getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid password");
        }
        // if they do, generate a token
        String token = jwtUtil.generateToken(user.get().getUsername());
        // return the token
        return new AuthResponse(token);
    }

}
