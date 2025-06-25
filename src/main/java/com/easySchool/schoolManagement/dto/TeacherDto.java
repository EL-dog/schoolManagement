package com.easySchool.schoolManagement.dto;

import lombok.Getter;

@Getter

public class TeacherDto {
    private Long id;

    private String teacherName;
    private String teacherAge;

    private String teacherGender;
    private String teacherPhone;   

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
    public void setTeacherAge(String teacherAge) {
        this.teacherAge = teacherAge;
    }

    public void setTeacherGender(String teacherGender) {
        this.teacherGender = teacherGender;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

}