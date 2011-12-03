package br.usp.each.lojavirtual.representacoes;

public class Item {

    private Produto produto;

    private Integer quantidade;

    public Produto getProduto() {
	return this.produto;
    }

    public Integer getQuantidade() {
	return this.quantidade;
    }

    public void setProduto(final Produto produto) {
	this.produto = produto;
    }

    public void setQuantidade(final Integer quantidade) {
	this.quantidade = quantidade;
    }

}
