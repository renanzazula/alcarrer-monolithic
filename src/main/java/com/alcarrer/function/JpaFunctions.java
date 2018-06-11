package com.alcarrer.function;

import com.alcarrer.function.jpa.CategoriaDTOtoCategoriaFunction;
import com.alcarrer.function.jpa.FormasDePagamentoDTOtoFormasDePagamentoFunction;
import com.alcarrer.function.jpa.FornecedorDTOtoFornecedorFunction;
import com.alcarrer.function.jpa.ItensTipoMedidaDTOtoItensTipoMedidaFunction;
import com.alcarrer.function.jpa.MarcaDTOtoMarcaFunction;
import com.alcarrer.function.jpa.MedidaDTOtoMedidaFunction;
import com.alcarrer.function.jpa.ProdutoDTOtoProdutoFunction;
import com.alcarrer.function.jpa.ProdutoHasItensTipoMedidaDTOtoprodutoHasItensTipoMedidaFunction;
import com.alcarrer.function.jpa.SubCategoriaDTOtoSubCategoriaFunction;

public class JpaFunctions {

	public JpaFunctions() {

	}

	public static final CategoriaDTOtoCategoriaFunction categoriaDTOtoCategoria = new CategoriaDTOtoCategoriaFunction();
	public static final SubCategoriaDTOtoSubCategoriaFunction subCategoriaDTOtoCategoria = new SubCategoriaDTOtoSubCategoriaFunction();
	public static final FornecedorDTOtoFornecedorFunction fornecedorDTOtoFornecedor = new FornecedorDTOtoFornecedorFunction();
	public static final MarcaDTOtoMarcaFunction marcaDTOtomarca = new MarcaDTOtoMarcaFunction();
	public static final MedidaDTOtoMedidaFunction medidaDTOtoMedida = new MedidaDTOtoMedidaFunction();
	public static final ItensTipoMedidaDTOtoItensTipoMedidaFunction itensTipoMedidaDTOtoItensTipoMedida = new ItensTipoMedidaDTOtoItensTipoMedidaFunction();
	public static final ProdutoDTOtoProdutoFunction produtoDTOtoProduto = new ProdutoDTOtoProdutoFunction();
	public static final FormasDePagamentoDTOtoFormasDePagamentoFunction formasDePagamentoDTOtoFormasDePagamento = new FormasDePagamentoDTOtoFormasDePagamentoFunction();
	public static final ProdutoHasItensTipoMedidaDTOtoprodutoHasItensTipoMedidaFunction produtoHasItensTipoMedidaDTOtoprodutoHasItensTipoMedida = new  ProdutoHasItensTipoMedidaDTOtoprodutoHasItensTipoMedidaFunction();
	
}
