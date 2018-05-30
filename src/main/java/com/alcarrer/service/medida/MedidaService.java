package com.alcarrer.service.medida;

import java.util.List;
import java.util.Map;

import com.alcarrer.model.Medida;
import com.alcarrer.model.Produto;

public interface MedidaService {

	Medida incluir(Medida objct);

	Medida alterar(Medida objct);

	void excluir(Medida objct);

	Map<Long, Medida> consultar();

	Medida consultarByCodigo(Medida objct);

	List<Medida> consultarByProdutoAndValor(Produto produto);

	List<Medida> consultarByCategoriaSubCategoriaMarca(Produto produto);

}
