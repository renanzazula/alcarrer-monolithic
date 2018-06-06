package com.alcarrer.service.fornecedor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alcarrer.dto.FornecedorDTO;
import com.alcarrer.function.JpaFunctions;
import com.alcarrer.model.Fornecedor;
import com.alcarrer.repository.FornecedorRepository;

@Service
public class FornecedorServiceImpl implements FornecedorService {

	@Autowired
	private FornecedorRepository repository;
	
	@Override
	public Fornecedor incluir(Fornecedor entity) {
		FornecedorDTO fornecedorDB = new FornecedorDTO();
		fornecedorDB.setDescricao(entity.getDescricao());
		fornecedorDB.setNome(entity.getNome());
		return JpaFunctions.fornecedorDTOtoFornecedor.apply(repository.saveAndFlush(fornecedorDB));
	}

	@Override
	public Fornecedor alterar(Fornecedor entity) {
		FornecedorDTO fornecedorDB = repository.findOne(entity.getCodigo());
	 	fornecedorDB.setDescricao(entity.getDescricao());
		fornecedorDB.setNome(entity.getNome());
		return JpaFunctions.fornecedorDTOtoFornecedor.apply(repository.saveAndFlush(fornecedorDB));
	}

	@Override
	public void excluir(Fornecedor entity) {
		FornecedorDTO fornecedorDB = repository.findOne(entity.getCodigo());
		repository.delete(fornecedorDB);
	}

	@Override
	public List<Fornecedor> consultar() {
		return repository.findAll().stream().map(JpaFunctions.fornecedorDTOtoFornecedor).collect(Collectors.toList());
	}

	@Override
	public Fornecedor consultarByCodigo(Fornecedor entity) {
		return JpaFunctions.fornecedorDTOtoFornecedor.apply(repository.findOne(entity.getCodigo()));
	}

}
