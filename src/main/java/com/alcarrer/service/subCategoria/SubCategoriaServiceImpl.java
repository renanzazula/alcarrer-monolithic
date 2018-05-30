package com.alcarrer.service.subCategoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alcarrer.model.SubCategoria;
import com.alcarrer.repository.SubCategoriaRepository;

@Service
public class SubCategoriaServiceImpl implements SubCategoriaService {

	@Autowired
	private SubCategoriaRepository repository;

	@Override
	public SubCategoria incluir(SubCategoria entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public SubCategoria alterar(SubCategoria entity) {

		return repository.saveAndFlush(entity);
	}

	@Override
	public void excluir(SubCategoria entity) {
		SubCategoria subCategoriaDB = repository.findOne(entity.getCodigo());
		repository.delete(subCategoriaDB);
	}

	@Override
	public List<SubCategoria> consultar() {
		return repository.findAll();
	}

	@Override
	public SubCategoria consultarByCodigo(SubCategoria entity) {
		return repository.findOne(entity.getCodigo());
	}

}
