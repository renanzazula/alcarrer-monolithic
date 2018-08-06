package com.alcarrer.service.venda;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alcarrer.entity.ProdutoHasItensTipoMedidaEntity;
import com.alcarrer.entity.VendaEntity;
import com.alcarrer.entity.VendaHasItemProdutoEntity;
import com.alcarrer.function.JpaFunctions;
import com.alcarrer.model.Venda;
import com.alcarrer.repository.CaixaRepository;
import com.alcarrer.repository.ClienteRepository;
import com.alcarrer.repository.FormaDePagamentoRepository;
import com.alcarrer.repository.ProdutoHasItensTipoMedidaRepository;
import com.alcarrer.repository.VendaRepository;

@Service
public class VendaServiceImpl implements VendaService {

	@Autowired
	private VendaRepository vendaRepository;

	@Autowired
	private FormaDePagamentoRepository formaDePagamentoRepository;

	@Autowired
	private CaixaRepository caixaRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ProdutoHasItensTipoMedidaRepository produtoHasItensTipoMedidaRepository;

	@Override
	@Transactional(readOnly = true)
	public Venda incluir(Venda venda) {

		VendaEntity vendaDB = new VendaEntity();

		// itens medida
		Set<VendaHasItemProdutoEntity> vendaHasItemProdutoSet = new HashSet<>();
		venda.getVendaHasItemProduto().forEach(itemVenda -> {
			VendaHasItemProdutoEntity vendaHasItemProduto = new VendaHasItemProdutoEntity();

			// Found better Solution
			ProdutoHasItensTipoMedidaEntity produtoHasItensTipoMedida = produtoHasItensTipoMedidaRepository
					.getOne(getProdutoHasItensTipoMedida(
							itemVenda.getProdutoHasItensTipoMedida().getItensTipoMedida().getCodigo()));
			// Found better Solution

			vendaHasItemProduto.setQuantidade(itemVenda.getProdutoHasItensTipoMedida().getQuantidade());
			vendaHasItemProduto.setValorUnitario(itemVenda.getProdutoHasItensTipoMedida().getValorUnitario());
			vendaHasItemProduto.setProdutoHasItensTipoMedida(produtoHasItensTipoMedida);
			vendaHasItemProduto.setVenda(vendaDB);
			vendaHasItemProdutoSet.add(vendaHasItemProduto);
		});

		vendaDB.setVendaHasItemProduto(vendaHasItemProdutoSet);
		vendaDB.setQuantidade(venda.getQuantidade());
		vendaDB.setSubTotal(venda.getSubTotal());
		vendaDB.setValorPendente(venda.getValorPendente());
		vendaDB.setValorPago(venda.getValorPago());
		vendaDB.setDesconto(venda.getDesconto());
		vendaDB.setTotalApagar(venda.getTotalApagar());
		vendaDB.setTroco(venda.getTroco());
		vendaDB.setPagamento(venda.getPagamento());
		vendaDB.setValorTotal(venda.getValorTotal());
		vendaDB.setFormaDePagamento(formaDePagamentoRepository.getOne(venda.getFormaDePagamento().getCodigo()));
		vendaDB.setCliente(clienteRepository.getOne(1));
		vendaDB.setCaixa(caixaRepository.getOne(1));
		
		return JpaFunctions.vendaDTOtoVenda.apply(vendaRepository.saveAndFlush(vendaDB));
	}

	/**
	 * Remove quantidade tabela produto_has_itens_tipo_medida 
	 * 
	 * produto_has_itens_tipo_medida
	 * 
	 * @param codigo
	 */
	private void baixaNoEstoque(Integer codigo) {
		
		
		produtoHasItensTipoMedidaRepository.saveAndFlush(null);
	}
	
	private Integer getProdutoHasItensTipoMedida(Integer codigo) {
		List<ProdutoHasItensTipoMedidaEntity> listProdutoHasItensTipoMedida = produtoHasItensTipoMedidaRepository
				.findByItensTipoMedidaCodigo(codigo);
		return listProdutoHasItensTipoMedida.get(0).getCodigo();
	}

	@Override
	public Venda alterar(Venda venda) {
		VendaEntity vendaDB = vendaRepository.findOne(venda.getCodigo());

		// itens mideida

		// status; Definicao o que sera status...

		vendaDB.setQuantidade(venda.getQuantidade());
		vendaDB.setSubTotal(venda.getSubTotal());
		vendaDB.setValorPendente(venda.getValorPendente());
		vendaDB.setValorPago(venda.getValorPago());
		vendaDB.setDesconto(venda.getDesconto());
		vendaDB.setTotalApagar(venda.getTotalApagar());
		vendaDB.setTroco(venda.getTroco());
		vendaDB.setPagamento(venda.getPagamento());
		vendaDB.setValorTotal(venda.getValorTotal());
		vendaDB.setFormaDePagamento(formaDePagamentoRepository.getOne(venda.getFormaDePagamento().getCodigo()));
		vendaDB.setCliente(clienteRepository.getOne(venda.getCliente().getCodigo()));
		vendaDB.setCaixa(caixaRepository.getOne(venda.getCaixa().getCodigo()));
		return JpaFunctions.vendaDTOtoVenda.apply(vendaRepository.saveAndFlush(vendaDB));

	}

	@Override
	public void excluir(Venda venda) {
		VendaEntity vendaDB = vendaRepository.findOne(venda.getCodigo());
		vendaRepository.delete(vendaDB);
	}

	@Override
	public Venda consultarByCodigo(Venda venda) {
		return JpaFunctions.vendaDTOtoVenda.apply(vendaRepository.getOne(venda.getCodigo()));
	}

	@Override
	public List<Venda> consultar() {
		return vendaRepository.findAll().stream().map(JpaFunctions.vendaDTOtoVenda).collect(Collectors.toList());
	}

	@Override
	public long gerarCodigoVenda() {
		return 0;
	}
}
