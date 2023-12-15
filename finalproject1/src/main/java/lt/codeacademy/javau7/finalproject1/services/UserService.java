package lt.codeacademy.javau7.finalproject1.services;

import java.util.List;

import jakarta.validation.Valid;
import lt.codeacademy.javau7.finalproject1.entities.User;
import lt.codeacademy.javau7.finalproject1.entities.WebUser;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User newUser);

    User getUserById(Long id);

    void updateUser(User updatedUser);

    void deleteById(int id);

    User findByUsername(String username);

    void save(@Valid WebUser theWebUser);
}
