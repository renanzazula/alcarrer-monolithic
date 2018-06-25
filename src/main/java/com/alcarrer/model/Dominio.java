package com.alcarrer.model;

import java.io.Serializable;

public class Dominio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4933949406995695753L;

	private Integer codigo;
	private String nome;
	private String descricao;

	public Dominio() {

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
}
