package br.usp.each.lojavirtual.controladores;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.Validations;
import br.com.caelum.vraptor.view.Results;
import br.usp.each.lojavirtual.anotacoes.Restrito;
import br.usp.each.lojavirtual.modelo.repositorios.RepositorioDeProdutos;
import br.usp.each.lojavirtual.representacoes.Produto;

@Resource
public class ProdutosController {

    private final RepositorioDeProdutos repositorioDeProdutos;
    private final Result result;
    private final Validator validator;

    public ProdutosController(
	    final RepositorioDeProdutos repositorioDeProdutos,
	    final Result result, final Validator validator) {
	this.repositorioDeProdutos = repositorioDeProdutos;
	this.result = result;
	this.validator = validator;
    }

    @Post
    @Path("/produtos")
    @Restrito
    public void adiciona(final Produto produto) {
	validator.checking(new Validations() {
	    {
		that((produto.getNome() != null)
			&& (produto.getNome().length() >= 3), "produto.nome",
			"nome.obrigatorio");
		that((produto.getDescricao() != null)
			&& (produto.getDescricao().length() <= 40),
			"produto.descricao", "descricao.obrigatoria");
		that((produto.getPreco() != null) && (produto.getPreco() > 0.0),
			"produto.preco", "preco.positivo");
	    }
	});

	validator.onErrorUsePageOf(ProdutosController.class).formulario();

	repositorioDeProdutos.salva(produto);
	result.redirectTo(this).lista();
    }

    @Put
    @Path("/produtos/{produto.id}")
    @Restrito
    public void altera(final Produto produto) {
	repositorioDeProdutos.atualiza(produto);
	result.redirectTo(this).lista();
    }

    public List<Produto> busca(final String nome) {
	result.include("nome", nome);
	return repositorioDeProdutos.busca(nome);
    }

    @Get
    @Path("/produtos/busca.json")
    public void buscaJson(final String q) {
	result.use(Results.json()).withoutRoot()
		.from(repositorioDeProdutos.busca(q))
		.exclude("id", "descricao").serialize();
    }

    @Get
    @Path("/produtos/{id}")
    @Restrito
    public Produto edita(final Long id) {
	return repositorioDeProdutos.carrega(id);
    }

    @Get
    @Path("/produtos/novo")
    @Restrito
    public void formulario() {
    }

    @Get
    @Path("/produtos")
    public List<Produto> lista() {
	return repositorioDeProdutos.lista();
    };

    @Delete
    @Path("/produtos/{id}")
    @Restrito
    public void remove(final Long id) {
	final Produto produto = repositorioDeProdutos.carrega(id);
	repositorioDeProdutos.exclui(produto);
	result.redirectTo(this).lista();
    }

}
