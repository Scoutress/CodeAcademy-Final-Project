package lt.codeacademy.javau7.finalproject1.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lt.codeacademy.javau7.finalproject1.entities.User;
import lt.codeacademy.javau7.finalproject1.repositories.UserRepository;
import lt.codeacademy.javau7.finalproject1.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User newUser) {
        userRepository.save(newUser);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }

    @Override
    public void updateUser(User updatedUser) {
        userRepository.save(updatedUser);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById((long) id);
    }
}
