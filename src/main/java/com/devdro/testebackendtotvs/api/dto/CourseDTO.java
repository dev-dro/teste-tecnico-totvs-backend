package com.devdro.testebackendtotvs.api.dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDTO {
  private Long id;
  private String name;
  private Boolean active;
  private List<StudentDTO> students;
}
