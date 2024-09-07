package com.example.estudo_jpa.repository;

import com.example.estudo_jpa.entity.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long> {
}
