package com.alcarrer.service.produto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alcarrer.entity.ProdutoEntity;
import com.alcarrer.function.JpaFunctions;
import com.alcarrer.model.Produto;
import com.alcarrer.repository.CategoriaRepository;
import com.alcarrer.repository.FornecedorRepository;
import com.alcarrer.repository.MarcaRepository;
import com.alcarrer.repository.ProdutoRepository;
import com.alcarrer.repository.SubCategoriaRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;  
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private SubCategoriaRepository subCategoriaRepository;
	
	@Override
	@Transactional
	public Produto incluir(Produto produto) {
		ProdutoEntity produtoDB = new ProdutoEntity();
		produtoDB.setCodigo(produto.getCodigo());
		produtoDB.setBarCode(produto.getBarCode());
		produtoDB.setNome(produto.getNome());
		produtoDB.setStatus(produto.getStatus());
		produtoDB.setDescricao(produto.getDescricao());
		produtoDB.setPreco(produto.getPreco());
		produtoDB.setPrecoVenda(produto.getPrecoVenda());
		produtoDB.setPrecoCusto(produto.getPrecoCusto());
		produtoDB.setPrecoOferta(produto.getPrecoOferta());
		produtoDB.setDesconto(produto.getDesconto());
		produtoDB.setPeso(produto.getPeso());
		produtoDB.setPorcentagem(produto.getPorcentagem());
		produtoDB.setPorcentagemDesconto(produto.getPorcentagemDesconto());
		produtoDB.setDataHoraCadastro(produto.getDataHoraCadastro());
		
		if(produto.getMarca().getCodigo() != null) {
			produtoDB.setMarca(marcaRepository.findOne(produto.getMarca().getCodigo()));
		}
		
		if(produto.getFornecedor().getCodigo() != null) {
			produtoDB.setFornecedor(fornecedorRepository.findOne(produto.getFornecedor().getCodigo()));
		}
		
		if(produto.getCategoria().getCodigo() != null) {
			produtoDB.setCategoria(categoriaRepository.findOne(produto.getCategoria().getCodigo()));
		}
		
		if(produto.getSubCategoria().getCodigo() != null) {
			produtoDB.setSubCategoria(subCategoriaRepository.findOne(produto.getSubCategoria().getCodigo()));
		}
		
		// TODO: itens medida produto 
		
		return JpaFunctions.produtoDTOtoProduto.apply(produtoRepository.saveAndFlush(produtoDB));
	}

	@Override
	@Transactional
	public Produto alterar(Produto produto) {
		ProdutoEntity produtoDB = produtoRepository.findOne(produto.getCodigo());
		produtoDB.setCodigo(produto.getCodigo());
		produtoDB.setBarCode(produto.getBarCode());
		produtoDB.setNome(produto.getNome());
		produtoDB.setStatus(produto.getStatus());
		produtoDB.setDescricao(produto.getDescricao());
		produtoDB.setPreco(produto.getPreco());
		produtoDB.setPrecoVenda(produto.getPrecoVenda());
		produtoDB.setPrecoCusto(produto.getPrecoCusto());
		produtoDB.setPrecoOferta(produto.getPrecoOferta());
		produtoDB.setDesconto(produto.getDesconto());
		produtoDB.setPeso(produto.getPeso());
		produtoDB.setPorcentagem(produto.getPorcentagem());
		produtoDB.setPorcentagemDesconto(produto.getPorcentagemDesconto());
		produtoDB.setDataHoraCadastro(produto.getDataHoraCadastro());
		
		if(produto.getMarca() != null && produto.getMarca().getCodigo() != null) {
			produtoDB.setMarca(marcaRepository.findOne(produto.getMarca().getCodigo()));
		}
		
		if(produto.getFornecedor() != null && produto.getFornecedor().getCodigo() != null) {
			produtoDB.setFornecedor(fornecedorRepository.findOne(produto.getFornecedor().getCodigo()));
		}
		
		if(produto.getCategoria() != null && produto.getCategoria().getCodigo() != null) {
			produtoDB.setCategoria(categoriaRepository.findOne(produto.getCategoria().getCodigo()));
		}
		
		if(produto.getSubCategoria() != null && produto.getSubCategoria().getCodigo() != null) {
			produtoDB.setSubCategoria(subCategoriaRepository.findOne(produto.getSubCategoria().getCodigo()));
		}
		return JpaFunctions.produtoDTOtoProduto.apply(produtoRepository.saveAndFlush(produtoDB));
	}

	@Override
	@Transactional
	public void excluir(Produto produto) {
		ProdutoEntity produtoDB = produtoRepository.findOne(produto.getCodigo());
		produtoRepository.delete(produtoDB);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean validarCodigoProduto(Produto produto) {
		 
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public Produto consultarByCodigo(Produto produto) {
		return JpaFunctions.produtoDTOtoProduto.apply(produtoRepository.findOne(produto.getCodigo()));
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Produto> consultar() {
		return produtoRepository.findAll().stream().map(JpaFunctions.produtoDTOtoProduto).collect(Collectors.toList());
	}

}
