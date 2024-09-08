package com.example.estudo_jpa.controller;

import com.example.estudo_jpa.dto.DisponibilidadeResponseDto;
import com.example.estudo_jpa.entity.Disponibilidade;
import com.example.estudo_jpa.repository.DisponibilidadeRepository;
import com.example.estudo_jpa.service.DisponibilidadeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disponibilidade")
public class DisponibilidadeController {
    @Autowired
    DisponibilidadeServiceImpl disponibilidadeService;
    @PostMapping("/save")
    public ResponseEntity saveDisponibilidade(@RequestBody DisponibilidadeResponseDto disponibilidadeResponseDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(disponibilidadeService.saveDisponibilidade(disponibilidadeResponseDto));
    }
    @GetMapping()
    public ResponseEntity<List<Disponibilidade>> getAllDisponibilidade(){
        return ResponseEntity.status(HttpStatus.OK).body(disponibilidadeService.getAllDisponibilidade());
    }
}
