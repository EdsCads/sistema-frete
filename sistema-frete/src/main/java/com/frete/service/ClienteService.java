package com.frete.service;


import com.frete.dao.ClienteDAO;
import com.frete.model.Cliente;
import jakarta.transaction.Transactional;

import java.util.List;

public class ClienteService {
    private final ClienteDAO clienteDAO;

    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public Cliente buscarClientePorId(Long id) {
        return clienteDAO.buscaPorId(id);
    }

    public List<Cliente> listarTodosClientes() {
        return clienteDAO.todosClientes();
    }

    @Transactional
    public Cliente salvarOuAtualizarCliente(Cliente cliente) {
        return clienteDAO.salvaOuAtualiza(cliente);
    }

    @Transactional
    public void removerCliente(Cliente cliente) {
        clienteDAO.remover(cliente);
    }
}
