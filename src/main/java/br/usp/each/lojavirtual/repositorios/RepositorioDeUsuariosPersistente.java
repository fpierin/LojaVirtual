package br.usp.each.lojavirtual.repositorios;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.usp.each.lojavirtual.modelo.repositorios.RepositorioDeUsuarios;
import br.usp.each.lojavirtual.representacoes.Usuario;

@Component
public class RepositorioDeUsuariosPersistente implements RepositorioDeUsuarios {

    private final Session session;

    public RepositorioDeUsuariosPersistente(final Session session) {
	this.session = session;
    }

    @Override
    public void adiciona(final Usuario usuario) {
	this.session.save(usuario);
    }

    @Override
    public Usuario carrega(final Usuario usuario) {
	return (Usuario) session.createCriteria(Usuario.class)
		.add(Restrictions.eq("login", usuario.getLogin()))
		.add(Restrictions.eq("senha", usuario.getSenha()))
		.uniqueResult();
    }

    @Override
    public boolean existeUsuario(final Usuario usuario) {
	final Usuario encontrado = (Usuario) session
		.createCriteria(Usuario.class)
		.add(Restrictions.eq("login", usuario.getLogin()))
		.uniqueResult();
	return encontrado != null;
    }

}
