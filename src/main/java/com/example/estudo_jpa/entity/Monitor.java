package com.example.estudo_jpa.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "TBL_MONITOR")
public class Monitor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID_MONITOR")
    private Long id;
    @Column (name = "TX_NOME", nullable = false, length = 60)
    private String nome;
    @Column (name = "TX_FOTO", nullable = false, length = 255)
    private String foto;
    @Column (name = "TX_WHATSAPP", nullable = false, length = 11)
    private int whatsapp;
    @Column (name = "TX_EMAIL", nullable = false, length = 40)
    private String email;
    @Column (name = "TX_CONETUDO", nullable = false, length = 1000)
    private String conteudo;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "monitor", fetch = FetchType.LAZY)
    private Set<Conexao> conexoes = new HashSet<>();
    //WRITE_ONLY nn deixa uma determinada informação ser exposta na serialização do json
    // Lazy carraga dados sob demanda, enquanto Eager carrega todos os dados, realizando apenas uma consulta
    // monitor é o nome do atributo criado na classe Conexao para receber o id do Monito
    // set invés de List porque Set é mais otimizado na hora de realizar uma consulta pq utiliza hash
    @ManyToOne
    @JoinColumn(name = "ID_DISCIPLINA")
    private Disciplina disciplina;
    @ManyToMany
    @JoinTable(name = "TBL_REL_MONITOR_DISPONIBILIDADE",
            joinColumns = @JoinColumn(name = "ID_MONITOR"),
            inverseJoinColumns = @JoinColumn(name = "ID_DISPONIBILIDADE"))
    private List<Disponibilidade> disponibilidades;
}
