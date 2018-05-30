package com.alcarrer.service.fornecedor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alcarrer.model.Fornecedor;
import com.alcarrer.repository.FornecedorRepository;

@Service
public class FornecedorServiceImpl implements FornecedorService {

	@Autowired
	private FornecedorRepository repository;
	
	@Override
	public Fornecedor incluir(Fornecedor entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public Fornecedor alterar(Fornecedor entity) {
		Fornecedor fornecedorDB = repository.findOne(entity.getCodigo());
	 	fornecedorDB.setDescricao(entity.getDescricao());
		fornecedorDB.setNome(entity.getNome());
		return repository.saveAndFlush(entity);
	}

	@Override
	public void excluir(Fornecedor entity) {
		Fornecedor fornecedorDB = repository.findOne(entity.getCodigo());
		repository.delete(fornecedorDB);
	}

	@Override
	public List<Fornecedor> consultar() {
		return repository.findAll();
	}

	@Override
	public Fornecedor consultarByCodigo(Fornecedor entity) {
		return repository.findOne(entity.getCodigo());
	}

}
