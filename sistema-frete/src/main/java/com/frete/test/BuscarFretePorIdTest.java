package com.frete.test;

import com.frete.service.*;
import com.frete.dao.*;
import com.frete.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BuscarFretePorIdTest {

    @Mock
    private FreteDAO freteDAO;

    @InjectMocks
    private FreteService freteService;

    private Frete frete;

    @BeforeEach
    void setUp() {
        frete = new Frete();
        frete.setId(1L);
    }

    @Test
    void testBuscarFretePorId() {
        // Mock do DAO de Frete
        when(freteDAO.findById(frete.getId())).thenReturn(frete);

        // Executa o método a ser testado
        Frete freteEncontrado = freteService.buscarFretePorId(frete.getId());

        // Verifica se o frete foi encontrado corretamente
        assertNotNull(freteEncontrado);
        assertEquals(frete, freteEncontrado);

        // Verifica se o método findById foi chamado
        verify(freteDAO, times(1)).findById(frete.getId());
    }
}