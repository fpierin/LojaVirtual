package br.usp.each.lojavirtual.representacoes;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class UsuarioWeb {

    private Usuario logado;

    public String getNome() {
	return logado.getNome();
    }

    public boolean isLogado() {
	return logado != null;
    }

    public void login(final Usuario usuario) {
	this.logado = usuario;
    }

    public void logout() {
	this.logado = null;
    }

}
