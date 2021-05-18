package com.geekbrains.geekspringstart.model.dao.repository;


import com.geekbrains.geekspringstart.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
