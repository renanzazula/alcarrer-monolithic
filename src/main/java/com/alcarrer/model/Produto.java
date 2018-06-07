package com.alcarrer.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class Produto implements Serializable {

	private static final long serialVersionUID = -6612762288260227887L;
	private Integer codigo;
	private String barCode;
	private String nome;
	private String status;
	private String descricao;
	private Double preco;
	private Double precoVenda;
	private Double precoCusto;
	private Double precoOferta;
	private Double desconto;
	private Double peso;
	private Integer porcentagem;
	private Integer porcentagemDesconto;
	private Date dataHoraCadastro;
	private Marca marca;
	private Fornecedor fornecedor;
	private Categoria categoria;
	private SubCategoria subCategoria;

	private List<Categoria> categorias;
	private List<SubCategoria> subCategorias;
	private List<Medida> itensMedida;
	private List<Fornecedor> fornecedores;
	private List<Marca> marcas;

	public Produto() {

	}

	public Produto(String nome, String status, String descricao, Double preco, Double precoVenda, Double precoCusto,
			Double precoOferta, Double desconto, Double peso, Integer porcentagem, Integer porcentagemDesconto,
			Date dataHoraCadastro, Marca marca, Fornecedor fornecedor, Categoria categoria, SubCategoria subCategoria

			) {
		super();

		this.nome = nome;
		this.status = status;
		this.descricao = descricao;
		this.preco = preco;
		this.precoVenda = precoVenda;
		this.precoCusto = precoCusto;
		this.precoOferta = precoOferta;
		this.desconto = desconto;
		this.peso = peso;
		this.porcentagem = porcentagem;
		this.porcentagemDesconto = porcentagemDesconto;
		this.dataHoraCadastro = dataHoraCadastro;
		this.marca = marca;
		this.fornecedor = fornecedor;
		this.categoria = categoria;
		this.subCategoria = subCategoria;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(Double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public Double getPrecoOferta() {
		return precoOferta;
	}

	public void setPrecoOferta(Double precoOferta) {
		this.precoOferta = precoOferta;
	}

	public Double getDesconto() {
		return desconto;
	}

	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Integer getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(Integer porcentagem) {
		this.porcentagem = porcentagem;
	}

	public Integer getPorcentagemDesconto() {
		return porcentagemDesconto;
	}

	public void setPorcentagemDesconto(Integer porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}

	public Date getDataHoraCadastro() {
		return dataHoraCadastro;
	}

	public void setDataHoraCadastro(Date dataHoraCadastro) {
		this.dataHoraCadastro = dataHoraCadastro;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
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

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public List<Marca> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<Marca> marcas) {
		this.marcas = marcas;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public List<SubCategoria> getSubCategorias() {
		return subCategorias;
	}

	public void setSubCategorias(List<SubCategoria> subCategorias) {
		this.subCategorias = subCategorias;
	}

	public List<Medida> getItensMedida() {
		return itensMedida;
	}

	public void setItensMedida(List<Medida> itensMedida) {
		this.itensMedida = itensMedida;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

}
