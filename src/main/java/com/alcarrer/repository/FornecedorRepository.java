package com.alcarrer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcarrer.dto.FornecedorDTO;
import com.alcarrer.model.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<FornecedorDTO, Integer> {

}
