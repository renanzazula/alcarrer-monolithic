package com.alcarrer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcarrer.dto.SubCategoriaDTO;

@Repository
public interface SubCategoriaRepository extends JpaRepository<SubCategoriaDTO, Integer> {

}
