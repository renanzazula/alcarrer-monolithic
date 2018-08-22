package com.alcarrer.function.jpa;

import java.util.function.Function;
import java.util.stream.Collectors;

import com.alcarrer.entity.ProdutoEntity;
import com.alcarrer.function.JpaFunctions;
import com.alcarrer.model.Produto;

public class ProdutoDTOtoProdutoFunction implements Function<ProdutoEntity, Produto> {

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
		
		if(input.getFornecedor() != null) {
			output.setFornecedor(JpaFunctions.fornecedorDTOtoFornecedor.apply(input.getFornecedor()));
		}

		if(input.getCategoria() !=  null) {
			output.setCategoria(JpaFunctions.categoriaDTOtoCategoria.apply(input.getCategoria()));
		}
		
		if(input.getSubCategoria() != null) {
			output.setSubCategoria(JpaFunctions.subCategoriaDTOtoCategoria.apply(input.getSubCategoria()));
		}
		
		if(input.getMedida() != null) {
			output.setMedida(JpaFunctions.medidaDTOtoMedida.apply(input.getMedida()));
		}
		
		if (input.getMarca() != null) {
			output.setMarca(JpaFunctions.marcaDTOtomarca.apply(input.getMarca()));
		}

		if (input.getProdutoHasItensTipoMedida() != null) {
			output.setProdutoHasItensTipoMedida(input.getProdutoHasItensTipoMedida().stream().map(JpaFunctions.produtoHasItensTipoMedidaDTOtoProdutoHasItensTipoMedida).collect(Collectors.toList()));
		}
		
		return output;
	}

}
