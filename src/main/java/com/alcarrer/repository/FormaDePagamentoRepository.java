package com.alcarrer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcarrer.entity.FormaDePagamentoEntity;

@Repository
public interface FormaDePagamentoRepository extends JpaRepository<FormaDePagamentoEntity, Integer> {

}
