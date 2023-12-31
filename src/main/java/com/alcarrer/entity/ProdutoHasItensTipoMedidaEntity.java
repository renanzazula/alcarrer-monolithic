package com.alcarrer.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity(name = "produto_has_itens_tipo_medida")
public class ProdutoHasItensTipoMedidaEntity implements Serializable {

	private static final long serialVersionUID = -6612762288260227887L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Integer codigo;

	@Column(name = "quantidade")
	private Integer quantidade;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "itens_tipo_medida_codigo", updatable = false)
	private ItensTipoMedidaEntity itensTipoMedida;
	
	@ManyToOne
	@JoinColumn(name = "produto_codigo")
	private ProdutoEntity produto;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "produto_has_itens_tipo_medida_has_dominio", 
        joinColumns = { @JoinColumn(name = "produto_has_itens_tipo_medida_codigo") }, 
        inverseJoinColumns = { @JoinColumn(name = "dominio_codigo") }
    )
    private Set<DominioEntity> dominios;
	
	public ProdutoHasItensTipoMedidaEntity() {

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public ProdutoEntity getProduto() {
		return produto;
	}

	public void setProduto(ProdutoEntity produto) {
		this.produto = produto;
	}

	public ItensTipoMedidaEntity getItensTipoMedida() {
		return itensTipoMedida;
	}

	public void setItensTipoMedida(ItensTipoMedidaEntity itensTipoMedida) {
		this.itensTipoMedida = itensTipoMedida;
	}

 	public Set<DominioEntity> getDominios() {
		return dominios;
	}

	public void setDominios(Set<DominioEntity> dominios) {
		this.dominios = dominios;
	}

	
	
}
