package net.pluriel.security_training.repositories;

import net.pluriel.security_training.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.role = 'USER'")
    List<User> getAllUsersWithRoleUser();
    Optional<User> findByEmail(String email);
}
