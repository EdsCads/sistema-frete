package com.frete.dao;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.List;

public abstract class GenericDAO<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> entityClass;

    protected GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T findById(Long id) {
        return entityManager.find(entityClass, id);
    }

    public List<T> findAll() {
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        return entityManager.createQuery(jpql, entityClass).getResultList();
    }

    @Transactional
    public T save(T entity) {
        return entityManager.merge(entity);
    }

    @Transactional
    public void delete(Long id) {
        T entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }
}