package com.alcarrer.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Venda implements Serializable {

	private static final long serialVersionUID = -6612762288260227887L;

	private Integer codigo;
	private Date dataHora;
	private Double valorTotal;
	private String status;
	private Caixa caixa;
	private Cliente cliente;
	private FormasDePagamento formaDePagamento;
	private List<FormasDePagamento> formasDePagamento;
	private List<Produto> produtos;
	
	private long quantidade;
	private BigDecimal subTotal;
	private BigDecimal valorPendente;
	private BigDecimal valorPago;
	private BigDecimal desconto;
	private BigDecimal totalApagar;
	private BigDecimal troco;
	private BigDecimal pagamento;
	
	// private Set<VendaHasProduto> vendaHasProduto;

	public Venda() {

	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<FormasDePagamento> getFormasDePagamento() {
		return formasDePagamento;
	}

	public void setFormasDePagamento(List<FormasDePagamento> formasDePagamento) {
		this.formasDePagamento = formasDePagamento;
	}

	public FormasDePagamento getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(FormasDePagamento formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(long quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getValorPendente() {
		return valorPendente;
	}

	public void setValorPendente(BigDecimal valorPendente) {
		this.valorPendente = valorPendente;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public BigDecimal getDesconto() {
		return desconto;
	}

	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}

	public BigDecimal getTotalApagar() {
		return totalApagar;
	}

	public void setTotalApagar(BigDecimal totalApagar) {
		this.totalApagar = totalApagar;
	}

	public BigDecimal getTroco() {
		return troco;
	}

	public void setTroco(BigDecimal troco) {
		this.troco = troco;
	}

	public BigDecimal getPagamento() {
		return pagamento;
	}

	public void setPagamento(BigDecimal pagamento) {
		this.pagamento = pagamento;
	}

}
