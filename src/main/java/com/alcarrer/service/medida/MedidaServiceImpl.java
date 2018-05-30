package com.alcarrer.service.medida;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alcarrer.model.Medida;
import com.alcarrer.model.Produto;
import com.alcarrer.repository.MedidaRepository;

@Service
public class MedidaServiceImpl implements MedidaService {

	@Autowired
	private MedidaRepository repository;

	@Override
	public Medida incluir(Medida objct) {
		return repository.saveAndFlush(objct);
	}

	@Override
	public Medida alterar(Medida objct) {
		return repository.saveAndFlush(objct);
	}

	@Override
	public void excluir(Medida objct) {
		Medida medidaDB = repository.findOne(objct.getCodigo());
		repository.delete(medidaDB);
	}

	@Override
	public Map<Long, Medida> consultar() {
		
		return null;
	}

	@Override
	public Medida consultarByCodigo(Medida objct) {
		return repository.findOne(objct.getCodigo());
	}

	@Override
	public List<Medida> consultarByProdutoAndValor(Produto produto) {
		
		return null;
	}

	@Override
	public List<Medida> consultarByCategoriaSubCategoriaMarca(Produto produto) {
		
		return null;
	}

}
