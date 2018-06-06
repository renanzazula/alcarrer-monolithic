package com.alcarrer.function.jpa;

import java.util.function.Function;

import com.alcarrer.entity.MedidaEntity;
import com.alcarrer.model.Medida;

public class MedidaDTOtoMedidaFunction implements Function<MedidaEntity, Medida> {

	@Override
	public Medida apply(MedidaEntity input) {
		Medida output = new Medida();
		output.setCodigo(input.getCodigo());
		output.setNome(input.getNome());
		output.setDescricao(input.getDescricao());
		return output;
	}

}
