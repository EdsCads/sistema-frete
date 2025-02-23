package com.frete.dao;

import jakarta.persistence.EntityManager;
import java.util.List;

public class GenericDAO<T> {
    private EntityManager entityManager;
    private Class<T> clazz;

    public GenericDAO(EntityManager entityManager, Class<T> clazz) {
        this.entityManager = entityManager;
        this.clazz = clazz;
    }

    public void salvar(T entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    public T buscarPorId(Long id) {
        return entityManager.find(clazz, id);
    }

    public List<T> listarTodos() {
        return entityManager.createQuery("FROM " + clazz.getSimpleName(), clazz).getResultList();
    }
}
