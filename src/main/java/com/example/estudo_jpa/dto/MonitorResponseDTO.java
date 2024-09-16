package com.example.estudo_jpa.dto;

import lombok.Data;

@Data
public class MonitorResponseDTO {
    private String nome;
    private String foto;
    private Long whatsapp;
    private String email;
    private String conteudo;
    private DisciplinaMonitorDTO disciplina;
}
