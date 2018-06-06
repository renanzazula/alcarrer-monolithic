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

import com.alcarrer.dto.CaixaDTO;
import com.alcarrer.dto.ClienteDTO;
import com.alcarrer.dto.FormaDePagamentoDTO;
import com.alcarrer.dto.ProdutoDTO;
import com.alcarrer.dto.VendaDTO;
import com.alcarrer.dto.VendaHasProdutoDTO;

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
		CaixaDTO caixa = new CaixaDTO(dataHoraAbertura, dataHoraFechamento, new Double(10), new Double(5), new Double(15), "open");
		FormaDePagamentoDTO formaDePagamento = new FormaDePagamentoDTO("FormaDePagamento", "Descricao", 1);
		ClienteDTO cliente = new ClienteDTO();

		VendaDTO venda = new VendaDTO();
		Set<VendaHasProdutoDTO> vendaHasProdutoSet = new HashSet<VendaHasProdutoDTO>();
		for (int i = 0; i < 5; i++) {

			VendaHasProdutoDTO itenVenda = new VendaHasProdutoDTO();

			ProdutoDTO produto = new ProdutoDTO();
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

		VendaDTO objDB = entityManager.persist(venda);
//		Optional<Venda> optional = repository.findById(objDB.getCodigo());
		
//		optional.get().getVendaHasProduto().forEach(action -> System.out.println(action.getProduto().getCodigo()));
	}

}
