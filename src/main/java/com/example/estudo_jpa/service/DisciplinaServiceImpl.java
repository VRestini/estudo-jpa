package com.example.estudo_jpa.service;

import com.example.estudo_jpa.dto.DisciplinaResponseDto;
import com.example.estudo_jpa.entity.Disciplina;
import com.example.estudo_jpa.entity.Disponibilidade;
import com.example.estudo_jpa.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DisciplinaServiceImpl {
    @Autowired
    private DisciplinaRepository repository;
    public List<Disciplina> getAllDisciplina(){
        return repository.findAll();
    }
    @Transactional
    public Disciplina saveDisciplica(DisciplinaResponseDto disciplinaResponseDto){
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(disciplinaResponseDto.nome());
        return repository.save(disciplina);
    }
}
