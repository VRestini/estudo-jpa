package com.example.estudo_jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TBL_DISPONIBILIDADE")
public class Disponibilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ID_DISPONIBILIDADE")
    private Long id;

    @Column (nullable = false ,name = "TX_DIA_SEMANA", length = 30)
    private String diaSemana; //caberia uma enum aqui?
    @Column (nullable = false ,name = "DT_DAS")
    private LocalDateTime dataInicial;
    @Column (nullable = false ,name = "DT_ATE")
    private LocalDateTime dataFinal;
}
