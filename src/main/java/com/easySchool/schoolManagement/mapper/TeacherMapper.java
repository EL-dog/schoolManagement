package com.easySchool.schoolManagement.mapper;

import com.easySchool.schoolManagement.dto.TeacherDto;
import com.easySchool.schoolManagement.entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    Teacher toEntity(TeacherDto dto);
    TeacherDto toDto(Teacher entity);
     
}
