package com.alcarrer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcarrer.entity.MedidaEntity;

@Repository
public interface MedidaRepository extends JpaRepository<MedidaEntity, Integer> {
	
	
	
}
