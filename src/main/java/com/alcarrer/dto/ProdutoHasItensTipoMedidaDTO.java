package com.alcarrer.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "produto_has_itens_tipo_medida")
public class ProdutoHasItensTipoMedidaDTO implements Serializable {

	private static final long serialVersionUID = -6612762288260227887L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Integer codigo;

	@Column(name = "flagSite")
	private String flagSite;

	@Column(name = "quantidade")
	private Integer quantidade;

	@ManyToOne
	@JoinColumn(name = "itens_tipo_medida_codigo")
	private ItensTipoMedidaDTO itensTipoMedida;
	
	@ManyToOne
	@JoinColumn(name = "produto_codigo") 
	private ProdutoDTO produto;
	
	public ProdutoHasItensTipoMedidaDTO() {

	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getFlagSite() {
		return flagSite;
	}

	public void setFlagSite(String flagSite) {
		this.flagSite = flagSite;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public ItensTipoMedidaDTO getItensTipoMedida() {
		return itensTipoMedida;
	}

	public void setItensTipoMedida(ItensTipoMedidaDTO itensTipoMedida) {
		this.itensTipoMedida = itensTipoMedida;
	}

	public ProdutoDTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoDTO produto) {
		this.produto = produto;
	}

	  

}
