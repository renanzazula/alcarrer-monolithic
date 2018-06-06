package com.alcarrer.dto;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity(name = "medida")
public class MedidaDTO implements Serializable {

	private static final long serialVersionUID = -6612762288260227887L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo")
	private Integer codigo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "medida_codigo")
	private Set<ItensTipoMedidaDTO> itensTipoMedida;

	public MedidaDTO() {

	}

	public MedidaDTO(String nome, String descricao) {
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

	public Set<ItensTipoMedidaDTO> getItensTipoMedida() {
		return itensTipoMedida;
	}

	public void setItensTipoMedida(Set<ItensTipoMedidaDTO> itensTipoMedida) {
		this.itensTipoMedida = itensTipoMedida;
	}

}
