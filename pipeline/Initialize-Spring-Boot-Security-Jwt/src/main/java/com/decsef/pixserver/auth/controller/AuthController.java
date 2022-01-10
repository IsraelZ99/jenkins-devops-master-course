package com.decsef.pixserver.auth.controller;

import com.decsef.pixserver.auth.models.LoginRequest;
import com.decsef.pixserver.auth.services.AuthService;
import com.decsef.pixserver.security.jwt.JwtUtils;
import com.decsef.pixserver.security.jwt.config.JwtConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtConfig jwtConfig;
    private final JwtUtils jwtUtils;

    @PostMapping("/login")
    public void authenticateUser(@RequestBody LoginRequest loginRequest, HttpServletResponse response){
        authService.login(loginRequest, response);
    }

    @GetMapping("/token")
    public ResponseEntity<Object> isTheUserIsLoggedIn(@RequestHeader("Authorization") String authorizationToken){
        String token = authorizationToken.replace(jwtConfig.getTokenPrefix(), "");
        jwtUtils.getUserNameFromJwtToken(token);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
