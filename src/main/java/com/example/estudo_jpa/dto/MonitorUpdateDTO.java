package com.example.estudo_jpa.dto;

import lombok.Data;

@Data
public class MonitorUpdateDTO {
    private Long id;
    private String nome;
    private String foto;
    private String whatsapp;
    private String email;
    private String conteudo;
    private DisciplinaMonitorDTO disciplina;
}
