package com.alcarrer.repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alcarrer.model.Caixa;
import com.alcarrer.model.Cliente;
import com.alcarrer.model.FormaDePagamento;
import com.alcarrer.model.Produto;
import com.alcarrer.model.Venda;
import com.alcarrer.model.VendaHasProduto;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class VendaRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private VendaRepository repository;

	@Test
	public void testSaveVenda() throws Exception {

		Date dataHoraAbertura = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2017-11-15 15:30:14.332");
		Date dataHoraFechamento = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2017-11-15 15:30:14.332");
		Caixa caixa = new Caixa(dataHoraAbertura, dataHoraFechamento, new Double(10), new Double(5), new Double(15), "open");
		FormaDePagamento formaDePagamento = new FormaDePagamento("FormaDePagamento", "Descricao", 1);
		Cliente cliente = new Cliente();

		Venda venda = new Venda();
		Set<VendaHasProduto> vendaHasProdutoSet = new HashSet<VendaHasProduto>();
		for (int i = 0; i < 5; i++) {

			VendaHasProduto itenVenda = new VendaHasProduto();

			Produto produto = new Produto();
			produto.setCodigo(i);

			itenVenda.setProduto(produto);
			itenVenda.setValorUnitario(1d);
			itenVenda.setQuantidade(1);
			itenVenda.setVenda(venda); 
			vendaHasProdutoSet.add(itenVenda);
		}
		venda.setCaixa(caixa);
		venda.setCliente(cliente);
		venda.setValorTotal(2d);
		venda.setDataHora(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse("2017-11-15 15:30:14.332"));
		venda.setFormaDePagamento(formaDePagamento);
		venda.setVendaHasProduto(vendaHasProdutoSet);

		Venda objDB = entityManager.persist(venda);
		Optional<Venda> optional = repository.findById(objDB.getCodigo());
		
		optional.get().getVendaHasProduto().forEach(action -> System.out.println(action.getProduto().getCodigo()));
	}

}
