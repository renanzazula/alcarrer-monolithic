package com.alcarrer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcarrer.dto.FormaDePagamentoDTO;

@Repository
public interface FormaDePagamentoRepository extends JpaRepository<FormaDePagamentoDTO, Integer> {

}
