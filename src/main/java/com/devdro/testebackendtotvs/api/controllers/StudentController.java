package com.devdro.testebackendtotvs.api.controllers;

import com.devdro.testebackendtotvs.api.dto.StudentDTO;
import com.devdro.testebackendtotvs.api.mapper.BaseEntityMapper;
import com.devdro.testebackendtotvs.api.mapper.StudentMapper;
import com.devdro.testebackendtotvs.model.Student;
import com.devdro.testebackendtotvs.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/students")
public class StudentController extends BaseEntityController<Student, StudentDTO> {

  private final StudentService studentService;

  @Override
  protected StudentService getService() {
    return this.studentService;
  }

  @Override
  protected BaseEntityMapper<Student, StudentDTO> getMapper() {
    return StudentMapper.getInstance();
  }

  @Override
  protected void updateValues(Student student, Student values) {
   student.setName(values.getName());
   student.setCourses(values.getCourses());
  }
}
