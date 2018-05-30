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
	public Fornecedor incluir(Fornecedor objct) {
		return repository.saveAndFlush(objct);
	}

	@Override
	public Fornecedor alterar(Fornecedor objct) {
		return repository.saveAndFlush(objct);
	}

	@Override
	public void excluir(Fornecedor objct) {
		Fornecedor fornecedorDB = repository.findOne(objct.getCodigo());
		repository.delete(fornecedorDB);
	}

	@Override
	public List<Fornecedor> consultar() {
		return repository.findAll();
	}

	@Override
	public Fornecedor consultarByCodigo(Fornecedor objct) {
		return repository.findOne(objct.getCodigo());
	}

}
