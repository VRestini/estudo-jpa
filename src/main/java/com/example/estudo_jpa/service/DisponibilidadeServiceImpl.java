package com.example.estudo_jpa.service;

import com.example.estudo_jpa.dto.DisponibilidadeResponseDto;
import com.example.estudo_jpa.entity.Disponibilidade;
import com.example.estudo_jpa.repository.DisciplinaRepository;
import com.example.estudo_jpa.repository.DisponibilidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DisponibilidadeServiceImpl {
    @Autowired
    private DisponibilidadeRepository disponibilidadeRepository;
    public List<Disponibilidade> getAllDisponibilidade(){return disponibilidadeRepository.findAll();}
    @Transactional
    public Disponibilidade saveDisponibilidade(DisponibilidadeResponseDto disponibilidadeResponseDto){
        Disponibilidade disponibilidade = new Disponibilidade();
        disponibilidade.setDiaSemana(disponibilidadeResponseDto.diaSemana());
        disponibilidade.setDataFinal(disponibilidadeResponseDto.dataFinal());
        disponibilidade.setDataInicial(disponibilidadeResponseDto.dataInicial());
        return disponibilidadeRepository.save(disponibilidade);
    }
}
