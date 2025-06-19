package com.easySchool.schoolManagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Student {
    @Id @GeneratedValue
    private Long id;

    private String studentName;
    private String studentAge;
    private String studentClass;
    private String studentGender;

      @ManyToOne(fetch=FetchType.LAZY)
      @JoinColumn(name = "user_id")
      private AppUser createdBy;

      public void setCreatedBy(AppUser user){
         this.createdBy = user;
      }
     public void setStudentName(String studentName){
        this.studentName = studentName;
     }
     public void setStudentAge(String studentAge){
        this.studentAge = studentAge;
     }

     public void setStudentClass(String studentClass){
        this.studentClass = studentClass;
     }

     public void setStudentGender(String studentGender){
        this.studentGender = studentGender;
     }

     public String getStudentName(){
        return studentName;
     }
     public String getStudentAge(){
        return studentAge;
     }
     public String getStudentClass(){
        return studentClass;
     }
     public String getStudentGender(){
        return studentGender;
     }

    
}
