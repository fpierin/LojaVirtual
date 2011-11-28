<table>
	<thead>
		<tr>
			<th>Nome</th>
			<th>Descrição</th>
			<th>Preço</th>
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
