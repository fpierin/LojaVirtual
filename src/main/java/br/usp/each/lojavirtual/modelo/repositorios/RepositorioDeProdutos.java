package br.usp.each.lojavirtual.modelo.repositorios;

import java.util.List;

import br.usp.each.lojavirtual.representacoes.Produto;

public interface RepositorioDeProdutos {

    void atualiza(Produto produto);

    List<Produto> busca(String nome);

    Produto carrega(Long id);

    void exclui(Produto produto);

    List<Produto> lista();

    void recarrega(Produto produto);

    void salva(Produto produto);

}
