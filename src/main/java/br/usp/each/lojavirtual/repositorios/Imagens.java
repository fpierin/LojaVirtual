package br.usp.each.lojavirtual.repositorios;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.jfree.io.IOUtils;

import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.ioc.Component;
import br.usp.each.lojavirtual.representacoes.Produto;

@Component
public class Imagens {

    private final File pastaImagens;

    public Imagens(final ServletContext context) {
	final String caminhoImagens = context.getRealPath("/WEB-INF/imagens");
	pastaImagens = new File(caminhoImagens);
	pastaImagens.mkdir();
    }

    public File mostra(final Produto produto) {
	return new File(pastaImagens, produto.getId() + ".jpg");
    }

    public void salva(final UploadedFile imagem, final Produto produto) {
	final File destino = new File(pastaImagens, produto.getId() + ".jpg");
	try {
	    IOUtils.getInstance().copyStreams(imagem.getFile(),
		    new FileOutputStream(destino));
	} catch (final IOException e) {
	    throw new RuntimeException("Erro ao copiar imagem", e);
	}

    }

}
