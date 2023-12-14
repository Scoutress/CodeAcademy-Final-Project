package lt.codeacademy.javau7.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import lt.codeacademy.javau7.project.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);}
