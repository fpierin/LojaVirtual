package br.usp.each.lojavirtual.interceptadores;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.caelum.vraptor.resource.ResourceMethod;
import br.usp.each.lojavirtual.anotacoes.Restrito;
import br.usp.each.lojavirtual.controladores.UsuariosController;
import br.usp.each.lojavirtual.representacoes.UsuarioWeb;

@Intercepts
public class AutorizacaoInterceptor implements Interceptor {

    private final Result result;
    private final UsuarioWeb usuario;

    public AutorizacaoInterceptor(final UsuarioWeb usuario, final Result result) {
	this.usuario = usuario;
	this.result = result;
    }

    @Override
    public boolean accepts(final ResourceMethod resourceMethod) {
	return !usuario.isLogado()
		&& resourceMethod.containsAnnotation(Restrito.class);
    }

    @Override
    public void intercept(final InterceptorStack interceptorStack,
	    final ResourceMethod resourceMethod, final Object object)
	    throws InterceptionException {
	result.redirectTo(UsuariosController.class).loginForm();
    }

}
