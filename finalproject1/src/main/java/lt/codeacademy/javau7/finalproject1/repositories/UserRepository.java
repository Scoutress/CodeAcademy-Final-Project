package lt.codeacademy.javau7.finalproject1.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.codeacademy.javau7.finalproject1.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    Optional<User> findById(Long id);

    void deleteById(int id);}
