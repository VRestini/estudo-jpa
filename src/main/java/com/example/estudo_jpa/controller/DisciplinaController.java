package com.example.estudo_jpa.controller;

import com.example.estudo_jpa.dto.DisciplinaResponseDto;
import com.example.estudo_jpa.entity.Disciplina;
import com.example.estudo_jpa.service.DisciplinaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {
    @Autowired
    public DisciplinaServiceImpl disciplinaService;
    @PostMapping("/salvar")
    public ResponseEntity<Disciplina> salvarDisciplina(@RequestBody DisciplinaResponseDto disciplinaResponseDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.saveDisciplica(disciplinaResponseDto));
    }
    @GetMapping
    public ResponseEntity<List<Disciplina>> getDisciplinas(){
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.getAllDisciplina());
    }
}
