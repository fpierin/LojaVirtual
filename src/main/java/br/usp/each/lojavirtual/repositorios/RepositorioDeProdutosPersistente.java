package br.usp.each.lojavirtual.repositorios;

import java.util.List;

import org.hibernate.Session;

import br.com.caelum.vraptor.ioc.Component;
import br.usp.each.lojavirtual.modelo.representacoes.RepositorioDeProdutos;
import br.usp.each.lojavirtual.representacoes.Produto;

@Component
public class RepositorioDeProdutosPersistente implements RepositorioDeProdutos {

  private final Session session;

  public RepositorioDeProdutosPersistente(final Session session) {
    this.session = session;
  }

  public void grava(final Produto produto) {
    session.saveOrUpdate(produto);
  }

  public void exclui(final Produto produto){
    session.delete(produto);
  }

  @SuppressWarnings("unchecked")
  public List<Produto> lista() {
    return (List<Produto>) session.createCriteria(Produto.class).list();
  }

}
