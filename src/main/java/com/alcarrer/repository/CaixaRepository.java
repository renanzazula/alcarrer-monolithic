package com.alcarrer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcarrer.model.Caixa;

@Repository
public interface CaixaRepository extends JpaRepository<Caixa, Integer> {

}
