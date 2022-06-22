package com.devdro.testebackendtotvs.api.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
  private Long id;
  private String name;
  private Boolean active;
  private List<CourseDTO> courses;
}
