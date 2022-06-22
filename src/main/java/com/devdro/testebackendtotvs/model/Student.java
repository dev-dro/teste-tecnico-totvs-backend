package com.devdro.testebackendtotvs.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor()
public class Student extends BaseEntity {

  @Column(nullable = false)
  private String name;

  @ManyToMany
  @JoinTable(
      name = "student_course",
      joinColumns = {@JoinColumn(name = "student_id")},
      inverseJoinColumns = {@JoinColumn(name = "course_id")}
  )
  private Set<Course> courses;

  public Student(Long id, String name, Boolean active) {
    super(id, active);
    this.name = name;
  }

  public void addCourse(Course course) {
    if (this.courses == null) {
      this.courses = new HashSet<>();
    }
    this.courses.add(course);
  }
}
