package com.easySchool.schoolManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easySchool.schoolManagement.entity.Student;

import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student,Long> {

    Optional<Student>  findByStudentName(String studentName);
} 
