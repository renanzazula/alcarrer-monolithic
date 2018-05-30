package com.alcarrer.service.marca;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alcarrer.enums.Status;
import com.alcarrer.model.Marca;
import com.alcarrer.repository.MarcaRepository;

@Service
public class MarcaServiceImpl implements MarcaService {

	@Autowired
	private MarcaRepository repository;

	@Override
	@Transactional
	public Marca incluir(Marca entity) {
		return repository.save(entity);
	}

	@Override
	@Transactional
	public Marca alterar(Marca objct) {
		Marca marcaDB = repository.getOne(objct.getCodigo());
		marcaDB.setDescricao(objct.getDescricao());
		marcaDB.setNome(objct.getNome());
		return repository.saveAndFlush(marcaDB);
	}

	@Override
	@Transactional
	public void excluir(Marca objct) {
		Marca marcaDB = repository.getOne(objct.getCodigo());
//		marcaDB.setStatus(Status.Inativo);
		repository.delete(marcaDB);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Marca> consultar() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Marca consultarByCodigo(Marca marca) {
		return repository.findOne(marca.getCodigo());
	}

}
