package com.easySchool.schoolManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Teacher {
    @Id
    @GeneratedValue
    private Long id;

    private String teacherName;
    private String techerAge;
    private String teacherGender;
    private String teacherPhone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private AppUser createdBy;

    public void setCreatedBy(AppUser user) {
        this.createdBy = user;
    }

    public void setTeacherName(String name) {
        this.teacherName = name;
    }

    public void setTeacherAge(String age) {
        this.techerAge = age;
    }

    public void setTeacherGender(String gender) {
        this.teacherGender = gender;
    }

    public void setTeacherPhone(String phone) {
        this.teacherPhone = phone;
    }

    public String getTeacherName(){
        return teacherName;
    }
}
