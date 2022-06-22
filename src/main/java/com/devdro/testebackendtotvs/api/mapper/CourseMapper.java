package com.devdro.testebackendtotvs.api.mapper;

import com.devdro.testebackendtotvs.api.dto.CourseDTO;
import com.devdro.testebackendtotvs.api.dto.StudentDTO;
import com.devdro.testebackendtotvs.model.Course;
import com.devdro.testebackendtotvs.model.Student;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CourseMapper extends BaseEntityMapper<Course, CourseDTO> {

  private static CourseMapper INSTANCE;

  private CourseMapper() {}

  public static CourseMapper getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new CourseMapper();
    }
    return INSTANCE;
  }

  @Override
  public Course toEntity(CourseDTO dto) {
    if (dto == null) {
      return null;
    }

    Course course = toEntityWithoutStudents(dto);
    course.setStudents(mapStudentsToEntity(dto.getStudents()));
    return course;
  }

  @Override
  public CourseDTO toDto(Course course) {
    if (course == null) {
      return null;
    }

    CourseDTO dto = toDtoWithoutStudents(course);
    dto.setStudents(mapStudentsToDto(course.getStudents()));
    return dto;
  }

  public Course toEntityWithoutStudents(CourseDTO dto) {
    if (dto == null) {
      return null;
    }

    Course course = new Course();
    course.setId(dto.getId());
    course.setActive(dto.getActive());
    course.setName(dto.getName());
    return course;
  }

  public CourseDTO toDtoWithoutStudents(Course course) {
    if (course == null) {
      return null;
    }

    CourseDTO dto = new CourseDTO();
    dto.setId(course.getId());
    dto.setActive(course.getActive());
    dto.setName(course.getName());
    return dto;
  }

  public Set<Student> mapStudentsToEntity(Collection<StudentDTO> dtos) {
    if (dtos == null) {
      return null;
    }

    StudentMapper studentMapper = StudentMapper.getInstance();
    return dtos.stream()
        .map(studentMapper::toEntityWithoutCourses)
        .collect(Collectors.toSet());
  }

  public List<StudentDTO> mapStudentsToDto(Collection<Student> students) {
    if (students == null) {
      return null;
    }

    StudentMapper studentMapper = StudentMapper.getInstance();
    return students.stream()
        .map(studentMapper::toDtoWithoutCourses)
        .collect(Collectors.toList());
  }
}
