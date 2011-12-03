package br.usp.each.lojavirtual.controladores;

import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.validator.ValidationMessage;
import br.usp.each.lojavirtual.modelo.repositorios.RepositorioDeUsuarios;
import br.usp.each.lojavirtual.representacoes.Usuario;
import br.usp.each.lojavirtual.representacoes.UsuarioWeb;

@Resource
public class UsuariosController {

    private final RepositorioDeUsuarios repositorioDeUsuarios;
    private final Result result;
    private final Validator validator;
    private final UsuarioWeb usuarioWeb;

    public UsuariosController(
	    final RepositorioDeUsuarios repositorioDeUsuarios,
	    final Result result, final Validator validator,
	    final UsuarioWeb usuarioWeb) {
	this.repositorioDeUsuarios = repositorioDeUsuarios;
	this.result = result;
	this.validator = validator;
	this.usuarioWeb = usuarioWeb;
    }

    @Post
    @Path("/usuarios")
    public void adiciona(final Usuario usuario) {
	if (repositorioDeUsuarios.existeUsuario(usuario)) {
	    validator.add(new ValidationMessage("Login já existe",
		    "usuario.login"));
	}
	validator.onErrorUsePageOf(UsuariosController.class).novo();

	repositorioDeUsuarios.adiciona(usuario);
	result.redirectTo(ProdutosController.class).lista();
    }

    @Post
    @Path("/login")
    public void login(final Usuario usuario) {
	final Usuario carregado = repositorioDeUsuarios.carrega(usuario);
	if (carregado == null) {
	    validator.add(new ValidationMessage("Login e/ou senha inválidos",
		    "usuario.login"));
	}
	validator.onErrorUsePageOf(UsuariosController.class).loginForm();
	usuarioWeb.login(carregado);
	result.redirectTo(ProdutosController.class).lista();
    }

    @Get
    @Path("/login")
    public void loginForm() {
    }

    @Path("/logout")
    public void logout() {
	usuarioWeb.logout();
	result.redirectTo(ProdutosController.class).lista();
    }

    private void novo() {
    }

}
