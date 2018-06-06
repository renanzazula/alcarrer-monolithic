package com.alcarrer.function.jpa;

import java.util.function.Function;

import com.alcarrer.dto.FornecedorDTO;
import com.alcarrer.model.Fornecedor;

public class FornecedorDTOtoFornecedorFunction implements Function<FornecedorDTO, Fornecedor> {

	@Override
	public Fornecedor apply(FornecedorDTO t) {
		return null;
	}

}
