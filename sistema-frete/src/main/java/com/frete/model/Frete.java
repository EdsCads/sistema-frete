package com.frete.model;

import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Frete implements EntidadeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Veiculo veiculo;

    @ManyToOne
    private Cidade origem;

    @ManyToOne
    private Cidade destino;

    @ManyToOne
    private Funcionario funcionario;

    @ManyToOne
    private CategoriaFrete categoriaFrete; // Adicionado campo categoriaFrete

    @OneToMany(mappedBy = "frete")
    private List<ItemTransporte> itens;

    private Double valor;

    @Override
    public Long getId() {
        return this.id; // Corrigido para retornar o ID correto
    }
}