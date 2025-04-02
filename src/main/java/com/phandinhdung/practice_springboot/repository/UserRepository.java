package com.phandinhdung.practice_springboot.repository;

import com.phandinhdung.practice_springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    //boolean existsByEmail(String email);
    User findByEmail(String email);
}

