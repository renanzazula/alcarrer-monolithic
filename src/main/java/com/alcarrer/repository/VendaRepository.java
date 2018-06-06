package com.alcarrer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alcarrer.dto.VendaDTO;

@Repository
public interface VendaRepository extends JpaRepository<VendaDTO, Integer> {

}
