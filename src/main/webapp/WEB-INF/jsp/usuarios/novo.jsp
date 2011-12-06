<form id="usuariosForm" action="<c:url value="/usuarios"/>"
	method="POST">
	<fieldset>
		<legend>Criar novo usuário</legend>
		<label for="nome">Nome:</label> <input id="nome" class="required"
			type="text" name="usuario.nome" value="${usuario.nome }" /> 
			<label
			for="cpf">CPF:</label> <input id="cpf" class="required" type="text"
			name="usuario.cpf" value="${usuario.cpf}" /> 
			<label for="rg">RG:</label>
		<input id="rg" class="required" type="text" name="usuario.rg"
			value="${usuario.rg}" /> 
			<label for="endereco">Endereco:</label> <input
			id="rg" class="required" type="text" name="usuario.endereco"
			value="${usuario.endereco}" /> <label for="cep">CEP:</label> <input
			id="cep" class="required" type="text" name="usuario.cep"
			value="${usuario.cep}" /> <label for="cidade">Cidade:</label> <input
			id="cidade" class="required" type="text" name="usuario.cidade"
			value="${usuario.cidade}" /> <label for="pais">Pais:</label> <input
			id="pais" class="required" type="text" name="usuario.pais"
			value="${usuario.pais}" /> <input id="admin" class="required"
			type="hidden" name="usuario.admin" value="0" /> <label for="login">Login:</label>
		<input id="login" class="required" type="text" name="usuario.login"
			value="${usuario.login }" /> <label for="senha">Senha:</label> <input
			id="senha" class="required" type="password" name="usuario.senha" />
		<label for="confirmacao">Confirme a senha:</label> <input
			id="confirmacao" equalTo="#senha" type="password" />
		<button type="submit">Enviar</button>
	</fieldset>
</form>


<script type="text/javascript">
	$('#usuariosForm').validate();
</script>
