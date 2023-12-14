package lt.codeacademy.javau7.finalproject1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lt.codeacademy.javau7.finalproject1.entities.User;

@Service
public interface UserService {

    // List<User> findAll();

    // User findById(int id);

    // User save(User user);

    // void deleteById(int id);

    // User findByUsername(String username);

    List<User> getAllUsers();
}
