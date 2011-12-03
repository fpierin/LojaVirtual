<form action="
	<c:url value="/produtos/${produto.id }"/>" method="POST">
	<fieldset>
		<legend>Editar Produto</legend>
		<label for="nome">Nome:</label> <input id="nome" type="text"
			name="produto.nome" value="${produto.nome }" /> <label
			for="descricao">Descrição:</label>
		<textarea id="descricao" name="produto.descricao">${produto.descricao }</textarea>
		<label for="preco">Preço:</label> <input id="preco" type="text"
			name="produto.preco" value="${produto.preco }" />
		<button type="submit" name="_method" value="PUT">Enviar</button>
	</fieldset>
</form>
