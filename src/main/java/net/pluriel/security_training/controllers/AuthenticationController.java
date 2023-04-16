package net.pluriel.security_training.controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import net.pluriel.security_training.auth.requests.AuthRequest;
import net.pluriel.security_training.auth.response.AuthResponse;
import net.pluriel.security_training.auth.requests.RegisterRequest;
import net.pluriel.security_training.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    public final AuthService authService;

    @PostMapping("/addUser")
    public ResponseEntity<AuthResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> authenticate(
            @RequestBody AuthRequest authRequest
    ){
        return ResponseEntity.ok(authService.authenticate(authRequest));
    }

    @PostMapping("/refresh_token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
            authService.refreshToken(request, response);
    }
}
