package com.alcarrer.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alcarrer.model.Categoria;
import com.alcarrer.model.Fornecedor;
import com.alcarrer.model.ItensTipoMedida;
import com.alcarrer.model.Marca;
import com.alcarrer.model.Medida;
import com.alcarrer.model.Produto;
import com.alcarrer.model.ProdutoHasItensTipoMedida;
import com.alcarrer.model.SubCategoria;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ProdutoRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private ProdutoRepository repository;

	@Test
	public void testSaveProduto() {

		String nome = "nome";
		String status = "status";
		String descricao = "Descricao";
		Double preco = 0d;
		Double precoVenda = 0d;
		Double precoCusto = 0d;
		Double precoOferta = 0d;
		Double desconto = 0d;
		Double peso = 0d;
		Integer porcentagem = 1;
		Integer porcentagemDesconto = 1;
		Date dataHoraCadastro = null;
		try {
			dataHoraCadastro = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2017-11-15 15:30:14.332");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Marca marca = new Marca("marca", "descricao");
		Fornecedor fornecedor = new Fornecedor("Fornecedor", "descricao");
		Categoria categoria = new Categoria("Categoria", "descricao");
		SubCategoria subCategoria = new SubCategoria("subCategoria", "descricao");
		Set<ProdutoHasItensTipoMedida> produtoHasItensTipoMedidaSet = new HashSet<>();

		ItensTipoMedida itensTipoMedidaX = new ItensTipoMedida();
		itensTipoMedidaX.setMarca(marca);
		itensTipoMedidaX.setCategoria(categoria);
		itensTipoMedidaX.setSubCategoria(subCategoria);
		Medida medidaX = new Medida("X", "x");

		itensTipoMedidaX.setMedida(medidaX);
		ProdutoHasItensTipoMedida produtoHasItensTipoMedidaX = new ProdutoHasItensTipoMedida();
		produtoHasItensTipoMedidaX.setFlagSite("flagSite");
		produtoHasItensTipoMedidaX.setQuantidade(10);
		produtoHasItensTipoMedidaX.setItensTipoMedida(itensTipoMedidaX);
		produtoHasItensTipoMedidaSet.add(produtoHasItensTipoMedidaX);

		ItensTipoMedida itensTipoMedidaP = new ItensTipoMedida();
		itensTipoMedidaP.setMarca(marca);
		itensTipoMedidaP.setCategoria(categoria);
		itensTipoMedidaP.setSubCategoria(subCategoria);
		itensTipoMedidaP.setMedida(new Medida("P", "p"));
		ProdutoHasItensTipoMedida produtoHasItensTipoMedidaP = new ProdutoHasItensTipoMedida();
		produtoHasItensTipoMedidaP.setFlagSite("flagSite");
		produtoHasItensTipoMedidaP.setQuantidade(10);
		produtoHasItensTipoMedidaP.setItensTipoMedida(itensTipoMedidaP);
		produtoHasItensTipoMedidaSet.add(produtoHasItensTipoMedidaP);

		ItensTipoMedida itensTipoMedidaXX = new ItensTipoMedida();
		itensTipoMedidaXX.setMarca(marca);
		itensTipoMedidaXX.setCategoria(categoria);
		itensTipoMedidaXX.setSubCategoria(subCategoria);
		itensTipoMedidaXX.setMedida(new Medida("XX", "xx"));
		ProdutoHasItensTipoMedida produtoHasItensTipoMedidaXX = new ProdutoHasItensTipoMedida();
		produtoHasItensTipoMedidaXX.setFlagSite("flagSite");
		produtoHasItensTipoMedidaXX.setQuantidade(10);
		produtoHasItensTipoMedidaXX.setItensTipoMedida(itensTipoMedidaXX);
		produtoHasItensTipoMedidaSet.add(produtoHasItensTipoMedidaXX);

		Produto obj = new Produto(nome, status, descricao, preco, precoVenda, precoCusto, precoOferta, desconto, peso,
				porcentagem, porcentagemDesconto, dataHoraCadastro, marca, fornecedor, categoria, subCategoria,
				produtoHasItensTipoMedidaSet);

		Produto objDB = entityManager.persist(obj);
//		Optional<Produto> optional = repository.findById(objDB.getCodigo());

//		optional.get().getProdutoHasItensTipoMedida()
//				.forEach(action -> System.out.println(action.getItensTipoMedida().getMedida().getDescricao()));

	}

}
