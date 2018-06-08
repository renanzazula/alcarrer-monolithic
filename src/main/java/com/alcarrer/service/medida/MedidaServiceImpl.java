package com.alcarrer.service.medida;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alcarrer.entity.CategoriaEntity;
import com.alcarrer.entity.MarcaEntity;
import com.alcarrer.entity.MedidaEntity;
import com.alcarrer.entity.SubCategoriaEntity;
import com.alcarrer.function.JpaFunctions;
import com.alcarrer.model.Medida;
import com.alcarrer.model.Produto;
import com.alcarrer.repository.CategoriaRepository;
import com.alcarrer.repository.MarcaRepository;
import com.alcarrer.repository.MedidaRepository;
import com.alcarrer.repository.SubCategoriaRepository;

@Service
public class MedidaServiceImpl implements MedidaService {

	@Autowired
	private MedidaRepository medidaRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private SubCategoriaRepository subCategoriaRepository;

	@Autowired
	private MarcaRepository marcaRepository;

	@Override
	public Medida incluir(Medida entity) {
		MedidaEntity medidaDB = new MedidaEntity();
		medidaDB.setDescricao(entity.getDescricao());
		medidaDB.setNome(entity.getNome());
		return JpaFunctions.medidaDTOtoMedida.apply(medidaRepository.saveAndFlush(medidaDB));
	}

	@Override
	public Medida alterar(Medida entity) {
		MedidaEntity medidaDB = medidaRepository.findOne(entity.getCodigo());
		medidaDB.setDescricao(entity.getDescricao());
		medidaDB.setNome(entity.getNome());
		return JpaFunctions.medidaDTOtoMedida.apply(medidaRepository.saveAndFlush(medidaDB));
	}

	@Override
	public void excluir(Medida objct) {
		MedidaEntity medidaDB = medidaRepository.findOne(objct.getCodigo());
		medidaRepository.delete(medidaDB);
	}

	@Override
	public Map<Long, Medida> consultar() {

		return null;
	}

	@Override
	public Medida consultarByCodigo(Medida entity) {
		return JpaFunctions.medidaDTOtoMedida.apply(medidaRepository.findOne(entity.getCodigo()));
	}

	@Override
	public List<Medida> consultarByProdutoAndValor(Produto produto) {

		return null;
	}

	@Override
	public List<Medida> consultarByCategoriaSubCategoriaMarca(Produto produto) {

		CategoriaEntity categoria = null;
		SubCategoriaEntity subCategoria = null;
		MarcaEntity marca = null;

		if (produto.getMarca() != null && produto.getMarca().getCodigo() != null) {
			marca = marcaRepository.findOne(produto.getMarca().getCodigo());
		}

		if (produto.getCategoria().getSubCategorias() != null && produto.getSubCategoria().getCodigo() != null) {
			subCategoria = subCategoriaRepository.findOne(produto.getSubCategoria().getCodigo());
		}

		if (produto.getCategoria() != null && produto.getCategoria().getCodigo() != null) {
			categoria = categoriaRepository.findOne(produto.getCategoria().getCodigo());
		}

		return medidaRepository
				.findByItensTipoMedidaCategoriaAndItensTipoMedidaSubCategoriaAndAndItensTipoMedidaMarca(categoria,
						subCategoria, marca)
				.stream().map(JpaFunctions.medidaDTOtoMedida).collect(Collectors.toList());

	}

}
