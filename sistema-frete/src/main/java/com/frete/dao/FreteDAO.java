package com.frete.dao;

import com.frete.model.Frete;
import com.frete.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FreteDAO extends GenericDAO<Frete> {

    @PersistenceContext
    private EntityManager entityManager;

    public FreteDAO() {
        super(Frete.class);
    }

    public List<Frete> buscarPorCliente(Cliente cliente) {
        String jpql = "SELECT f FROM Frete f WHERE f.cliente = :cliente";
        return entityManager.createQuery(jpql, Frete.class)
                .setParameter("cliente", cliente)
                .getResultList();
    }
}
