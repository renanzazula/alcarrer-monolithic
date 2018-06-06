package com.alcarrer.function.jpa;

import java.util.function.Function;

import com.alcarrer.dto.ProdutoDTO;
import com.alcarrer.model.Produto;

public class ProdutoDTOtoProdutoFunction implements Function<ProdutoDTO, Produto>{

	@Override
	public Produto apply(ProdutoDTO t) {
		return null;
	}

}
