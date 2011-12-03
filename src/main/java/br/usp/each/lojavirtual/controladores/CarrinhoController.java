package br.usp.each.lojavirtual.controladores;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.usp.each.lojavirtual.modelo.repositorios.RepositorioDeProdutos;
import br.usp.each.lojavirtual.representacoes.Carrinho;
import br.usp.each.lojavirtual.representacoes.Item;
import br.usp.each.lojavirtual.representacoes.Produto;

@Resource
public class CarrinhoController {

    private final Carrinho carrinho;
    private final RepositorioDeProdutos repositorioDeProdutos;
    private final Result result;

    public CarrinhoController(final Carrinho carrinho,
	    final RepositorioDeProdutos repositorioDeProdutos,
	    final Result result) {
	this.carrinho = carrinho;
	this.repositorioDeProdutos = repositorioDeProdutos;
	this.result = result;
    }

    @Post
    @Path("/carrinho")
    public void adiciona(final Item item) {
	final Produto produto = item.getProduto();
	repositorioDeProdutos.recarrega(produto);
	carrinho.adiciona(item);
	result.redirectTo(this).visualiza();
    }

    @Delete
    @Path("/carrinho/{indiceItem}")
    public void remove(final int indiceItem) {
	carrinho.remove(indiceItem);
	result.redirectTo(this).visualiza();
    }

    @Get
    @Path("/carrinho")
    public void visualiza() {
    }

}
