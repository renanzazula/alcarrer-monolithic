package com.alcarrer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcarrer.entity.ProdutoHasItensTipoMedidaEntity;

@Repository
public interface ProdutoHasItensTipoMedidaRepository extends JpaRepository<ProdutoHasItensTipoMedidaEntity, Integer> {
	
	List<ProdutoHasItensTipoMedidaEntity> findByItensTipoMedidaCodigo(Integer integer); 
}
