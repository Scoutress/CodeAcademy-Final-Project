// package lt.codeacademy.javau7.project.servicesImpl;

// import java.util.List;
// import lt.codeacademy.javau7.project.entities.User;
// import lt.codeacademy.javau7.project.repositories.UserRepository;
// import lt.codeacademy.javau7.project.services.UserService;
// import org.springframework.stereotype.Service;

// @Service
// public class UserServiceImpl implements UserService {

//     private final UserRepository userRepository;

//     public UserServiceImpl(UserRepository userRepository) {
//         this.userRepository = userRepository;
//     }

//     @Override
//     public List<User> findAll() {
//         return userRepository.findAll();
//     }

//     @Override
//     public User findById(int id) {
//         return userRepository.findById(id).orElse(null);
//     }

//     @Override
//     public User save(User user) {
//         return userRepository.save(user);
//     }

//     @Override
//     public void deleteById(int id) {
//         userRepository.deleteById(id);
//     }

//     @Override
//     public User findByUsername(String username) {
//         return userRepository.findByUsername(username);
//     }
// }
