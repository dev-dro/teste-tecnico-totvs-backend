package com.devdro.testebackendtotvs.bootstrap;

import com.devdro.testebackendtotvs.model.Course;
import com.devdro.testebackendtotvs.model.Student;
import com.devdro.testebackendtotvs.repositories.CourseRepository;
import com.devdro.testebackendtotvs.repositories.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

  private final StudentRepository studentRepository;
  private final CourseRepository courseRepository;

  public Bootstrap(StudentRepository studentRepository, CourseRepository courseRepository) {
    this.studentRepository = studentRepository;
    this.courseRepository = courseRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Course geography = new Course();
    geography.setName("Geography");
    geography.setActive(true);

    Course history = new Course();
    history.setName("History");
    history.setActive(true);

    Course mathematics = new Course();
    mathematics.setName("Mathematics");
    mathematics.setActive(true);

    geography = courseRepository.save(geography);
    history = courseRepository.save(history);
    mathematics = courseRepository.save(mathematics);

    log.info("Data Loaded = " + courseRepository.count() + " courses.");

    Student danilo = new Student();
    danilo.setName("Danilo Oliveira");
    danilo.setActive(true);
    danilo.addCourse(mathematics);
    danilo.addCourse(geography);

    Student raquel = new Student();
    raquel.setName("Raquel Silva");
    raquel.setActive(true);
    raquel.addCourse(history);
    raquel.addCourse(geography);

    Student lucas = new Student();
    lucas.setName("Lucas");
    lucas.setActive(true);
    lucas.addCourse(history);

    danilo = studentRepository.save(danilo);
    raquel = studentRepository.save(raquel);
    lucas = studentRepository.save(lucas);

    log.info("Data Loaded = " + studentRepository.count() + " students.");
  }
}
