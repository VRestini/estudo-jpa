package com.example.estudo_jpa.repository;

import com.example.estudo_jpa.dto.MonitorResponseDTO;
import com.example.estudo_jpa.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {

}
