package com.example.estudo_jpa.service;

import com.example.estudo_jpa.dto.DisciplinaResponseDto;
import com.example.estudo_jpa.entity.Disciplina;
import com.example.estudo_jpa.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
    @Transactional
    public void deleteDisciplina(Long id){
        repository.deleteById(id);
    }
    @Transactional
    public Optional<Disciplina> getById(Long id){
        return repository.findById(id);
    }
    @Transactional
    public Disciplina updateDisciplina(DisciplinaResponseDto disciplinaResponseDto, Long id){
        Disciplina disciplina = repository.findById(id).orElseThrow(()-> new NoSuchElementException("Essa disciplina não existe"));

        disciplina.setNome(disciplinaResponseDto.nome());
        return repository.save(disciplina);
    }
}
