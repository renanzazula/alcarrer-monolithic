package com.alcarrer.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity(name = "produto")
public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = -6612762288260227887L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "codigo", updatable = false, nullable = false)
	private Integer codigo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "status")
	private String status;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "preco")
	private Double preco;

	@Column(name = "precoVenda")
	private Double precoVenda;

	@Column(name = "precoCusto")
	private Double precoCusto;

	@Column(name = "precoOferta")
	private Double precoOferta;

	@Column(name = "desconto")
	private Double desconto;

	@Column(name = "peso")
	private Double peso;

	@Column(name = "porcentagem")
	private Integer porcentagem;

	@Column(name = "porcentagemDesconto")
	private Integer porcentagemDesconto;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dataHoraCadastro")
	private Date dataHoraCadastro;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "marca_codigo")
	private MarcaDTO marca;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fornecedor_codigo")
	private FornecedorDTO fornecedor;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoria_codigo")
	private CategoriaDTO categoria;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "sub_categoria_codigo")
	private SubCategoriaDTO subCategoria;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "produto_codigo")
	private Set<ProdutoHasItensTipoMedidaDTO> produtoHasItensTipoMedida;

	@Transient
	private List<FornecedorDTO> fornecedores;

	@Transient
	private List<MarcaDTO> marcas;

	public List<FornecedorDTO> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<FornecedorDTO> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public List<MarcaDTO> getMarcas() {
		return marcas;
	}

	public void setMarcas(List<MarcaDTO> marcas) {
		this.marcas = marcas;
	}

	public List<CategoriaDTO> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaDTO> categorias) {
		this.categorias = categorias;
	}

	public List<SubCategoriaDTO> getSubCategorias() {
		return subCategorias;
	}

	public void setSubCategorias(List<SubCategoriaDTO> subCategorias) {
		this.subCategorias = subCategorias;
	}

	public List<MedidaDTO> getItensMedida() {
		return itensMedida;
	}

	public void setItensMedida(List<MedidaDTO> itensMedida) {
		this.itensMedida = itensMedida;
	}

	@Transient
	private List<CategoriaDTO> categorias;

	@Transient
	private List<SubCategoriaDTO> subCategorias;

	@Transient
	private List<MedidaDTO> itensMedida;

	public ProdutoDTO() {

	}

	public ProdutoDTO(String nome, String status, String descricao, Double preco, Double precoVenda, Double precoCusto,
			Double precoOferta, Double desconto, Double peso, Integer porcentagem, Integer porcentagemDesconto,
			Date dataHoraCadastro, MarcaDTO marca, FornecedorDTO fornecedor, CategoriaDTO categoria, SubCategoriaDTO subCategoria,
			Set<ProdutoHasItensTipoMedidaDTO> produtoHasItensTipoMedida) {
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
		this.produtoHasItensTipoMedida = produtoHasItensTipoMedida;
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

	public MarcaDTO getMarca() {
		return marca;
	}

	public void setMarca(MarcaDTO marca) {
		this.marca = marca;
	}

	public FornecedorDTO getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(FornecedorDTO fornecedor) {
		this.fornecedor = fornecedor;
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public SubCategoriaDTO getSubCategoria() {
		return subCategoria;
	}

	public void setSubCategoria(SubCategoriaDTO subCategoria) {
		this.subCategoria = subCategoria;
	}

	public Set<ProdutoHasItensTipoMedidaDTO> getProdutoHasItensTipoMedida() {
		return produtoHasItensTipoMedida;
	}

	public void setProdutoHasItensTipoMedida(Set<ProdutoHasItensTipoMedidaDTO> produtoHasItensTipoMedida) {
		this.produtoHasItensTipoMedida = produtoHasItensTipoMedida;
	}

}
