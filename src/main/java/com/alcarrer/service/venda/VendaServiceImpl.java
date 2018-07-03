package com.alcarrer.service.venda;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alcarrer.entity.ProdutoHasItensTipoMedidaEntity;
import com.alcarrer.entity.VendaEntity;
import com.alcarrer.entity.VendaHasItemProdutoEntity;
import com.alcarrer.function.JpaFunctions;
import com.alcarrer.model.Venda;
import com.alcarrer.repository.CaixaRepository;
import com.alcarrer.repository.ClienteRepository;
import com.alcarrer.repository.FormaDePagamentoRepository;
import com.alcarrer.repository.ItensTipoMedidaRepository;
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
	private ItensTipoMedidaRepository itensTipoMedidaRepository; 
	
	@Override
	public Venda incluir(Venda venda) {
			
		VendaEntity vendaDB = new VendaEntity();

		//	itens medida
		Set<VendaHasItemProdutoEntity> vendaHasItemProdutoSet = new HashSet<>();
		venda.getVendaHasItemProduto().forEach(itemVenda -> {
			VendaHasItemProdutoEntity vendaHasItemProduto = new VendaHasItemProdutoEntity();  
			ProdutoHasItensTipoMedidaEntity  produtoHasItensTipoMedida = new ProdutoHasItensTipoMedidaEntity();
			produtoHasItensTipoMedida.setCodigo(itemVenda.getProdutoHasItensTipoMedida().getCodigo()); // call repository
			produtoHasItensTipoMedida.setQuantidade(itemVenda.getProdutoHasItensTipoMedida().getQuantidade());
			produtoHasItensTipoMedida.setValorUnitario(itemVenda.getValorUnitario());
			produtoHasItensTipoMedida.setItensTipoMedida(itensTipoMedidaRepository.getOne(itemVenda.getProdutoHasItensTipoMedida().getItensTipoMedida().getCodigo()));
			vendaHasItemProduto.setProdutoHasItensTipoMedida(produtoHasItensTipoMedida);
			vendaHasItemProdutoSet.add(vendaHasItemProduto);
		});
		
		vendaDB.setVendaProdutoHasItensTipoMedida(vendaHasItemProdutoSet);
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

	@Override
	public Venda alterar(Venda venda) {
		VendaEntity vendaDB = vendaRepository.findOne(venda.getCodigo());
		
		//	itens mideida
		
		//	status; Definicao o que sera status...
		
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
