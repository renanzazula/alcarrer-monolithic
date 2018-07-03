package com.alcarrer.function.jpa;

import java.util.function.Function;

import com.alcarrer.entity.VendaEntity;
import com.alcarrer.function.JpaFunctions;
import com.alcarrer.model.Venda;

public class VendaDTOtoVendaFunction implements Function<VendaEntity, Venda> {

	@Override
	public Venda apply(VendaEntity input) {
		Venda output = new Venda();
		//
		output.setQuantidade(input.getQuantidade());
		output.setSubTotal(input.getSubTotal());
		output.setValorPendente(input.getValorPendente());
		output.setValorPago(input.getValorPago());
		output.setDesconto(input.getDesconto());
		output.setTotalApagar(input.getTotalApagar());
		output.setTroco(input.getTroco());
		output.setPagamento(input.getPagamento());
		output.setValorTotal(input.getValorTotal());
		output.setFormaDePagamento(JpaFunctions.formasDePagamentoDTOtoFormasDePagamento.apply(input.getFormaDePagamento()));
		output.setCliente(JpaFunctions.clienteDTOtocliente.apply(input.getCliente()));
		output.setCaixa(JpaFunctions.caixaDTOtoCaixa.apply(input.getCaixa()));
		
		
		
		
		return output;
	}

}
