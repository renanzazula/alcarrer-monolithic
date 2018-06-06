package com.alcarrer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcarrer.dto.MarcaDTO;

@Repository
public interface MarcaRepository extends JpaRepository<MarcaDTO, Integer> {

}
