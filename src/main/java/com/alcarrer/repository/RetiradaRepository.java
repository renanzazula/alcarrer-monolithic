package com.alcarrer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcarrer.dto.RetiradaDTO;

@Repository
public interface RetiradaRepository extends JpaRepository<RetiradaDTO, Integer> {

}
