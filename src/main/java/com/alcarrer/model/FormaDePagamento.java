package com.alcarrer.model;

import java.io.Serializable;

public class FormaDePagamento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer codigo;
	private String nome;
	private String descricao;
	private int porcentagemDesconto;

	public FormaDePagamento() {
		super();
	}

	public FormaDePagamento(String nome, String descricao, int porcentagemDesconto) {
		this.nome = nome;
		this.descricao = descricao;
		this.porcentagemDesconto = porcentagemDesconto;
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

	public int getPorcentagemDesconto() {
		return porcentagemDesconto;
	}

	public void setPorcentagemDesconto(int porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
