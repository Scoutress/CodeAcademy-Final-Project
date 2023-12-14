package lt.codeacademy.javau7.finalproject1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.codeacademy.javau7.finalproject1.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);}
