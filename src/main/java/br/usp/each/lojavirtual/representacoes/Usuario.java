package br.usp.each.lojavirtual.representacoes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Usuario {

    @Id
    private String login;

    @NotNull
    @Column
    private String senha;

    @NotNull
    @Column
    private String nome;

    @NotNull
    @Column
    private String cpf;

    @NotNull
    @Column
    private String rg;

    @NotNull
    @Column
    private String endereco;

    @NotNull
    @Column
    private String cep;

    @NotNull
    @Column
    private String cidade;

    @NotNull
    @Column
    private String pais;

    @Column
    private boolean admin;

    public Usuario() {
    }

    public Usuario(final String login, final String senha, final String nome,
	    final String cpf, final String rg, final String endereco,
	    final String cep, final String cidade, final String pais,
	    final boolean admin) {
	super();
	this.login = login;
	this.senha = senha;
	this.nome = nome;
	this.cpf = cpf;
	this.rg = rg;
	this.endereco = endereco;
	this.cep = cep;
	this.cidade = cidade;
	this.pais = pais;
	this.admin = admin;
    }

    public String getCep() {
	return cep;
    }

    public String getCidade() {
	return cidade;
    }

    public String getCpf() {
	return cpf;
    }

    public String getEndereco() {
	return endereco;
    }

    public String getLogin() {
	return this.login;
    }

    public String getNome() {
	return this.nome;
    }

    public String getPais() {
	return pais;
    }

    public String getRg() {
	return rg;
    }

    public String getSenha() {
	return this.senha;
    }

    public boolean isAdmin() {
	return this.admin;
    }

    public void setCep(final String cep) {
	this.cep = cep;
    }

    public void setCidade(final String cidade) {
	this.cidade = cidade;
    }

    public void setCpf(final String cpf) {
	this.cpf = cpf;
    }

    public void setEndereco(final String endereco) {
	this.endereco = endereco;
    }

    public void setLogin(final String login) {
	this.login = login;
    }

    public void setNome(final String nome) {
	this.nome = nome;
    }

    public void setPais(final String pais) {
	this.pais = pais;
    }

    public void setRg(final String rg) {
	this.rg = rg;
    }

    public void setSenha(final String senha) {
	this.senha = senha;
    }

}
