package com.alcarrer.dto;

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
public class ItensTipoMedidaDTO implements Serializable {

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
	private MedidaDTO medida;

	@ManyToOne
	@JoinColumn(name = "marca_codigo")
	private MarcaDTO marca;

//	@Nullables
	@ManyToOne
	@JoinColumn(name = "categoria_codigo")
	private CategoriaDTO categoria;

	@ManyToOne
	@JoinColumn(name = "sub_categoria_codigo")
	private SubCategoriaDTO subCategoria;

	@OneToMany
	@JoinColumn(name = "itens_tipo_medida_codigo")
	private Set<ProdutoHasItensTipoMedidaDTO> produtoHasItensTipoMedida;
	
	public ItensTipoMedidaDTO() {

	}

	public SubCategoriaDTO getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(SubCategoriaDTO subCategoria) {
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

	public MedidaDTO getMedida() {
		return medida;
	}

	public void setMedida(MedidaDTO medida) {
		this.medida = medida;
	}

	public MarcaDTO getMarca() {
		return marca;
	}

	public void setMarca(MarcaDTO marca) {
		this.marca = marca;
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
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
