package com.easySchool.schoolManagement.service;

import com.easySchool.schoolManagement.dto.TeacherDto;
import com.easySchool.schoolManagement.entity.AppUser;
import com.easySchool.schoolManagement.entity.Teacher;
import com.easySchool.schoolManagement.mapper.TeacherMapper;
import com.easySchool.schoolManagement.repository.TeacherRepository;
import com.easySchool.schoolManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeacherMapper teacherMapper;

    public void createTeacher(TeacherDto teacherDto, String username) {
        AppUser user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));

        Teacher teacher = teacherMapper.toEntity(teacherDto);
        teacher.setCreatedBy(user);
        teacherRepository.save(teacher);
    }

    public List<TeacherDto> getAllTeachers() {
        return teacherRepository.findAll()
            .stream()
            .map(teacherMapper::toDto)
            .collect(Collectors.toList());
    }

    public TeacherDto getTeacherById(Long id) {
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found with ID: " + id));
        return teacherMapper.toDto(teacher);
    }
}
