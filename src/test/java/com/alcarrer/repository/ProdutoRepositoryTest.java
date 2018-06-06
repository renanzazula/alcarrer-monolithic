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

import com.alcarrer.dto.CategoriaDTO;
import com.alcarrer.dto.FornecedorDTO;
import com.alcarrer.dto.ItensTipoMedidaDTO;
import com.alcarrer.dto.MarcaDTO;
import com.alcarrer.dto.MedidaDTO;
import com.alcarrer.dto.ProdutoDTO;
import com.alcarrer.dto.ProdutoHasItensTipoMedidaDTO;
import com.alcarrer.dto.SubCategoriaDTO;

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
		MarcaDTO marca = new MarcaDTO("marca", "descricao");
		FornecedorDTO fornecedor = new FornecedorDTO("Fornecedor", "descricao");
		CategoriaDTO categoria = new CategoriaDTO("Categoria", "descricao");
		SubCategoriaDTO subCategoria = new SubCategoriaDTO("subCategoria", "descricao");
		Set<ProdutoHasItensTipoMedidaDTO> produtoHasItensTipoMedidaSet = new HashSet<>();

		ItensTipoMedidaDTO itensTipoMedidaX = new ItensTipoMedidaDTO();
		itensTipoMedidaX.setMarca(marca);
		itensTipoMedidaX.setCategoria(categoria);
		itensTipoMedidaX.setSubCategoria(subCategoria);
		MedidaDTO medidaX = new MedidaDTO("X", "x");

		itensTipoMedidaX.setMedida(medidaX);
		ProdutoHasItensTipoMedidaDTO produtoHasItensTipoMedidaX = new ProdutoHasItensTipoMedidaDTO();
		produtoHasItensTipoMedidaX.setFlagSite("flagSite");
		produtoHasItensTipoMedidaX.setQuantidade(10);
		produtoHasItensTipoMedidaX.setItensTipoMedida(itensTipoMedidaX);
		produtoHasItensTipoMedidaSet.add(produtoHasItensTipoMedidaX);

		ItensTipoMedidaDTO itensTipoMedidaP = new ItensTipoMedidaDTO();
		itensTipoMedidaP.setMarca(marca);
		itensTipoMedidaP.setCategoria(categoria);
		itensTipoMedidaP.setSubCategoria(subCategoria);
		itensTipoMedidaP.setMedida(new MedidaDTO("P", "p"));
		ProdutoHasItensTipoMedidaDTO produtoHasItensTipoMedidaP = new ProdutoHasItensTipoMedidaDTO();
		produtoHasItensTipoMedidaP.setFlagSite("flagSite");
		produtoHasItensTipoMedidaP.setQuantidade(10);
		produtoHasItensTipoMedidaP.setItensTipoMedida(itensTipoMedidaP);
		produtoHasItensTipoMedidaSet.add(produtoHasItensTipoMedidaP);

		ItensTipoMedidaDTO itensTipoMedidaXX = new ItensTipoMedidaDTO();
		itensTipoMedidaXX.setMarca(marca);
		itensTipoMedidaXX.setCategoria(categoria);
		itensTipoMedidaXX.setSubCategoria(subCategoria);
		itensTipoMedidaXX.setMedida(new MedidaDTO("XX", "xx"));
		ProdutoHasItensTipoMedidaDTO produtoHasItensTipoMedidaXX = new ProdutoHasItensTipoMedidaDTO();
		produtoHasItensTipoMedidaXX.setFlagSite("flagSite");
		produtoHasItensTipoMedidaXX.setQuantidade(10);
		produtoHasItensTipoMedidaXX.setItensTipoMedida(itensTipoMedidaXX);
		produtoHasItensTipoMedidaSet.add(produtoHasItensTipoMedidaXX);

		ProdutoDTO obj = new ProdutoDTO(nome, status, descricao, preco, precoVenda, precoCusto, precoOferta, desconto, peso,
				porcentagem, porcentagemDesconto, dataHoraCadastro, marca, fornecedor, categoria, subCategoria,
				produtoHasItensTipoMedidaSet);

		ProdutoDTO objDB = entityManager.persist(obj);
//		Optional<Produto> optional = repository.findById(objDB.getCodigo());

//		optional.get().getProdutoHasItensTipoMedida()
//				.forEach(action -> System.out.println(action.getItensTipoMedida().getMedida().getDescricao()));

	}

}
