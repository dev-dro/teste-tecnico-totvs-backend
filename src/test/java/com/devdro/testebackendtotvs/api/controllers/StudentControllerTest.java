package com.devdro.testebackendtotvs.api.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.devdro.testebackendtotvs.api.dto.StudentDTO;
import com.devdro.testebackendtotvs.model.Student;
import com.devdro.testebackendtotvs.services.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

  private static final String URL = "/api/students";
  private static final String NAME = "John";

  @MockBean
  StudentService studentService;

  @Autowired
  MockMvc mockMvc;

  @Autowired
  ObjectMapper objectMapper;

  @Test
  void findAll() throws Exception {
    Student student = new Student(1L, NAME, true);
    List<Student> students = List.of(student);

    Mockito.when(studentService.findAll()).thenReturn(students);

    mockMvc.perform(get(URL))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", Matchers.hasSize(1)))
        .andExpect(jsonPath("$[0].name", Matchers.is(NAME)));
  }

  @Test
  void findById() throws Exception {
    given(studentService.find(any())).willReturn(Optional.of(new Student()));

    mockMvc.perform(get(URL + new Random().nextLong()).accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  void create() throws Exception {
    StudentDTO dto = StudentDTO.builder().name("John Doe").build();
    String json = objectMapper.writeValueAsString(dto);

    mockMvc.perform(post(URL).contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isCreated());
  }

  @Test
  void update() throws Exception {
    StudentDTO dto = StudentDTO.builder().name("John Doe").build();
    String json = objectMapper.writeValueAsString(dto);

    mockMvc.perform(put(URL + new Random().nextLong()).contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isOk());
  }

  @Test
  void inactivate() {
  }

  @Test
  void getService() {
  }

  @Test
  void getMapper() {
  }

  @Test
  void updateValues() {
  }
}
