package com.alcarrer.entity;

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
public class VendaEntity implements Serializable {

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
	private CaixaEntity caixa;

	@ManyToOne
	@JoinColumn(name = "cliente_codigo")
	private ClienteEntity cliente;

	@ManyToOne
	@JoinColumn(name = "formasDePagamento_codigo")
	private FormaDePagamentoEntity formaDePagamento;
	
	@OneToMany
	@JoinColumn(name = "venda_codigo")
	private Set<VendaHasProdutoEntity> vendaHasProduto;

	public VendaEntity() {
	 
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

	public CaixaEntity getCaixa() {
		return caixa;
	}

	public void setCaixa(CaixaEntity caixa) {
		this.caixa = caixa;
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public FormaDePagamentoEntity getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(FormaDePagamentoEntity formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public Set<VendaHasProdutoEntity> getVendaHasProduto() {
		return vendaHasProduto;
	}

	public void setVendaHasProduto(Set<VendaHasProdutoEntity> vendaHasProduto) {
		this.vendaHasProduto = vendaHasProduto;
	} 
	
	
	
}
