package com.easySchool.schoolManagement.dto;

public class StudenDto {
    private Long id;
    private String studentName;
    private String studentAge;
    private String studentGender;
    private String studentClass;

    

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

     public Long getStudentId(){
        return id;
     }
}
