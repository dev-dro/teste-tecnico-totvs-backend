package com.devdro.testebackendtotvs.services;

import com.devdro.testebackendtotvs.model.BaseEntity;
import java.util.List;
import java.util.Optional;

public interface BaseEntityService<T extends BaseEntity> {
  List<T> findAll();
  Optional<T> find(Long id);
  T save(T entity);
  void inactivate(Long id);
}
