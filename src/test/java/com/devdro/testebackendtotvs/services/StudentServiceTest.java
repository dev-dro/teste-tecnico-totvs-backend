package com.devdro.testebackendtotvs.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import com.devdro.testebackendtotvs.model.Student;
import com.devdro.testebackendtotvs.repositories.StudentRepository;
import com.devdro.testebackendtotvs.services.jpa.StudentJpaService;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

  private Student student1;
  private Student student2;

  @Mock
  private StudentRepository studentRepository;

  @InjectMocks
  private StudentJpaService studentService;

  @BeforeEach
  private void setUp() {
   student1 = new Student();
   student1.setId(1L);
   student1.setName("John Doe");
   student1.setActive(true);

   student2 = new Student();
   student2.setId(2L);
   student2.setName("Jane Doe");
   student2.setActive(true);
  }

  @Test
  public void findAllStudents() {
    List<Student> result = Arrays.asList(student1, student2);
    when(studentRepository.findAll()).thenReturn(result);

    List<Student> students = studentService.findAll();

    assertNotNull(students);
    assertEquals(2, students.size());
  }

  @Test
  public void findStudentsById() {
    when(studentRepository.findById(1L)).thenReturn(Optional.of(student1));

    Optional<Student> student = studentService.find(1L);
    assertTrue(student.isPresent());
    assertEquals(student1, student.get());
  }
}
