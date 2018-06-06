package com.alcarrer.service.produto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alcarrer.function.JpaFunctions;
import com.alcarrer.model.Produto;
import com.alcarrer.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository repository;  
	
	@Override
	@Transactional
	public Produto incluir(Produto produto) {
		 
		return null;
	}

	@Override
	@Transactional
	public Produto alterar(Produto produto) {
		 
		return null;
	}

	@Override
	
	@Transactional
	public void excluir(Produto produto) {
		 

	}

	@Override
	@Transactional(readOnly = true)
	public boolean validarCodigoProduto(Produto produto) {
		 
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public Produto consultarByCodigo(Produto produto) {
		return JpaFunctions.produtoDTOtoProduto.apply(repository.findOne(produto.getCodigo()));
	}

	@Override
	
	public List<Produto> consultar() {
		return repository.findAll().stream().map(JpaFunctions.produtoDTOtoProduto).collect(Collectors.toList());
	}

}
