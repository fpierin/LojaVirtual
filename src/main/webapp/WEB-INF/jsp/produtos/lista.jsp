<ul class="produtos">
	<c:forEach items="${produtoList}" var="produto">
		<li>
			<div class="produto">
<!-- 			width="145" height="250"  -->
				<div class="imagem">
					<img src="<c:url value="/produtos/${produto.id}/imagem"/>" />
				</div>
				<div>
					${produto.nome}
				</div>
				<div id="preco">
					<fmt:formatNumber type="currency" value="${produto.preco}" />
				</div>				
				 
				<!-- Adicionando o produto no carrinho de compras -->
				<form action="<c:url value="/carrinho"/>" method="POST">
					<input type="hidden" name="item.produto.id" value="${produto.id}" />
					<input type="hidden" class="qtde" name="item.quantidade" value="1" />
					<button type="submit">Comprar</button>
				</form>

				<c:if test="${usuarioWeb.logado}">
					<a href="<c:url value="/produtos/${produto.id}"/>">Editar</a></td>

						<form action="<c:url value="/produtos/${produto.id}"/>"
							method="POST">
							<button class="link" name="_method" value="DELETE">Remover</button>
						</form>
				</c:if>

			</div>
		</li>
	</c:forEach>
</ul>

