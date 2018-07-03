package com.alcarrer.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "venda_has_item_produto")
public class VendaHasItemProdutoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2516119080969832005L;

	@EmbeddedId
	private VendaHasItemProdutoEntityPk pk;

	@ManyToOne
	@MapsId("vendaCodigo") // This is the name of attr in VendaProdutoHasItensTipoMedidaEntityPK class
	@JoinColumn(name = "venda_codigo")
	private VendaEntity venda;

	@ManyToOne
	@MapsId("produtoHasItensTipoMedidaCodigo")
	@JoinColumn(name = "produto_has_itens_tipo_medida_codigo")
	private ProdutoHasItensTipoMedidaEntity produtoHasItensTipoMedida;

	@Column(name = "valorUnitario")
	private Double valorUnitario;

	@Column(name = "quantidade")
	private Integer quantidade;

	public VendaHasItemProdutoEntityPk getPk() {
		return pk;
	}

	public void setPk(VendaHasItemProdutoEntityPk pk) {
		this.pk = pk;
	}

	public VendaEntity getVenda() {
		return venda;
	}

	public void setVenda(VendaEntity venda) {
		this.venda = venda;
	}

	public ProdutoHasItensTipoMedidaEntity getProdutoHasItensTipoMedida() {
		return produtoHasItensTipoMedida;
	}

	public void setProdutoHasItensTipoMedida(ProdutoHasItensTipoMedidaEntity produtoHasItensTipoMedida) {
		this.produtoHasItensTipoMedida = produtoHasItensTipoMedida;
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
