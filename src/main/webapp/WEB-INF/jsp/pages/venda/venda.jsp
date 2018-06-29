<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<spring:url value="/resources/jquery-1.12.4.js" var="jquery124Js" />
<script type="text/javascript" src="${jquery124Js}"></script>

<spring:url value="/resources/external/jquery/jquery.js" var="jqueryJs" />
<script type="text/javascript" src="${jqueryJs}"></script>

<spring:url value="/resources/jquery-ui.js" var="jqueryUiJs" />
<script type="text/javascript" src="${jqueryUiJs}"></script>

<spring:url value="/resources/jquery-ui.min.js" var="jqueryUiMinJs" />
<script type="text/javascript" src="${jqueryUiMinJs}"></script>
 
<spring:url value="/resources/jquery.dataTables.min.js" var="jqueryDataTablesMinJs" />
<script type="text/javascript" src="${jqueryDataTablesMinJs}"></script>

<spring:url value="/resources/jquery.maskMoney.js" var="jqueryMaskMoney" />
<script type="text/javascript" src="${jqueryMaskMoney}"></script>

<c:url var="home" value="/" scope="request" />

<style>
	.fieldset-auto-width {
		display: inline-block;
	}
</style>

<script type="text/javascript">
	$(document).ready(function(){

		$('#efetuarVenda').on( 'click', function () {  		
			$("form[name='vendaForm']").attr('action', 'finalizarVenda');
 
			var data = $('#tableVenda').DataTable().rows().data();
			for (var i=0; i < $('#tableVenda').DataTable().rows().length; i++){
				$("form[name='vendaForm']").append('<input type="hidden" value="'+data[i][0]+'" name="produtos['+i+'].itemMedida.codigo"/>');
				$("form[name='vendaForm']").append('<input type="hidden" value="'+data[i][2]+'" name="produtos['+i+'].itemMedida.valor"/>');
				$("form[name='vendaForm']").append('<input type="hidden" value="'+data[i][3]+'" name="produtos['+i+'].itemMedida.quantidade"/>');	
							
			}
			$("form[name='vendaForm']").submit();
		});		
		
	  	$.extend( true, $.fn.dataTable.defaults, {
		    "searching": false,
		    "ordering": false
		} );

	  	var table = $('#tableVenda').DataTable({
			"lengthMenu" : [ [ 10, 17, -1 ], [ 10, 17, "All" ] ],
	  		"bLengthChange": false,
	  		"bInfo" : false,
	  		"language": {
  				"decimal": ",",
            	"thousands": ".",
	  	    	"emptyTable": "No data available in table!!"
	  	    },
	  	  "footerCallback": function ( row, data, start, end, display ) {
	            var api = this.api(), data;
	 
	            // Remove the formatting to get integer data for summation
	            var intVal = function ( i ) {
	                return typeof i === 'string' ?
	                    i.replace(/[\$,]/g, '')*1 :
	                    typeof i === 'number' ?
	                        i : 0;
	            };
	 
	            // Total over all pages
	            total = api.column( 4 ).data()
	                .reduce( function (a, b) {
	                    return intVal(a) + intVal(b);
	                }, 0 );
                
	            $("#subTotal").val(total.toFixed(2));
	            $("#totalApagar").val(total.toFixed(2));
	            $("#pagamento").val(total.toFixed(2));

	            if (api.data().count() == 0) {
	            	$('#formaDePagamento option:first').prop("selected", "selected");
	            	$("#formaDePagamento").attr('disabled', true);
		            $("#valorPendente").val("0.00");
		            $("#desconto").val("0.00");
		            $("#valorPago").val("0.00");	            	
			    }else{
			    	$( "#formaDePagamento" ).attr('disabled', false); 
				}	
	 			
	            // Total over this page
	            pageTotal = api
	                .column( 4, { page: 'current'} )
	                .data()
	                .reduce( function (a, b) {
	                    return intVal(a) + intVal(b);
	                }, 0 );
	 
	            // Update footer
	            $(api.column(4).footer()).html('<label>Total Pagína: &euro; <span style="color:red;font-weight: bold;">'+pageTotal.toFixed(2)+'</span></label>');
	        }
		});
 
	  	$("#adicionarProduto").click(function(event) {
			oberProdutoByBarcode($("#barCode").val());
		});
	  	
	  	$("#barCode").blur(function(event) {
			oberProdutoByBarcode($("#barCode").val());
			 $("#barCode").val("");
		});

  		$( "#formaDePagamento" ).change(function() {
  			calcularFormasDePagamento();  	  		 
  	  	});
  		 
		function display(data) {
  			var json = "<h4>Ajax Response</h4><pre>" + JSON.stringify(data, null, 4) + "</pre>";
  			$('#feedback').html(json);
  		}

		$( "#pagamento" ).blur(function() {
			if( parseFloat($("#pagamento").val()) > parseFloat($("#totalApagar").val())){
				var TROCO = parseFloat($(this).val() - $("#totalApagar").val());
				$( "#troco" ).val(TROCO.toFixed(2));
				$("#valorPendente").val('0.00');
				$("#valorPago").val( $("#totalApagar").val() );
			}else{
				$( "#troco" ).val("0.00");
				$("#valorPago").val($("#pagamento").val());	
				var VALOR_PENDENTE = parseFloat($("#pagamento").val() - $("#totalApagar").val());
				var VALOR_PENDENTE_AUX = parseFloat(VALOR_PENDENTE * - 1);
				$("#valorPendente").val(VALOR_PENDENTE_AUX.toFixed(2));
			}	
		}); 

		function oberProdutoByBarcode(produtoBarcode){
			$.ajax({ 
				 type: "POST",
				 contentType: "application/json",
				 url: "${home}addicionarProduto",
				 data: produtoBarcode,
				 dataType: 'json',
				 timeout: 600000,
				 success: function (data) {
					
					if(data.codigo != null){
 						var botao = "<input type='button' value='remover' class='delete'/>";
						table.row.add([data.codigo, data.nome, 1, "b", data.precoVenda, 11, 22, botao]).draw(false);
						$("#id").val("");
					}else{
						alert("Produto não encontrado!");
					}   				        						 	
				 },
				 error: function (e) {},
				 done : function(e) {}
			});
		}
		
		function calcularFormasDePagamento(){
			var formaDePagamento = jQuery.parseJSON($( "#formaDePagamento" ).val());
			// zerando total
		    $("#totalApagar").val("0.00");  

			// valor líquido
		    var VTOTALLIQUIDO = parseFloat($("#subTotal").val());

		    // desconto em porcentagem
		    var DESCONTO1 = parseFloat(formaDePagamento.porcentagemDesconto);
		    if( isNaN ( DESCONTO1 ) ){
		    	DESCONTO1 = 0;
		    }

		    var PDESCONTO = parseFloat( ( VTOTALLIQUIDO * DESCONTO1 ) / 100 );
		    $("#desconto").val(PDESCONTO.toFixed(2));

		    var TOTAL = parseFloat(VTOTALLIQUIDO) - parseFloat(PDESCONTO);
		    $("#totalApagar").val(TOTAL.toFixed(2));
		    $("#pagamento").val(TOTAL.toFixed(2));

		   	$("#troco").val("0");
			$("#valorPago").val(TOTAL.toFixed(2));
		    $("#valorPendente").val("0.00");
		}
		
		$("#pagamento").maskMoney({thousands:'', decimal:'.', allowZero:true});

		$('#tableVenda tbody').on( 'click', '.delete', function () {
		    table.row( $(this).parents('tr') ).remove().draw();		
		});		
 	});
</script>

<form:form method="post" modelAttribute="vendaForm" action="abrirVenda" name="vendaForm">
	</br>
	<fieldset>
		<legend>Finalizar Venda</legend>		
		<ul class="form-style-1" >
			<li>
				<fieldset>
					<legend  style="font-weight: bold;">Dados Venda/Pagamento</legend>		
					<ul class="form-style-1" >
						<li>			
							<label> 								 
								Código:
								<form:input path="codigo" type="text" class="field-long" id="codigo" placeholder="Código" style="width: 10%"/>
								Cliente:
								<form:input path="cliente.codigo" type="text" class="field-long" id="codigo.cliente" placeholder="Cliente" style="width: 67%"/>
								<input type="button" id="abrirConsultaCliente" value="Buscar Cliente" width="35%" />
							</label>											
						</li>			
					</ul>
				</fieldset>
			</li>
			<li>
				<fieldset>
					<legend>Formas de Pagamento</legend>		
					<ul class="form-style-1">
						<li>
							<label>
								Código:
								<input type="text" style="width: 24%" id="barCode"/>
								<input type="button" id="adicionarProduto" value="+ Adicionar Produto" style="width: 70%"/>
							</label>
						</li>
						
						<li> 
							<table id="tableVenda" class="display" cellspacing="0" width="98%">
								<thead>
									<tr>
										<th>Codigo</th>
										<th>Nome</th>
										<th>Quantidade</th>
										<th>Tamanho</th>
										<th>Preço</th>						
										<th>SubTotal</th>	
										<th>total iten</th>
										<td></td>											
									</tr>
								</thead>
								<tfoot>
						            <tr>
						                <th colspan="8" style="text-align:right">Total:</th>
						            </tr>
						        </tfoot>
								<tbody>
									<c:forEach items="${vendaForm.produtos}" var="i">
										<tr>
											<td class="cod">${i.codigo}</td>
											<td class="nome">${i.nome}</td>
											<td><input id="spinnerQuantidade"/></td>
											<td><input id="tamanho"/></td>
											<td class="precoVenda">${i.precoVenda}</td>
											<td>${i.precoVenda}</td>
											<td>(${i.precoVenda * i.quantidade})</td>
											<td></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</li>	
					</ul>						
				</fieldset>
			</li>			
			<li>
				<table style="width:99%">
					<tr>
						<td width="80%">
							<label>
								<fieldset class="fieldset-auto-width" style="width: 95%">
									<legend>Formas de Pagamento</legend>		
									<ul class="form-style-1" >
							 			<li>
											<label>Formas de Pagamento
												<form:select path="formaDePagamento" cssClass="field4" cssStyle="width: 82%" multiple="false" id="formaDePagamento">
					 								<form:option value="NONE" label="Selecione"/>
					 								<c:forEach items="${vendaForm.formasDePagamento}" var="item">
					 									<c:if test="${item.codigo eq  vendaForm.formaDePagamento.codigo}">
					 										<form:option value="${item}" label="${item.nome}" selected="selected"/>
					 									</c:if>
					 									<c:if test="${item.codigo ne  vendaForm.formaDePagamento.codigo}">
					 										<form:option value="${item}" label="${item.nome}"/>
					 									</c:if>	
					 								</c:forEach>
					 						   </form:select> 									           
								        	</label>	
										</li>			
									</ul>
								</fieldset>	
							</label>
							
							<label>
								<fieldset class="fieldset-auto-width" style="width: 95%;">
									<legend>Calcular Troco</legend>		
										<ul class="form-style-1" style="padding: 0px 10px 1px 0px; text-align: right;">
								 			<li>
												<label>
													Pagamento: 
													<form:input path="pagamento" type="text" class="field-long" id="pagamento" placeholder="Pagamento" style="width: 10%"/>
													Troco:
													<form:input path="troco" type="text" class="field-long" id="troco" placeholder="Troco" style="width: 10%"/> 
												</label>
											</li>			
										</ul>
								</fieldset>
							</label>
						</td>					
						<td width="20%">
							<label>
								<fieldset class="fieldset-auto-width" style="width: 94%; height: 95%;">
									<legend>Total Venda</legend>		
									<ul class="form-style-1" style="padding: 0px 10px 1px 0px; text-align: right;">
							 			<li>
											<label>
										 		Sub Total &euro;:
										 		<form:input path="subTotal" type="text" class="field-long" id="subTotal" placeholder="Sub Total" style="width: 40%"/> 
								        	</label>	
										</li>
										<li>
											<label>
										 		Desconto %:
										 		<form:input path="desconto" type="text" class="field-long" id="desconto" placeholder="Desconto" style="width: 40%"/> 
								        	</label>	
										</li>
										<li>
											<hr align="center" width="99%" size="1" color=#a0a09f/>
										</li>
										<li>
											<label>
										 		Total a Pagar  &euro;:
										 		<form:input path="totalApagar" type="text" class="field-long" id="totalApagar" placeholder="Total a Pagar" style="width: 40%"/> 
								        	</label>	
										</li>
									</ul>
								</fieldset>
							</label>
						</td>			
					</tr>	
				</table>
			</li>
			<li>	
				<fieldset>
					<legend  style=" font-weight: bold;">Pago/Pendente</legend>		
					<ul class="form-style-1" style="padding: 0px 10px 1px 0px; text-align: right;">
			 			<li>
							<label>
								Valor Pago  &euro;: 
								<form:input path="valorPago" type="text" class="field-long" id="valorPago" placeholder="Valor Pendente" style="width: 7%"/>
								Valor Pendente &euro;:
								<form:input path="valorPendente" type="text" class="field-long" id="valorPendente" placeholder="Valor Pendente" style="width: 7%"/>
								
							</label>
						</li>
					</ul>
				</fieldset>
			</li>	
			</br>
			<li>	
				<fieldset>
					<legend></legend>		
					<ul class="form-style-1" style="padding: 0px 10px 1px 0px; text-align: right;">
						<li>
							<input type="button" id="novaVenda" value="Nova Venda" style="width: 20%" />
							<input type="button" id="efetuarVenda" value="Efetuar Venda" style="width: 20%" />
							<input type="button" id="cancelarVenda" value="Cancelar Venda" style="width: 20%" />
						</li>
					</ul>
				</fieldset>	
			</li>
		</ul>
	</fieldset>
	
	<div id="feedback"></div>
	
<script>
	$("#dialog").dialog({
		autoOpen : false,
		width : 400,
		buttons : [ {
			text : "Ok",
			click : function() {
				$(this).dialog("close");
			}
		}, {
			text : "Cancel",
			click : function() {
				$(this).dialog("close");
			}
		} ]
	});
</script>
	
</form:form>