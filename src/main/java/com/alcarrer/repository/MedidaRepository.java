package com.alcarrer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcarrer.dto.MedidaDTO;

@Repository
public interface MedidaRepository extends JpaRepository<MedidaDTO, Integer> {
	
	
	
}
