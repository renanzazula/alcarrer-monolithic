package com.alcarrer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcarrer.dto.RecebimentoDTO;

@Repository
public interface RecebimentoRepository extends JpaRepository<RecebimentoDTO, Integer> {

}
