package com.alcarrer.function.jpa;

import java.util.function.Function;

import com.alcarrer.dto.MarcaDTO;
import com.alcarrer.model.Marca;

public class MarcaDTOtoMarcaFunction implements Function<MarcaDTO, Marca> {

	@Override
	public Marca apply(MarcaDTO t) {
		return null;
	}

}
