package com.alcarrer.function.jpa;

import java.util.function.Function;

import com.alcarrer.entity.ProdutoEntity;
import com.alcarrer.model.Produto;

public class ProdutoDTOtoProdutoFunction implements Function<ProdutoEntity, Produto>{

	@Override
	public Produto apply(ProdutoEntity t) {
		return null;
	}

}
