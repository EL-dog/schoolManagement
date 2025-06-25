package com.easySchool.schoolManagement.repository;

import com.easySchool.schoolManagement.entity.AppUser;
import com.easySchool.schoolManagement.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Teacher> findByTeacherName(String teacherName);

    Optional<Teacher> findById(Long id);
    List<Teacher> findAllByCreatedBy(AppUser user);
    
}
