<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<spring:url value="/resources/jquery-3.3.1.js" var="jquery331Js" />
<script type="text/javascript" src="${jquery331Js}"></script>
	  
<spring:url value="/resources/jquery.dataTables.min.js" var="jqueryDataTablesMinJs" />
<script type="text/javascript" src="${jqueryDataTablesMinJs}"></script>

<style>
	td.details-control {
	    background: url('resources/images/details_open.png') no-repeat center center;
	    cursor: pointer;
	}
	
	tr.shown td.details-control {
	    background: url('resources/images/details_close.png') no-repeat center center;
	}
</style>

<script type="text/javascript">
	$(document).ready(function() {
		 
		var table = $('#tableConsulta').DataTable();
		
	    // Add event listener for opening and closing details
	    $('#tableConsulta tbody').on('click', 'td.details-control', function () {
	        var tr = $(this).closest('tr');
	        var row = table.row( tr );
	 
	        if ( row.child.isShown() ) {
	            // This row is already open - close it
	            row.child.hide();
	            tr.removeClass('shown');
	        }
	        else {
	            // Open this row
	            row.child( format(row.data()) ).show();
	            tr.addClass('shown');
	        }
	    } );
		
// 		$('#tableConsulta tbody').on('click', 'tr', function() {
// 			$(this).toggleClass('selected');
// 			$("#codigo").val($(this).closest('tr').children('td.cod').text());
// 			$("form[name='produtoForm']").submit();
// 		});
		
		/* Formatting function for row details - modify as you need */
		function format ( d ) {
			
			var codigo = '{"codigo":'+ d[1] +'}';
			var lines = "";
			$.ajax({
  				type : "POST",
  				contentType : "application/json",
  				url : "${home}ajaxConsultarItensMedidaByProdutoCodigo",
  				data : JSON.stringify(jQuery.parseJSON(codigo)),
  				dataType : 'json',
  				timeout : 100000,
  				success : function(data) {
  					
  					$.each(data, function(key, value) {
  						lines = lines + '<tr>' + '<td>' + key + '-'+ value +'</td>'+ '</tr>';  					      
  					});
  				},
  				error : function(e) {
  	  				alert("Erro" + e);
  				},
  				done : function(e) {
					// Chama itens medida por categoria	
					
   				}
  			});
			
		    // `d` is the original data object for the row
		    var table = '<table cellpadding="13" cellspacing="0" border="0" style="padding-left:50px;">'+
		    	'<thead>'  + 
			    	'<tr>' +
			            '<td>Full name:</td>'+
			        '</tr>'+
		    	'</thead>' +
		    	'<tbody>'  + 
					lines +
	    		'</tbody>' +
		    '</table>';
		    console.log(table);
		    return table;
		}
	});
</script>
<form:form method="post" modelAttribute="produtoForm" action="abrirAlterarProduto" name="produtoForm">
	<form:hidden path="codigo" id="codigo"/>
	<br>
		<fieldset>
			<legend>Gerenciar Produto</legend>
			<ul class="form-style-1">
				<li>
					<c:if test="${not empty mensagem}">
						<div class="ui-widget">
							<div class="ui-state-highlight ui-corner-all" style="margin-top: 20px; padding: 0 .7em;">
								<p>
									<span class="ui-icon ui-icon-info" style="float: left; margin-right: .3em;"></span> <strong>Hey!</strong>
									${mensagem} 
								</p>
							</div>
						</div>
					</c:if>
					<br>
				 	<table id="tableConsulta" class="display" style="width:100%" >
						<thead>
							<tr>
							 	<th></th>
								<th>C�digo</th>
								<th>Nome</th>
								<th>Descri��o</th>
								<th>Porcentagem</th>
								<th>Pre�o Custo</th>
								<th>Preco Venda</th>
								<th>Desconto</th>
								<th>Pre�o Oferta</th>
								<th>QTD Em Estoque</th>
								<th>Marca</th>
								<th>Categor�a</th>
								<th>Subcategor�a</th>
								<th>Fornecedor</th>
							</tr>
						</thead>				
						<tbody>
							<c:forEach items="${list}" var="i">
								<tr>
									<td class="details-control"></td>				
									<td class="cod">${i.codigo}</td>					
									<td>${i.nome}</td>					 
									<td>${i.descricao}</td>					 
									<td>${i.porcentagem}%</td>									
									<td>${i.precoCusto}</td>		
									<td>${i.precoVenda}</td>					 
									<td>${i.desconto}</td>			 
									<td>${i.precoOferta}</td>					 
									<td>{i.quantidade}</td>					 
									<td>${i.marca.nome}</td>					 
									<td>${i.categoria.nome}</td>
									<td>${i.subCategoria.nome}</td>					 
									<td>${i.fornecedor.nome}</td>					
								</tr>
							</c:forEach>	
						</tbody>
					</table>
				</li>
			</ul>
		</fieldset>	
	<br>
</form:form>