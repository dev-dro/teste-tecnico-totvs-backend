package com.devdro.testebackendtotvs.services.jpa;

import com.devdro.testebackendtotvs.model.Student;
import com.devdro.testebackendtotvs.repositories.StudentRepository;
import com.devdro.testebackendtotvs.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentJpaService extends BaseEntityJpaService<Student> implements StudentService {

  private final StudentRepository studentRepository;

  @Override
  protected StudentRepository getRepository() {
    return this.studentRepository;
  }
}
