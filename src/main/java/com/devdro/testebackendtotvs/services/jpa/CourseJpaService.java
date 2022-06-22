package com.devdro.testebackendtotvs.services.jpa;

import com.devdro.testebackendtotvs.model.Course;
import com.devdro.testebackendtotvs.repositories.CourseRepository;
import com.devdro.testebackendtotvs.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CourseJpaService extends BaseEntityJpaService<Course> implements CourseService {

  private final CourseRepository courseRepository;

  @Override
  protected CourseRepository getRepository() {
    return this.courseRepository;
  }
}
