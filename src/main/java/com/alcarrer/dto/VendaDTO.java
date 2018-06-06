package com.alcarrer.dto;

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
public class VendaDTO implements Serializable {

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
	private CaixaDTO caixa;

	@ManyToOne
	@JoinColumn(name = "cliente_codigo")
	private ClienteDTO cliente;

	@ManyToOne
	@JoinColumn(name = "formasDePagamento_codigo")
	private FormaDePagamentoDTO formaDePagamento;
	
	@OneToMany
	@JoinColumn(name = "venda_codigo")
	private Set<VendaHasProdutoDTO> vendaHasProduto;

	public VendaDTO() {
	 
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

	public CaixaDTO getCaixa() {
		return caixa;
	}

	public void setCaixa(CaixaDTO caixa) {
		this.caixa = caixa;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public FormaDePagamentoDTO getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(FormaDePagamentoDTO formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public Set<VendaHasProdutoDTO> getVendaHasProduto() {
		return vendaHasProduto;
	}

	public void setVendaHasProduto(Set<VendaHasProdutoDTO> vendaHasProduto) {
		this.vendaHasProduto = vendaHasProduto;
	} 
	
	
	
}
