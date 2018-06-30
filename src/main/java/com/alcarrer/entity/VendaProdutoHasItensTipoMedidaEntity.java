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
public class VendaProdutoHasItensTipoMedidaEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2516119080969832005L;

	@EmbeddedId
	private VendaProdutoHasItensTipoMedidaEntityPk pk;

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

	
}
