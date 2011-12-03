package br.usp.each.lojavirtual.modelo.repositorios;

import br.usp.each.lojavirtual.representacoes.Usuario;

public interface RepositorioDeUsuarios {

    void adiciona(Usuario usuario);

    Usuario carrega(Usuario usuario);

    boolean existeUsuario(Usuario usuario);

}
