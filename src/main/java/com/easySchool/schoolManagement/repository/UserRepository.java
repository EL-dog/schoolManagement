package com.easySchool.schoolManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easySchool.schoolManagement.entity.AppUser;

public interface UserRepository extends JpaRepository<AppUser,Long> {
Optional<AppUser> findByUsername(String username);
    
} 