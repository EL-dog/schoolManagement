package com.easySchool.schoolManagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easySchool.schoolManagement.dto.StudenDto;
import com.easySchool.schoolManagement.entity.AppUser;
import com.easySchool.schoolManagement.entity.Student;
import com.easySchool.schoolManagement.mapper.StudentMapper;
import com.easySchool.schoolManagement.repository.StudentRepository;
import com.easySchool.schoolManagement.repository.UserRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

     @Autowired
    private StudentMapper studentMapper;
    public void createStudent(StudenDto studenDto, String username) {
        AppUser user = userRepository.findByUsername(username)
            .orElseThrow(() -> new RuntimeException("User not found"));
        // Student student = studentRepository.findById(studenDto.getStudentId()).orElseThrow(()-> new RuntimeException("Student"));

        Student student = studentMapper.toEntity(studenDto);
        student.setCreatedBy(user);
        studentRepository.save(student);

       

        
    }

    public List<StudenDto> getAllStudents(){
        
        return studentRepository.findAll()
        .stream()
        .map(studentMapper::toDto)
        .collect(Collectors.toList());
    }

    public StudenDto getStudentById(Long id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with ID: " + id));
        return studentMapper.toDto(student);
    }
}
