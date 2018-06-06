package com.alcarrer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcarrer.dto.CategoriaDTO;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaDTO, Integer> {

}
