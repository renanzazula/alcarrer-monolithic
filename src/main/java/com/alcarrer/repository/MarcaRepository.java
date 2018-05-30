package com.alcarrer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcarrer.model.Marca;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Integer> {

}
