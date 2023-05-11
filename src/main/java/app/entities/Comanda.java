package app.entities;

import java.util.ArrayList;
import java.util.List;

public class Comanda {


	private Long id;
	private List<ItemPedido> itens = new ArrayList<>();
	private Boolean pago;



	public Comanda() {}

	public Comanda(Long id) {
		this.id = id;
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
		ItemPedido itemAtual = getItemAtual(itemPedido);

		if (itemAtual != null) {
			itemAtual.addQuantidade(itemPedido.quantidade);
		} else {
			itens.add(itemPedido);
		}
	}

	public void removeItemPedido(ItemPedido itemPedido){
		ItemPedido itemAtual = getItemAtual(itemPedido);
		if(itemAtual != null){
			if(itemPedido.quantidade >= itemAtual.quantidade){
				itens.remove(getItemAtual(itemPedido));
			}else {
				itemAtual.quantidade -= itemPedido.quantidade;
			}
		}
	}

	private ItemPedido getItemAtual(ItemPedido itemPedido){
		return  itens.stream().filter(item -> item.getProduto().equals(itemPedido.getProduto()))
				.findFirst()
				.orElse(null);
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
		string.append("----");
		string.append(" Comanda: ");
		string.append(this.id);
		string.append(" ----");
		Double vlTotal = 0.0;

		for (ItemPedido item : itens) {
			string.append("\n");
			string.append(item.getQuantidade());
			string.append("x ");
			string.append(item.getProduto().getNome());
			string.append(": R$");
			string.append(item.getValor());
			vlTotal += item.getValor();
		}
		string.append("\nTotal: R$");
		string.append(vlTotal);
		string.append("\n-------------------");
		return string.toString();
	}

}
