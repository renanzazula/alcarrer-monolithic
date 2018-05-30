package com.alcarrer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "categoria_has_sub_categoria")
public class CategoriaHasSubCategoria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3743862143683171697L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Integer codigo;

	@ManyToOne
	@JoinColumn(name = "categoria_codigo")
	private Categoria categoria;

	@ManyToOne
	@JoinColumn(name ="sub_categoria_codigo")
	private SubCategoria subCategoria;
	
	public CategoriaHasSubCategoria() {
	 
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public SubCategoria getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(SubCategoria subCategoria) {
		this.subCategoria = subCategoria;
	}

	
	
}
