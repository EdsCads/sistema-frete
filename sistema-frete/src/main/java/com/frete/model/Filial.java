package com.frete.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Filial implements EntidadeBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    private String endereco;
    private String telefone;
    @OneToMany(mappedBy = "filial")
    private List<Veiculo> veiculos;

    @Override
    public Long getId() {
        return null;
    }
}
