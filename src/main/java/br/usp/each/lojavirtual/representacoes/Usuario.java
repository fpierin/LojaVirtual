package br.usp.each.lojavirtual.representacoes;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

    @Id
    private String login;

    private String senha;

    private String nome;

    public Usuario() {
    }

    public Usuario(final String login, final String senha, final String nome) {
	this.login = login;
	this.senha = senha;
	this.nome = nome;
    }

    public String getLogin() {
	return this.login;
    }

    public String getNome() {
	return this.nome;
    }

    public String getSenha() {
	return this.senha;
    }

    public void setLogin(final String login) {
	this.login = login;
    }

    public void setNome(final String nome) {
	this.nome = nome;
    }

    public void setSenha(final String senha) {
	this.senha = senha;
    }

}
