package br.usp.each.lojavirtual.modelo.representacoes;

import java.util.List;

import br.usp.each.lojavirtual.representacoes.Produto;

public interface RepositorioDeProdutos {
  
  void exclui(Produto produto);
  void grava (Produto produto);
  List<Produto> lista();
  
}
