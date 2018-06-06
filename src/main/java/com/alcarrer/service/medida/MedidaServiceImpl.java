package com.alcarrer.service.medida;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alcarrer.entity.MedidaEntity;
import com.alcarrer.function.JpaFunctions;
import com.alcarrer.model.Medida;
import com.alcarrer.model.Produto;
import com.alcarrer.repository.MedidaRepository;

@Service
public class MedidaServiceImpl implements MedidaService {

	@Autowired
	private MedidaRepository repository;

	@Override
	public Medida incluir(Medida entity) {
		MedidaEntity medidaDB = new MedidaEntity();
		medidaDB.setDescricao(entity.getDescricao());
		medidaDB.setNome(entity.getNome());
		return JpaFunctions.medidaDTOtoMedida.apply(repository.saveAndFlush(medidaDB));
	}

	@Override
	public Medida alterar(Medida entity) {
		MedidaEntity medidaDB = repository.findOne(entity.getCodigo());
		medidaDB.setDescricao(entity.getDescricao());
		medidaDB.setNome(entity.getNome());
		return JpaFunctions.medidaDTOtoMedida.apply(repository.saveAndFlush(medidaDB));
	}

	@Override
	public void excluir(Medida objct) {
		MedidaEntity medidaDB = repository.findOne(objct.getCodigo());
		repository.delete(medidaDB);
	}

	@Override
	public Map<Long, Medida> consultar() {

		return null;
	}

	@Override
	public Medida consultarByCodigo(Medida entity) {
		return JpaFunctions.medidaDTOtoMedida.apply(repository.findOne(entity.getCodigo()));
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
