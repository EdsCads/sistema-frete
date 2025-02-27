package com.frete.test;

import com.frete.model.*;
import com.frete.service.FreteService;
import jakarta.persistence.*;

public class TesteFrete {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema-frete");
        EntityManager em = emf.createEntityManager();
        FreteService freteService = new FreteService(em);

        Cliente cliente = new Cliente();
        cliente.setNome("João");

        Frete frete = new Frete();
        frete.setCliente(cliente);

        freteService.registrarFrete(frete);

        System.out.println("Frete registrado!");
        em.close();
        emf.close();
    }
}
