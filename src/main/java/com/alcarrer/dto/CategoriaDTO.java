package com.alcarrer.dto;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.Transient;

@Entity(name = "categoria")
public class CategoriaDTO implements Serializable {

	private static final long serialVersionUID = -6612762288260227887L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Integer codigo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable( name = "categoria_has_sub_categoria", joinColumns = {
		@JoinColumn(name = "categoria_codigo",     nullable = false, updatable = false, referencedColumnName="codigo" ) }, 
		inverseJoinColumns = {
		@JoinColumn(name = "sub_categoria_codigo", nullable = false, updatable = false) })
	private Set<SubCategoriaDTO> subCategoriasSet;

	@Transient
	private List<SubCategoriaDTO> subCategorias; 
	
	public CategoriaDTO() {

	}

	public CategoriaDTO(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<SubCategoriaDTO> getSubCategoriasSet() {
		return subCategoriasSet;
	}

	public void setSubCategoriasSet(Set<SubCategoriaDTO> subCategoriasSet) {
		this.subCategoriasSet = subCategoriasSet;
	}

	public List<SubCategoriaDTO> getSubCategorias() {
		return subCategorias;
	}

	public void setSubCategorias(List<SubCategoriaDTO> subCategorias) {
		this.subCategorias = subCategorias;
	}
 

}
