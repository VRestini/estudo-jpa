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
    private Long whatsapp;
    @Column (name = "TX_EMAIL", nullable = false, length = 40)
    private String email;
    @Column (name = "TX_CONETUDO", nullable = false, length = 1000)
    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "ID_DISCIPLINA")
    private Disciplina disciplina;

    @ManyToMany
    @JoinTable(name = "TBL_REL_MONITOR_DISPONIBILIDADE",
            joinColumns = @JoinColumn(name = "ID_MONITOR"),
            inverseJoinColumns = @JoinColumn(name = "ID_DISPONIBILIDADE"))
    private List<Disponibilidade> disponibilidades;

}
