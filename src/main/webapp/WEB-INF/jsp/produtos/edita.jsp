<form action="
	<c:url value="/produtos/${produto.id}"/>" method="POST">
	<fieldset>
		<legend>Editar Produto</legend>
		<img src="<c:url value="/produtos/${produto.id}/imagem"/>" width="145" height="250"/>
		<label for="nome">Nome:</label> <input id="nome" type="text"
			name="produto.nome" value="${produto.nome}" /> <label
			for="descricao">Descrição:</label>
		<textarea id="descricao" name="produto.descricao">${produto.descricao}</textarea>
		<label for="preco">Preço:</label> <input id="preco" type="text"
			name="produto.preco" value="${produto.preco }" />
		<label for="quantidade">Qtde. estoque:</label> <input id="quantidade" type="number"
			name="produto.quantidade" value="${produto.quantidade}" />			
		<button type="submit" name="_method" value="PUT">Enviar</button>
	</fieldset>
</form>
<br>
<form action="<c:url value="/produtos/${produto.id}/imagem"/>"
	method="POST" enctype="multipart/form-data">
	<fieldset>
		<legend>Upload de Imagem</legend>
		<input type="file" name="imagem" />
		<button type="submit">Enviar</button>
	</fieldset>
</form>

