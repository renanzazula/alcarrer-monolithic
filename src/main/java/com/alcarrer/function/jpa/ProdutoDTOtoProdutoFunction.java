package com.alcarrer.function.jpa;

import java.util.function.Function;

import com.alcarrer.entity.ProdutoEntity;
import com.alcarrer.function.JpaFunctions;
import com.alcarrer.model.Produto;

public class ProdutoDTOtoProdutoFunction implements Function<ProdutoEntity, Produto>{

	@Override
	public Produto apply(ProdutoEntity input) {
		Produto output = new Produto(); 
		output.setCodigo(input.getCodigo());
		output.setBarCode(input.getBarCode());
		output.setNome(input.getNome());
		output.setStatus(input.getStatus());
		output.setDescricao(input.getDescricao());
		output.setPreco(input.getPreco());
		output.setPrecoVenda(input.getPrecoVenda());
		output.setPrecoCusto(input.getPrecoCusto());
		output.setPrecoOferta(input.getPrecoOferta());
		output.setDesconto(input.getDesconto());
		output.setPeso(input.getPeso());
		output.setPorcentagem(input.getPorcentagem());
		output.setPorcentagemDesconto(input.getPorcentagemDesconto());
		output.setDataHoraCadastro(input.getDataHoraCadastro());
		output.setMarca(JpaFunctions.marcaDTOtomarca.apply(input.getMarca()));
		output.setFornecedor(JpaFunctions.fornecedorDTOtoFornecedor.apply(input.getFornecedor()));
		output.setCategoria(JpaFunctions.categoriaDTOtoCategoria.apply(input.getCategoria()));
		output.setSubCategoria(JpaFunctions.subCategoriaDTOtoCategoria.apply(input.getSubCategoria()));
		return output;
	}

}
