package com.devdro.testebackendtotvs.api.mapper;

import com.devdro.testebackendtotvs.api.dto.CourseDTO;
import com.devdro.testebackendtotvs.api.dto.StudentDTO;
import com.devdro.testebackendtotvs.model.Course;
import com.devdro.testebackendtotvs.model.Student;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentMapper extends BaseEntityMapper<Student, StudentDTO> {

  private static StudentMapper INSTANCE;

  private StudentMapper() {}

  public static StudentMapper getInstance() {
    if (INSTANCE == null) {
      INSTANCE = new StudentMapper();
    }
    return INSTANCE;
  }

  @Override
  public Student toEntity(StudentDTO dto) {
    if (dto == null) {
      return null;
    }

    Student student = toEntityWithoutCourses(dto);
    student.setCourses(mapCoursesToEntity(dto.getCourses()));
    return student;
  }

  @Override
  public StudentDTO toDto(Student student) {
    if (student == null) {
      return null;
    }

    StudentDTO dto = toDtoWithoutCourses(student);
    dto.setCourses(mapCoursesToDto(student.getCourses()));
    return dto;
  }

  public Student toEntityWithoutCourses(StudentDTO dto) {
    if (dto == null) {
      return null;
    }

    Student student = new Student();
    student.setId(dto.getId());
    student.setActive(dto.getActive());
    student.setName(dto.getName());
    return student;
  }

  public StudentDTO toDtoWithoutCourses(Student student) {
    if (student == null) {
      return null;
    }

    StudentDTO dto = new StudentDTO();
    dto.setId(student.getId());
    dto.setActive(student.getActive());
    dto.setName(student.getName());
    return dto;
  }

  private Set<Course> mapCoursesToEntity(List<CourseDTO> dtos) {
    if (dtos == null) {
      return null;
    }

    CourseMapper courseMapper = CourseMapper.getInstance();
    return dtos.stream()
        .map(courseMapper::toEntityWithoutStudents)
        .collect(Collectors.toSet());
  }

  private List<CourseDTO> mapCoursesToDto(Set<Course> courses) {
    if (courses == null) {
      return null;
    }

    CourseMapper courseMapper = CourseMapper.getInstance();
    return courses.stream()
        .map(courseMapper::toDtoWithoutStudents)
        .collect(Collectors.toList());
  }
}
