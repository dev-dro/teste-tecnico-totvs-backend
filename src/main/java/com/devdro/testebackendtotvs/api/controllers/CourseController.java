package com.devdro.testebackendtotvs.api.controllers;

import com.devdro.testebackendtotvs.api.dto.CourseDTO;
import com.devdro.testebackendtotvs.api.mapper.CourseMapper;
import com.devdro.testebackendtotvs.model.Course;
import com.devdro.testebackendtotvs.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/courses")
public class CourseController extends BaseEntityController<Course, CourseDTO> {

  private final CourseService courseService;

  @Override
  protected CourseService getService() {
    return this.courseService;
  }

  @Override
  protected CourseMapper getMapper() {
    return CourseMapper.getInstance();
  }

  @Override
  protected void updateValues(Course entity, Course values) {
    entity.setName(values.getName());
  }
}
