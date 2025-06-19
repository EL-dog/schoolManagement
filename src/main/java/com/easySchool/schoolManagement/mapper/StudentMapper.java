package com.easySchool.schoolManagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.easySchool.schoolManagement.dto.StudenDto;
import com.easySchool.schoolManagement.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student toEntity(StudenDto dto);
    StudenDto toDto(Student entity);
}