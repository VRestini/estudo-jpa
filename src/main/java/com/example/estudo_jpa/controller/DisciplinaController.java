package com.example.estudo_jpa.controller;

import com.example.estudo_jpa.dto.DisciplinaResponseDTO;
import com.example.estudo_jpa.dto.DisciplinaUpdateDTO;
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
    @PostMapping("/save")
    public ResponseEntity<DisciplinaResponseDTO> saveDisciplina(@RequestBody DisciplinaResponseDTO disciplinaResponseDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.saveDisciplica(disciplinaResponseDto));
    }
    @GetMapping
    public ResponseEntity<List<DisciplinaResponseDTO>> getDisciplinas(){
        return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.getAllDisciplina());
    }
    @GetMapping("/{id}")
    public ResponseEntity getDisciplinaById(@PathVariable Long id){
        if (disciplinaService.getById(id).isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        else {
            return ResponseEntity.status(HttpStatus.OK).body(disciplinaService.getById(id));

        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDisciplina(@PathVariable Long id){
        disciplinaService.deleteDisciplina(id);
        return ResponseEntity.status(HttpStatus.OK).body("Disciplina deletada");
    }
    @PutMapping("{id}")
    public ResponseEntity updateDisciplina(@PathVariable Long id, @RequestBody DisciplinaUpdateDTO disciplinaResponseDto){
        return ResponseEntity.ok(disciplinaService.updateDisciplina( disciplinaResponseDto, id));
    }
}