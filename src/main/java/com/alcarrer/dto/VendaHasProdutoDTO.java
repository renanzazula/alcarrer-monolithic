package com.alcarrer.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "venda_has_produto")
public class VendaHasProdutoDTO implements Serializable {

	private static final long serialVersionUID = -6612762288260227887L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Integer codigo;
	
	@ManyToOne
	@JoinColumn(name = "venda_codigo")
	private VendaDTO venda;
	
	@ManyToOne
	@JoinColumn(name = "produto_codigo")
	private ProdutoDTO produto;

  	@Column(name = "valorUnitario")
	private Double valorUnitario;
	
	@Column(name = "quantidade")
	private Integer quantidade;

	public VendaHasProdutoDTO() {
		 
	}

	public VendaDTO getVenda() {
		return venda;
	}

	public void setVenda(VendaDTO venda) {
		this.venda = venda;
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
