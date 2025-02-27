package com.frete.dao;

import com.frete.model.Cliente;
import jakarta.transaction.Transactional;

import java.util.List;

public class ClienteDAO extends GenericDAO<Cliente> {
    public ClienteDAO() {
        super(Cliente.class);
    }

    public Cliente buscaPorId(Long id) {
        return super.findById(id);
    }

    public List<Cliente> todosClientes() {
        return super.findAll();
    }

    @Transactional
    public Cliente salvaOuAtualiza(Cliente cliente) {
        return super.save(cliente);
    }

    @Transactional
    public void remover(Cliente cliente) {
        super.delete(cliente.getId());
    }
}
