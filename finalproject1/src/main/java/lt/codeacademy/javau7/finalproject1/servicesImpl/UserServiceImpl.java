package lt.codeacademy.javau7.finalproject1.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lt.codeacademy.javau7.finalproject1.entities.User;
import lt.codeacademy.javau7.finalproject1.entities.WebUser;
import lt.codeacademy.javau7.finalproject1.repositories.UserRepository;
import lt.codeacademy.javau7.finalproject1.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final EntityManager entityManager;

	public UserServiceImpl(EntityManager theEntityManager, UserRepository userRepository) {
		this.entityManager = theEntityManager;
		this.userRepository = userRepository;
	}

	@Override
	public User findByUsername(String theUsername) {
		TypedQuery<User> theQuery = entityManager.createQuery("from User where username=:uName", User.class);
		theQuery.setParameter("uName", theUsername);

		User theUser = null;
		try {
			theUser = theQuery.getSingleResult();
		} catch (Exception e) {
			theUser = null;
		}
		return theUser;
	}

	@Override
	@Transactional
	public void save(WebUser theUser) {
		entityManager.merge(theUser);
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

	// @Override
    // public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //     User user = userRepository.findByUsername(username);

    //     if (user == null) {
    //         throw new UsernameNotFoundException("User not found with username: " + username);
    //     }

    //     return org.springframework.security.core.userdetails.User
    //             .withUsername(user.getUsername())
    //             .password(user.getPassword())
    //             .roles(user.getRoles().stream().map(Role::getName).toArray(String[]::new))
    //             .accountExpired(!user.isEnabled())
    //             .accountLocked(!user.isEnabled())
    //             .credentialsExpired(!user.isEnabled())
    //             .disabled(!user.isEnabled())
    //             .build();
    // }
}
