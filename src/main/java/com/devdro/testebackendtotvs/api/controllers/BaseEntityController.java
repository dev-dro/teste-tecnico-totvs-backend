package com.devdro.testebackendtotvs.api.controllers;

import com.devdro.testebackendtotvs.api.mapper.BaseEntityMapper;
import com.devdro.testebackendtotvs.exceptions.ResourceNotFoundException;
import com.devdro.testebackendtotvs.model.BaseEntity;
import com.devdro.testebackendtotvs.services.BaseEntityService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public abstract class BaseEntityController<T extends BaseEntity, DTO> {

  protected abstract BaseEntityService<T> getService();
  protected abstract BaseEntityMapper<T, DTO> getMapper();
  protected abstract void updateValues(T entity, T values);

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<DTO> findAll() {
    return getService().findAll()
        .stream()
        .map(entity -> getMapper().toDto(entity))
        .collect(Collectors.toList());
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public DTO findById(@PathVariable Long id) {
    return getService().find(id)
        .map(entity -> this.getMapper().toDto(entity))
        .orElseThrow(ResourceNotFoundException::new);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public DTO create(@RequestBody DTO dto) {
    T savedEntity = getService().save(getMapper().toEntity(dto));
    return getMapper().toDto(savedEntity);
  }

  @PutMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public DTO update(@RequestBody DTO dto, @PathVariable Long id) {
    return getService().find(id)
        .map(entity -> {
          updateValues(entity, getMapper().toEntity(dto));
          T savedEntity = getService().save(entity);
          return getMapper().toDto(savedEntity);
        })
        .orElseThrow(ResourceNotFoundException::new);
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity<?> inactivate(@PathVariable Long id) {
    getService().inactivate(id);
    return ResponseEntity.ok().build();
  }
}
