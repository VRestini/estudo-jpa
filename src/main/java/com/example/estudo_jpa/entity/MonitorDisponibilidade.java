package com.example.estudo_jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "TBL_REL_MONITOR_DISPONIBILIDADE")
public class MonitorDisponibilidade {
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_MONITOR")
    private Monitor monitor;
    @Id
    @ManyToOne
    @JoinColumn(name = "ID_DISPONIBILIDADE")
    private Disponibilidade disponibilidade;
}
