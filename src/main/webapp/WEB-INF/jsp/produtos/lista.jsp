<table>
	<thead>
		<tr>
			<th>Nome</th>
			<th>Descri��o</th>
			<th>Pre�o</th>
		</tr>
	</thead>
	<tbody>
		<c:foreach items="${produtoList}" var="produto">
			<td>${produto.nome}</td>
			<td>${produto.descricao}</td>
			<td>${produto.preco}</td>					
		</c:foreach>
	</tbody>
</table>
