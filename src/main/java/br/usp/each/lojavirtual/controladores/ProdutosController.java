package br.usp.each.lojavirtual.controladores;

import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.usp.each.lojavirtual.modelo.representacoes.RepositorioDeProdutos;
import br.usp.each.lojavirtual.representacoes.Produto;

@Resource
public class ProdutosController {
  
  private final RepositorioDeProdutos repositorioDeProdutos;

  public ProdutosController(final RepositorioDeProdutos repositorioDeProdutos) {
    this.repositorioDeProdutos = repositorioDeProdutos;
  }

  public List<Produto> lista() {
    return repositorioDeProdutos.lista();
  }
  
}
