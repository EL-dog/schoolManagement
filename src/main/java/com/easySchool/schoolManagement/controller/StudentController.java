package com.easySchool.schoolManagement.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easySchool.schoolManagement.ApiResponse;
import com.easySchool.schoolManagement.dto.StudenDto;
import com.easySchool.schoolManagement.service.StudentService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/school/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<String>> register(@RequestBody StudenDto entity, Principal principal) {
        studentService.createStudent(entity, principal.getName());
        return ResponseEntity.ok(ApiResponse.success("Congratulation, you are admitted", entity.getStudentName()));
    }


       @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<StudenDto>>> getAllStudents(Principal principal) {
        
        return ResponseEntity.ok(ApiResponse.success("Sucessfull fetched all the students", studentService.getAllStudents()));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudenDto>> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success("Child Information fetched successfully", studentService.getStudentById(id)));
    }

    
    
}
