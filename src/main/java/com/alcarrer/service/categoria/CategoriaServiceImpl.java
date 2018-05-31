package com.alcarrer.service.categoria;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alcarrer.model.Categoria;
import com.alcarrer.repository.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Override
	public Categoria incluir(Categoria entity) {
		return repository.saveAndFlush(entity);
	}

	@Override
	public Categoria alterar(Categoria entity) {
		Categoria categoriaDB = repository.findOne(entity.getCodigo());
		categoriaDB.setDescricao(entity.getDescricao());
		categoriaDB.setNome(entity.getNome());
		return repository.saveAndFlush(categoriaDB);
	}

	@Override
	public Categoria consultarByCodigo(Categoria entity) {
		return repository.findOne(entity.getCodigo());
	}

	@Override
	public Map<Long, Categoria> consultaCategoriaSubCategoria() {
		
		return null;
	}

	@Override
	public List<Categoria> consultar() {
		return repository.findAll();
	}

	@Override
	public void excluir(Categoria entity) {
		Categoria categoriaDB = repository.findOne(entity.getCodigo());
		repository.delete(categoriaDB);
	}

}
