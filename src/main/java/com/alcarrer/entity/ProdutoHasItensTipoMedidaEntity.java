package com.alcarrer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "produto_has_itens_tipo_medida")
public class ProdutoHasItensTipoMedidaEntity implements Serializable {

	private static final long serialVersionUID = -6612762288260227887L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Integer codigo;

	@Column(name = "flagSite")
	private String flagSite;

	@Column(name = "quantidade")
	private Integer quantidade;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "itens_tipo_medida_codigo")
	private ItensTipoMedidaEntity itensTipoMedida;
	
	@ManyToOne
	@JoinColumn(name = "produto_codigo") 
	private ProdutoEntity produto;
	
	public ProdutoHasItensTipoMedidaEntity() {

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

	public ItensTipoMedidaEntity getItensTipoMedida() {
		return itensTipoMedida;
	}

	public void setItensTipoMedida(ItensTipoMedidaEntity itensTipoMedida) {
		this.itensTipoMedida = itensTipoMedida;
	}

	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	  

}
