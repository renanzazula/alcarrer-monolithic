package com.alcarrer.repository;

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

import com.alcarrer.entity.CaixaEntity;
import com.alcarrer.entity.ClienteEntity;
import com.alcarrer.entity.FormaDePagamentoEntity;
import com.alcarrer.entity.ProdutoEntity;
import com.alcarrer.entity.VendaEntity;
import com.alcarrer.entity.VendaHasProdutoEntity;

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
		CaixaEntity caixa = new CaixaEntity(dataHoraAbertura, dataHoraFechamento, new Double(10), new Double(5), new Double(15), "open");
		FormaDePagamentoEntity formaDePagamento = new FormaDePagamentoEntity("FormaDePagamento", "Descricao", 1);
		ClienteEntity cliente = new ClienteEntity();

		VendaEntity venda = new VendaEntity();
		Set<VendaHasProdutoEntity> vendaHasProdutoSet = new HashSet<VendaHasProdutoEntity>();
		for (int i = 0; i < 5; i++) {

			VendaHasProdutoEntity itenVenda = new VendaHasProdutoEntity();

			ProdutoEntity produto = new ProdutoEntity();
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

		VendaEntity objDB = entityManager.persist(venda);
//		Optional<Venda> optional = repository.findById(objDB.getCodigo());
		
//		optional.get().getVendaHasProduto().forEach(action -> System.out.println(action.getProduto().getCodigo()));
	}

}
