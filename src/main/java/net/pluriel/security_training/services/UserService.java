package net.pluriel.security_training.services;

import net.pluriel.security_training.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    void changePassword(Long userId, String oldPassword, String newPassword);
//    void deleteUser(Long userId);
}
