package com.alcarrer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcarrer.dto.ProdutoDTO;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoDTO, Integer> {

}
