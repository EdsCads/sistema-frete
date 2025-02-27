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
public class RegistrarFreteTest {

    @Mock
    private FreteDAO freteDAO;

    @Mock
    private DistanciaDAO distanciaDAO;

    @Mock
    private CategoriaFreteDAO categoriaFreteDAO;

    @InjectMocks
    private FreteService freteService;

    private Frete frete;
    private Cidade origem;
    private Cidade destino;
    private CategoriaFrete categoriaFrete;

    @BeforeEach
    void setUp() {
        origem = new Cidade();
        origem.setId(1L);

        destino = new Cidade();
        destino.setId(2L);

        categoriaFrete = new CategoriaFrete();
        categoriaFrete.setId(1L);
        categoriaFrete.setPercentual(10.0);

        frete = new Frete();
        frete.setOrigem(origem);
        frete.setDestino(destino);
        frete.setCategoriaFrete(categoriaFrete);
    }

    @Test
    void testRegistrarFrete() {
        // Mock do DAO de Distância
        Distancia distancia = new Distancia();
        distancia.setQuilometragem(100.0);
        when(distanciaDAO.findById(origem.getId())).thenReturn(distancia);

        // Mock do DAO de CategoriaFrete
        when(categoriaFreteDAO.findById(categoriaFrete.getId())).thenReturn(categoriaFrete);

        // Mock do DAO de Frete
        when(freteDAO.save(frete)).thenReturn(frete);

        // Executa o método a ser testado
        Frete freteRegistrado = freteService.registrarFrete(frete);

        // Verifica se o valor do frete foi calculado corretamente
        assertEquals(165.0, freteRegistrado.getValor()); // 100 * 1.5 * (1 + 10/100) = 165

        // Verifica se o método save foi chamado
        verify(freteDAO, times(1)).save(frete);
    }
}