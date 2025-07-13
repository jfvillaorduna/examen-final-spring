package com.examenfinal.ms_auth.controller;

import com.examenfinal.ms_auth.dto.AuthResponse;
import com.examenfinal.ms_auth.dto.LoginRequest;
import com.examenfinal.ms_auth.dto.RegistroRequest;
import com.examenfinal.ms_auth.secutiry.JwtService;
import com.examenfinal.ms_auth.service.AuthService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final JwtService jwtService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegistroRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @GetMapping("/validate")
    public Claims validate(@RequestHeader("Authorization") String bearerToken) {
        String token = bearerToken.replace("Bearer ", "");
        return jwtService.validateToken(token);
    }
}
