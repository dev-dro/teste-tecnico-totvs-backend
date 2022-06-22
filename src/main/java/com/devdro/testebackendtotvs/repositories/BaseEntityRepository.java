package com.devdro.testebackendtotvs.repositories;

import com.devdro.testebackendtotvs.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseEntityRepository<T extends BaseEntity> extends JpaRepository<T, Long> {
}
