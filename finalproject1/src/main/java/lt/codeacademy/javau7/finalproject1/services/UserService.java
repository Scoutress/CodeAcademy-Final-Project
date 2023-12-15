package lt.codeacademy.javau7.finalproject1.services;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;
import lt.codeacademy.javau7.finalproject1.entities.User;
import lt.codeacademy.javau7.finalproject1.entities.WebUser;

@Service
public interface UserService {

    List<User> getAllUsers();

    void saveUser(User newUser);

    User getUserById(Long id);

    void updateUser(User updatedUser);

    void deleteById(int id);

    User findByUsername(String username);

    void save(@Valid WebUser theWebUser);
}
