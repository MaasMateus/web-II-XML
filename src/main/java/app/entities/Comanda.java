package app.entities;

import java.util.ArrayList;
import java.util.List;

public class Comanda {


	private Long id;
	private List<ItemPedido> itens = new ArrayList<>();
	private Boolean pago;

	public Comanda() {
		id = 12L;
		pago = Boolean.FALSE;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public void addItemPedido(ItemPedido itemPedido) {


		 ItemPedido itemAtual = itens.stream().filter(item -> item.getProduto().equals(itemPedido.getProduto()))
				 .findFirst()
				 .orElse(null);

		if (itemAtual != null) {
			itemAtual.addQuantidade(itemPedido.quantidade);
		} else {
			itens.add(itemPedido);
		}
	}

	public Double getValorTotal() {

		Double acumulador = 0.0;

		for(ItemPedido item:itens) {
			acumulador += item.getValor();
		}
		return acumulador;
	}


	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();

		string.append("Comanda: ");
		string.append(this.id);

		for (ItemPedido item : itens) {
			string.append("\n");
			string.append(item.getProduto().getNome() + " ");
			string.append(item.getValor());
		}

		return string.toString();
	}

}
