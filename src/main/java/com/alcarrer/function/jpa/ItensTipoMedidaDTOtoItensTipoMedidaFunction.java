package com.alcarrer.function.jpa;

import java.util.function.Function;

import com.alcarrer.entity.ItensTipoMedidaEntity;
import com.alcarrer.model.ItensTipoMedida;

public class ItensTipoMedidaDTOtoItensTipoMedidaFunction implements Function<ItensTipoMedidaEntity, ItensTipoMedida> {

	@Override
	public ItensTipoMedida apply(ItensTipoMedidaEntity input) {
		ItensTipoMedida output = new ItensTipoMedida();
		output.setCodigo(input.getCodigo());
		output.setValor(input.getValor());
		return output;
	}

}
