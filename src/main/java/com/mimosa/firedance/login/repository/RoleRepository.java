package com.mimosa.firedance.login.repository;

import com.mimosa.firedance.login.model.Role;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * 根据角色名获取角色信息
     * 
     * @param roleName
     * @return
     */
    Role findByRole(String roleName);
}