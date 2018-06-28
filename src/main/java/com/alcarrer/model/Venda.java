package com.alcarrer.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Venda implements Serializable {

	private static final long serialVersionUID = -6612762288260227887L;

	private Integer codigo;
	private Date dataHora;
	private Double valorTotal;
	private String status;
	private Caixa caixa;
	private Cliente cliente;
	private List<FormasDePagamento> formasDePagamento;
	private FormasDePagamento formaDePagamento;
	// private Set<VendaHasProduto> vendaHasProduto;

	public Venda() {

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<FormasDePagamento> getFormasDePagamento() {
		return formasDePagamento;
	}

	public void setFormasDePagamento(List<FormasDePagamento> formasDePagamento) {
		this.formasDePagamento = formasDePagamento;
	}

	public FormasDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(FormasDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	// public Set<VendaHasProduto> getVendaHasProduto() {
	// return vendaHasProduto;
	// }
	//
	// public void setVendaHasProduto(Set<VendaHasProduto> vendaHasProduto) {
	// this.vendaHasProduto = vendaHasProduto;
	// }

}
