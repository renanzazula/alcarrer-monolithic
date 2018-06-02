package com.alcarrer.service.categoria;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alcarrer.model.Categoria;
import com.alcarrer.model.SubCategoria;
import com.alcarrer.repository.CategoriaRepository;
import com.alcarrer.repository.SubCategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Autowired
	private SubCategoriaRepository subCategoriaRepository;

	@Override
	@Transactional
	public Categoria incluir(Categoria categoria) {

		Categoria categoriaDB = new Categoria();
		categoriaDB.setDescricao(categoria.getDescricao());
		categoriaDB.setNome(categoria.getNome());

		Set<SubCategoria> subCategoria = new HashSet<>();
		categoria.getSubCategorias().forEach(sub -> {
			subCategoria.add(subCategoriaRepository.findOne(sub.getCodigo()));
		});

		categoriaDB.setSubCategoriasSet(subCategoria);

		return repository.saveAndFlush(categoriaDB);
	}

	@Override
	@Transactional
	public Categoria alterar(Categoria categoria) {

		Categoria categoriaDB = repository.findOne(categoria.getCodigo());
		categoriaDB.setDescricao(categoria.getDescricao());
		categoriaDB.setNome(categoria.getNome());
		categoriaDB.getSubCategoriasSet().clear();
		Set<SubCategoria> subCategoria = new HashSet<>();
		categoria.getSubCategorias().forEach(sub -> {
			subCategoria.add(subCategoriaRepository.findOne(sub.getCodigo()));
		});
		categoriaDB.getSubCategoriasSet().addAll(subCategoria);

		return repository.saveAndFlush(categoriaDB);
	}

	@Override
	@Transactional(readOnly = true)
	public Categoria consultarByCodigo(Categoria entity) {
		return repository.findOne(entity.getCodigo());
	}

	@Override
	@Transactional(readOnly = true)
	public Map<Long, Categoria> consultaCategoriaSubCategoria() {

		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Categoria> consultar() {
		return repository.findAll();
	}

	@Override
	@Transactional
	public void excluir(Categoria entity) {
		Categoria categoriaDB = repository.findOne(entity.getCodigo());
		categoriaDB.getSubCategoriasSet().clear();
		repository.saveAndFlush(categoriaDB);
		repository.delete(repository.findOne(entity.getCodigo()));
	}

}
