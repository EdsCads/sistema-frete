package com.frete.test;

import com.frete.service.*;
import com.frete.dao.*;
import com.frete.model.*;
import com.frete.service.FreteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ListarFretesPorClienteTest {

    @Mock
    private FreteDAO freteDAO;

    @InjectMocks
    private FreteService freteService;

    private Cliente cliente;
    private Frete frete;

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
        cliente.setId(1L);

        frete = new Frete();
        frete.setId(1L);
        frete.setCliente(cliente);
    }

    @Test
    void testListarFretesPorCliente() {
        // Mock do DAO de Frete
        when(freteDAO.buscarPorCliente(cliente)).thenReturn(Arrays.asList(frete));

        // Executa o método a ser testado
        List<Frete> fretes = freteService.listarFretesPorCliente(cliente);

        // Verifica se a lista de fretes foi retornada corretamente
        assertNotNull(fretes);
        assertEquals(1, fretes.size());
        assertEquals(frete, fretes.get(0));

        // Verifica se o método buscarPorCliente foi chamado
        verify(freteDAO, times(1)).buscarPorCliente(cliente);
    }
}