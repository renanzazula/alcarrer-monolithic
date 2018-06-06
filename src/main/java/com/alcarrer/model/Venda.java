package com.alcarrer.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class Venda implements Serializable {

	private static final long serialVersionUID = -6612762288260227887L;

	private Integer codigo;
	private Date dataHora;
	private Double valorTotal;
	private String status;
	private Caixa caixa;
	private Cliente cliente;
	private FormaDePagamento formaDePagamento;
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

	public FormaDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(FormaDePagamento formaDePagamento) {
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
