package com.devdro.testebackendtotvs.api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.devdro.testebackendtotvs.api.dto.CourseDTO;
import com.devdro.testebackendtotvs.model.Course;
import org.junit.jupiter.api.Test;

class CourseMapperTest {

  private static final Long ID = 1L;
  private static final String NAME = "Geography";

  CourseMapper courseMapper = CourseMapper.getInstance();

  @Test
  public void toCourse() {
    CourseDTO dto = new CourseDTO();
    dto.setId(ID);
    dto.setName(NAME);
    dto.setActive(true);

    Course course = courseMapper.toEntity(dto);

    assertEquals(ID, course.getId());
    assertEquals(NAME, course.getName());
    assertTrue(course.getActive());
  }

  @Test
  public void fromCourse() {
    Course course = new Course();
    course.setId(ID);
    course.setName(NAME);
    course.setActive(true);

    CourseDTO dto = courseMapper.toDto(course);

    assertEquals(ID, dto.getId());
    assertEquals(NAME, dto.getName());
    assertTrue(dto.getActive());
  }
}
