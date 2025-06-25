package com.easySchool.schoolManagement.controller;

import com.easySchool.schoolManagement.ApiResponse;
import com.easySchool.schoolManagement.dto.TeacherDto;
import com.easySchool.schoolManagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/school/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<ApiResponse<String>> registerTeacher(@RequestBody TeacherDto entity, Principal principal){
        teacherService.createTeacher(entity,principal.getName());
        return ResponseEntity.ok(ApiResponse.success("Congratulation, you have been appointed as a Teacher", entity.getTeacherName()));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<TeacherDto>>> getAllTeacher(Principal principal){
        return ResponseEntity.ok(ApiResponse.success("Sucessfull fetched all the students",teacherService.getAllTeachers()));
    }

}
