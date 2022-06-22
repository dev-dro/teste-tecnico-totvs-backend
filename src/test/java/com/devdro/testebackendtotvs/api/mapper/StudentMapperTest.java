package com.devdro.testebackendtotvs.api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.devdro.testebackendtotvs.api.dto.CourseDTO;
import com.devdro.testebackendtotvs.api.dto.StudentDTO;
import com.devdro.testebackendtotvs.model.Course;
import com.devdro.testebackendtotvs.model.Student;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class StudentMapperTest {

  private static final Long ID = 1L;
  private static final String NAME = "John Doe";

  StudentMapper studentMapper = StudentMapper.getInstance();

  @Test
  public void toStudent() {
    StudentDTO dto = new StudentDTO();
    dto.setId(ID);
    dto.setName(NAME);
    dto.setActive(true);

    dto.setCourses(new ArrayList<>());
    CourseDTO course = new CourseDTO();
    course.setId(ID);
    dto.getCourses().add(course);

    Student student = studentMapper.toEntity(dto);

    assertEquals(ID, student.getId());
    assertEquals(NAME, student.getName());
    assertTrue(student.getActive());
    assertNotNull(student.getCourses());
    assertEquals(student.getCourses().size(), 1);
  }

  @Test
  public void fromStudent() {
    Student student = new Student();
    student.setId(ID);
    student.setName(NAME);
    student.setActive(true);

    Course course = new Course();
    course.setId(ID);
    student.addCourse(course);

    StudentDTO dto = studentMapper.toDto(student);

    assertEquals(ID, dto.getId());
    assertEquals(NAME, dto.getName());
    assertTrue(dto.getActive());
    assertNotNull(dto.getCourses());
    assertEquals(dto.getCourses().size(), 1);
  }
}
