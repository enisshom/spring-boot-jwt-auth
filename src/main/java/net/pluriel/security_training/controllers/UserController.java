package net.pluriel.security_training.controllers;

import lombok.RequiredArgsConstructor;
import net.pluriel.security_training.entities.User;
import net.pluriel.security_training.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/test")
    public ResponseEntity<String> saysalam() {
        return ResponseEntity.ok("asalmou alaikoum");
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/{id}/password")
    public ResponseEntity<String> changePassword(@PathVariable Long id,
                                                 @RequestBody Map<String, String> requestPayload) {
        String oldPassword = requestPayload.get("oldPassword");
        String newPassword = requestPayload.get("newPassword");
        userService.changePassword(id, oldPassword, newPassword);
        return ResponseEntity.ok("Password changed successfully");
    }
}
