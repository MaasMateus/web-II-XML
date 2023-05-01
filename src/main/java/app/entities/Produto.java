package app.entities;

public class Produto {

    private Long id;
    private String nome;
    private Double valor;

    public Produto(Long id, String nome, Double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }


    public boolean equals(Produto prodComparar) {
        return prodComparar.getNome().equals(nome);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome);
        sb.append(" R$");
        sb.append(valor);
        return sb.toString();
    }
}
