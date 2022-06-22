package com.devdro.testebackendtotvs;

import com.devdro.testebackendtotvs.api.controllers.CourseController;
import com.devdro.testebackendtotvs.api.controllers.StudentController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class TesteBackendTotvsApplicationTests {

  @Autowired
  StudentController studentController;

  @Autowired
  CourseController courseController;

  @Test
  void contextLoads() {
    Assertions.assertNotNull(studentController);
    Assertions.assertNotNull(courseController);
  }

}
