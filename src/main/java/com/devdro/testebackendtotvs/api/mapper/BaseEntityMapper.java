package com.devdro.testebackendtotvs.api.mapper;

import com.devdro.testebackendtotvs.model.BaseEntity;

public abstract class BaseEntityMapper<T extends BaseEntity, DTO> {

  public abstract T toEntity(DTO dto);

  public abstract DTO toDto(T entity);
}
