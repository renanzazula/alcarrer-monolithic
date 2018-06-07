package com.alcarrer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcarrer.entity.MedidaEntity;

@Repository
public interface MedidaRepository extends JpaRepository<MedidaEntity, Integer> {
	// TODO: FIX...
	public List<MedidaEntity> findByItensTipoMedidaCategoriaAndItensTipoMedidaSubCategoriaAndItensTipoMedidaMarca(
			Integer categoria_codigo, Integer sub_categoria_codigo, Integer marca_codigo);

}
