package com.alcarrer.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "itens_tipo_medida")
public class ItensTipoMedida implements Serializable {

	private static final long serialVersionUID = -6612762288260227887L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Integer codigo;

	@Column(name = "valor")
	private String valor;

//	@Nullable
	@ManyToOne
	@JoinColumn(name = "medida_codigo")
	private Medida medida;

	@ManyToOne
	@JoinColumn(name = "marca_codigo")
	private Marca marca;

//	@Nullables
	@ManyToOne
	@JoinColumn(name = "categoria_codigo")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name = "sub_categoria_codigo")
	private SubCategoria subCategoria;

	@OneToMany
	@JoinColumn(name = "itens_tipo_medida_codigo")
	private Set<ProdutoHasItensTipoMedida> produtoHasItensTipoMedida;
	
	public ItensTipoMedida() {

	}

	public SubCategoria getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Medida getMedida() {
		return medida;
	}

	public void setMedida(Medida medida) {
		this.medida = medida;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

//	public Set<ProdutoHasItensTipoMedida> getProdutoHasItensTipoMedida() {
//		return produtoHasItensTipoMedida;
//	}
//
//	public void setProdutoHasItensTipoMedida(Set<ProdutoHasItensTipoMedida> produtoHasItensTipoMedida) {
//		this.produtoHasItensTipoMedida = produtoHasItensTipoMedida;
//	}

	
}
