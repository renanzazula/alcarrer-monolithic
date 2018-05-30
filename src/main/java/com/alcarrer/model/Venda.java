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

@Entity(name = "venda")
public class Venda implements Serializable {

	private static final long serialVersionUID = -6612762288260227887L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Integer codigo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataHora")
	private Date dataHora;

	@Column(name = "valorTotal")
	private Double valorTotal;

	@Column(name = "status")
	private String status;

	@ManyToOne
	@JoinColumn(name = "caixa_codigo")
	private Caixa caixa;

	@ManyToOne
	@JoinColumn(name = "cliente_codigo")
	private Cliente cliente;

	@ManyToOne
	@JoinColumn(name = "formasDePagamento_codigo")
	private FormaDePagamento formaDePagamento;
	
	@OneToMany
	@JoinColumn(name = "venda_codigo")
	private Set<VendaHasProduto> vendaHasProduto;

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

	public Set<VendaHasProduto> getVendaHasProduto() {
		return vendaHasProduto;
	}

	public void setVendaHasProduto(Set<VendaHasProduto> vendaHasProduto) {
		this.vendaHasProduto = vendaHasProduto;
	} 
	
	
	
}
