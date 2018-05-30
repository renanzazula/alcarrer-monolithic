package com.alcarrer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcarrer.model.Medida;

@Repository
public interface MedidaRepository extends JpaRepository<Medida, Integer> {
	
	
	
}
