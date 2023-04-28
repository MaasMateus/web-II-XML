package app.entities;

public class ItemPedido {

    public Produto produto;
    public Integer quantidade;

    public ItemPedido(Produto produto, Integer novaQuantidade) {
        this.produto = produto;
        this.quantidade = novaQuantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

//    public void setQuantidade(Integer novaQuantidade) {
//        this.quantidade = novaQuantidade;
//    }


    public Double getValor() {
        return produto.getValor() * this.quantidade;
    }

    public void addQuantidade(Integer novaQuantidade) {
        this.quantidade = this.getQuantidade() + novaQuantidade;
    }
}
