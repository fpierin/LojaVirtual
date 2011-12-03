package br.usp.each.lojavirtual.repositorios;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.com.caelum.vraptor.ioc.Component;
import br.usp.each.lojavirtual.modelo.repositorios.RepositorioDeProdutos;
import br.usp.each.lojavirtual.representacoes.Produto;

@Component
public class RepositorioDeProdutosPersistente implements RepositorioDeProdutos {

    private final Session session;

    public RepositorioDeProdutosPersistente(final Session session) {
	this.session = session;
    }

    @Override
    public void atualiza(final Produto produto) {
	session.update(produto);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Produto> busca(final String nome) {
	return session.createCriteria(Produto.class)
		.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
		.list();
    }

    @Override
    public Produto carrega(final Long id) {
	return (Produto) session.get(Produto.class, id);
    }

    @Override
    public void exclui(final Produto produto) {
	session.delete(produto);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Produto> lista() {
	return session.createCriteria(Produto.class).list();
    }

    @Override
    public void recarrega(final Produto produto) {
	session.refresh(produto);
    }

    @Override
    public void salva(final Produto produto) {
	session.saveOrUpdate(produto);
    }

}
