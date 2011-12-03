package br.usp.each.lojavirtual.representacoes;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Component
@SessionScoped
public class Carrinho {

    private List<Item> itens = new ArrayList<Item>();

    private Double total = 0.0;

    public void adiciona(final Item item) {
	itens.add(item);
	total += item.getProduto().getPreco() * item.getQuantidade();
    }

    public List<Item> getItens() {
	return this.itens;
    }

    public Double getTotal() {
	return this.total;
    }

    public Integer getTotalDeItens() {
	return itens.size();
    }

    public void remove(final int indiceItem) {
	final Item removido = itens.remove(indiceItem);
	total -= removido.getProduto().getPreco() * removido.getQuantidade();
    }

    public void setItens(final List<Item> itens) {
	this.itens = itens;
    }

    public void setTotal(final Double total) {
	this.total = total;
    }

}
