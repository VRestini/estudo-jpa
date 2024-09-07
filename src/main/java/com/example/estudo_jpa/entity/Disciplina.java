package com.example.estudo_jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "TBL_DISCIPLINA")
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DISCIPLINA")
    private Long id;
    @Column(nullable = false, name = "TX_NOME", length = 60)
    private String nome;

    public void setNome(String nome) {
        this.nome = nome;
    }
}
