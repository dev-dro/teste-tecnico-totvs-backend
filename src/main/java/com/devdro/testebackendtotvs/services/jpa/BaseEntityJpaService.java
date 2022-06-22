package com.devdro.testebackendtotvs.services.jpa;

import com.devdro.testebackendtotvs.model.BaseEntity;
import com.devdro.testebackendtotvs.repositories.BaseEntityRepository;
import com.devdro.testebackendtotvs.services.BaseEntityService;
import java.util.List;
import java.util.Optional;

public abstract class BaseEntityJpaService<T extends BaseEntity> implements BaseEntityService<T> {

  protected abstract BaseEntityRepository<T> getRepository();

  @Override
  public List<T> findAll() {
    return getRepository().findAll();
  }

  @Override
  public Optional<T> find(Long id) {
    return getRepository().findById(id);
  }

  @Override
  public T save(T entity) {
    return entity.getId() == null ? create(entity) : update(entity);
  }

  protected T create(T entity) {
    entity.setActive(true);
    return getRepository().save(entity);
  }

  protected T update(T entity) {
    return getRepository().save(entity);
  }

  @Override
  public void inactivate(Long id) {
    this.find(id)
        .ifPresent(entity -> {
          entity.setActive(false);
          getRepository().save(entity);
        });
  }
}
