package br.usp.each.lojavirtual.representacoes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class Produto {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Length(min = 3)
    private String nome;

    @NotNull
    @Length(max = 40)
    private String descricao;

    @Length(min = 0)
    private Double preco;

    @Length(min = 0)
    private int quantidade;

    public Produto() {
    }

    public Produto(final Long id, final String nome, final String descricao,
	    final Double preco, final int quantidade) {
	this.id = id;
	this.nome = nome;
	this.descricao = descricao;
	this.preco = preco;
	this.quantidade = quantidade;
    }

    public String getDescricao() {
	return descricao;
    }

    public Long getId() {
	return id;
    }

    public String getNome() {
	return nome;
    }

    public Double getPreco() {
	return preco;
    }

    public int getQuantidade() {
	return quantidade;
    }

    public void setDescricao(final String descricao) {
	this.descricao = descricao;
    }

    public void setId(final Long id) {
	this.id = id;
    }

    public void setNome(final String nome) {
	this.nome = nome;
    }

    public void setPreco(final Double preco) {
	this.preco = preco;
    }

    public void setQuantidade(final int quantidade) {
	this.quantidade = quantidade;
    }

}
