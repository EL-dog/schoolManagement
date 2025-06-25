package com.easySchool.schoolManagement.entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.mapping.OneToMany;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    
    private String password;
    private String role;

    @jakarta.persistence.OneToMany(mappedBy = "createdBy", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Student> students = new ArrayList<>();


    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }
    public String getRole(){
        return role;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }

     public void setRole(String role) {
        this.role = role;
    }
    public Long getId() { return id; }

}
