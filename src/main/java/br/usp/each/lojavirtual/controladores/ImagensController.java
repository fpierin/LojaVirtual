package br.usp.each.lojavirtual.controladores;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.startsWith;

import java.io.File;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.validator.Validations;
import br.usp.each.lojavirtual.repositorios.Imagens;
import br.usp.each.lojavirtual.representacoes.Produto;

@Resource
public class ImagensController {

    private final Validator validator;
    private final Imagens imagens;
    private final Result result;

    public ImagensController(final Validator validator, final Imagens imagens,
	    final Result result) {
	this.validator = validator;
	this.imagens = imagens;
	this.result = result;
    }

    @Get
    @Path("/produtos/{produto.id}/imagem")
    public File download(final Produto produto) {
	return imagens.mostra(produto);
    }

    @Post
    @Path("/produtos/{produto.id}/imagem")
    public void upload(final Produto produto, final UploadedFile imagem) {
	validator.checking(new Validations() {
	    {
		if (that(imagem, is(notNullValue()), "imagem", "imagem.nula")) {
		    that(imagem.getContentType(), startsWith("image"),
			    "imagem", "nao.eh.imagem");
		}
	    }
	});

	validator.onErrorRedirectTo(ProdutosController.class).edita(
		produto.getId());
	imagens.salva(imagem, produto);
	result.redirectTo(ProdutosController.class).edita(produto.getId());

    }

}
