package com.example.estudo_jpa.service;



import com.example.estudo_jpa.dto.DisciplinaResponseDto;
import com.example.estudo_jpa.entity.Disciplina;
import com.example.estudo_jpa.repository.DisciplinaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import java.util.stream.Collectors;

@Service
public class DisciplinaServiceImpl {
    @Autowired
    private DisciplinaRepository repository;
    private ModelMapper modelMap = new ModelMapper();

    public List<DisciplinaResponseDto> getAllDisciplina(){
        var disciplinas = repository.findAll();
        var resultado = disciplinas.stream().map(e -> modelMap.map(e, DisciplinaResponseDto.class))
                .collect(Collectors.toList());
        return resultado;

    }
    @Transactional
    public DisciplinaResponseDto saveDisciplica(DisciplinaResponseDto disciplinaResponseDto){
        Disciplina disciplina = modelMap.map(disciplinaResponseDto, Disciplina.class);
        return modelMap.map(repository.save(disciplina), DisciplinaResponseDto.class);
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
    public Disciplina updateDisciplina(DisciplinaResponseDto disciplinaUpdateDTO, Long id){
        Disciplina disciplina = repository.findById(id).orElseThrow(()-> new NoSuchElementException("Essa disciplina não existe"));


        return repository.save(disciplina);
    }
}


