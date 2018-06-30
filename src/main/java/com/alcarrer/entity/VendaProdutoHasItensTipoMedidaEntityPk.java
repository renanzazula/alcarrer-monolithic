package com.alcarrer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class VendaProdutoHasItensTipoMedidaEntityPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 780144937113604414L;

	@Column(name = "venda_codigo")
	private Integer vendaCodigo;

	@Column(name = "produto_has_itens_tipo_medida_codigo")
	private Integer produtoHasItensTipoMedidaCodigo;

	public Integer getVendaCodigo() {
		return vendaCodigo;
	}

	public void setVendaCodigo(Integer vendaCodigo) {
		this.vendaCodigo = vendaCodigo;
	}

	public Integer getProdutoHasItensTipoMedidaCodigo() {
		return produtoHasItensTipoMedidaCodigo;
	}

	public void setProdutoHasItensTipoMedidaCodigo(Integer produtoHasItensTipoMedidaCodigo) {
		this.produtoHasItensTipoMedidaCodigo = produtoHasItensTipoMedidaCodigo;
	}

}
