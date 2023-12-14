package lt.codeacademy.javau7.finalproject1.servicesImpl;

import java.util.List;
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
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
