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

import com.alcarrer.entity.CategoriaEntity;
import com.alcarrer.entity.FornecedorEntity;
import com.alcarrer.entity.ItensTipoMedidaEntity;
import com.alcarrer.entity.MarcaEntity;
import com.alcarrer.entity.MedidaEntity;
import com.alcarrer.entity.ProdutoEntity;
import com.alcarrer.entity.ProdutoHasItensTipoMedidaEntity;
import com.alcarrer.entity.SubCategoriaEntity;
import com.alcarrer.enums.FlagSiteEnum;
import com.alcarrer.enums.StatusEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ProdutoRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;



	@Test
	public void testSaveProduto() {

		String nome = "nome";
		
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
		MarcaEntity marca = new MarcaEntity("marca", "descricao");
		FornecedorEntity fornecedor = new FornecedorEntity("Fornecedor", "descricao");
		CategoriaEntity categoria = new CategoriaEntity("Categoria", "descricao");
		SubCategoriaEntity subCategoria = new SubCategoriaEntity("subCategoria", "descricao");
		Set<ProdutoHasItensTipoMedidaEntity> produtoHasItensTipoMedidaSet = new HashSet<>();

		ItensTipoMedidaEntity itensTipoMedidaX = new ItensTipoMedidaEntity();
		itensTipoMedidaX.setMarca(marca);
		itensTipoMedidaX.setCategoria(categoria);
		itensTipoMedidaX.setSubCategoria(subCategoria);
		MedidaEntity medidaX = new MedidaEntity("X", "x");

		itensTipoMedidaX.setMedida(medidaX);
		ProdutoHasItensTipoMedidaEntity produtoHasItensTipoMedidaX = new ProdutoHasItensTipoMedidaEntity();
		
//		produtoHasItensTipoMedidaX.setQuantidade(10);
//		produtoHasItensTipoMedidaX.setItensTipoMedida(itensTipoMedidaX);
		produtoHasItensTipoMedidaSet.add(produtoHasItensTipoMedidaX);

		ItensTipoMedidaEntity itensTipoMedidaP = new ItensTipoMedidaEntity();
		itensTipoMedidaP.setMarca(marca);
		itensTipoMedidaP.setCategoria(categoria);
		itensTipoMedidaP.setSubCategoria(subCategoria);
		itensTipoMedidaP.setMedida(new MedidaEntity("P", "p"));
		ProdutoHasItensTipoMedidaEntity produtoHasItensTipoMedidaP = new ProdutoHasItensTipoMedidaEntity();
		
//		produtoHasItensTipoMedidaP.setQuantidade(10);
//		produtoHasItensTipoMedidaP.setItensTipoMedida(itensTipoMedidaP);
		produtoHasItensTipoMedidaSet.add(produtoHasItensTipoMedidaP);

		ItensTipoMedidaEntity itensTipoMedidaXX = new ItensTipoMedidaEntity();
		itensTipoMedidaXX.setMarca(marca);
		itensTipoMedidaXX.setCategoria(categoria);
		itensTipoMedidaXX.setSubCategoria(subCategoria);
		itensTipoMedidaXX.setMedida(new MedidaEntity("XX", "xx"));
		ProdutoHasItensTipoMedidaEntity produtoHasItensTipoMedidaXX = new ProdutoHasItensTipoMedidaEntity();
		
//		produtoHasItensTipoMedidaXX.setQuantidade(10);
//		produtoHasItensTipoMedidaXX.setItensTipoMedida(itensTipoMedidaXX);
		produtoHasItensTipoMedidaSet.add(produtoHasItensTipoMedidaXX);

		ProdutoEntity obj = new ProdutoEntity(nome, StatusEnum.Ativo, descricao, preco, precoVenda, precoCusto, precoOferta, desconto, peso,
				porcentagem, porcentagemDesconto, dataHoraCadastro, marca, fornecedor, categoria, subCategoria,
				produtoHasItensTipoMedidaSet);

		ProdutoEntity objDB = entityManager.persist(obj);
//		Optional<Produto> optional = repository.findById(objDB.getCodigo());

//		optional.get().getProdutoHasItensTipoMedida()
//				.forEach(action -> System.out.println(action.getItensTipoMedida().getMedida().getDescricao()));

	}

}
