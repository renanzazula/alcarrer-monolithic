package com.alcarrer.model;

import java.io.Serializable;


public class ProdutoHasItensTipoMedida implements Serializable {

	private static final long serialVersionUID = -6612762288260227887L;

	private Integer codigo;
	private String flagSite;
	private Integer quantidade;
	private ItensTipoMedida itensTipoMedida;
	private Produto produto;
	
	public ProdutoHasItensTipoMedida() {

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

	public ItensTipoMedida getItensTipoMedida() {
		return itensTipoMedida;
	}

	public void setItensTipoMedida(ItensTipoMedida itensTipoMedida) {
		this.itensTipoMedida = itensTipoMedida;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	  

}
