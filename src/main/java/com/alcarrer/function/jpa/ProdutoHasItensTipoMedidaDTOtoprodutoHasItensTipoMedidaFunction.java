package com.alcarrer.function.jpa;

import java.util.function.Function;

import com.alcarrer.entity.ProdutoHasItensTipoMedidaEntity;
import com.alcarrer.function.JpaFunctions;
import com.alcarrer.model.ProdutoHasItensTipoMedida;

public class ProdutoHasItensTipoMedidaDTOtoprodutoHasItensTipoMedidaFunction
		implements Function<ProdutoHasItensTipoMedidaEntity, ProdutoHasItensTipoMedida> {

	@Override
	public ProdutoHasItensTipoMedida apply(ProdutoHasItensTipoMedidaEntity input) {
		ProdutoHasItensTipoMedida output = new ProdutoHasItensTipoMedida();
		output.setCodigo(input.getCodigo());
		output.setFlagSite(input.getFlagSite());
		if (input.getItensTipoMedida() != null) {
			output.setItensTipoMedida(JpaFunctions.itensTipoMedidaDTOtoItensTipoMedida.apply(input.getItensTipoMedida()));
		}
		output.setQuantidade(input.getQuantidade());
		return output;
	}

}
