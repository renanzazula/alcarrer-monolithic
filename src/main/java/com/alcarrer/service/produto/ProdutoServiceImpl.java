package com.alcarrer.service.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		return repository.findOne(produto.getCodigo());
	}

	@Override
	
	public List<Produto> consultar() {
		return repository.findAll();
	}

}
