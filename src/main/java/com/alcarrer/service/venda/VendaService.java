package com.alcarrer.service.venda;

import java.util.List;

import com.alcarrer.model.Venda;

public interface VendaService {
	boolean incluir(Venda venda);

	void alterar(Venda venda);

	boolean excluir(Venda venda);

	Venda consultarByCodigo(Venda venda);

	List<Venda> consultar();

	long gerarCodigoVenda();
}
