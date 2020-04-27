package com.mimosa.firedance.repository;

import com.mimosa.firedance.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * 根据email查找用户
     * 
     * @param email
     * @return 用户
     */
    User findByEmail(String email);

    /**
     * 根据用户名查找用户
     * 
     * @param userName 用户名
     * @return 用户
     */
    User findByUserName(String userName);
}