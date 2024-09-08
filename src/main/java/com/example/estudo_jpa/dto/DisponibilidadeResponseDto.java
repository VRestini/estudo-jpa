package com.example.estudo_jpa.dto;

import java.time.LocalDateTime;

public record DisponibilidadeResponseDto(String diaSemana, LocalDateTime dataInicial, LocalDateTime dataFinal, Long id) {
}
