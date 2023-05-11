package app;

import app.entities.Comanda;
import app.entities.ItemPedido;
import app.entities.Produto;

import javax.jws.WebService;
import java.util.HashMap;

@WebService(endpointInterface = "app.AppServer")
public class AppServerImpl {

    HashMap<Long, Comanda> comandas = new HashMap<>();
    HashMap<Long, Produto> produtos = new HashMap<>();

    public Long putComanda() {
        Long idComanda = Long.valueOf(comandas.size() + 1);
        comandas.put(idComanda, new Comanda(idComanda));
        return idComanda;
    }

    public String getComanda(Long idComanda) {
        if (comandas.containsKey(idComanda)) {
            return comandas.get(idComanda).toString();
        }
        return "Comanda não encontrada!";
    }

    public void deleteComanda(Long idComanda) {
        if (comandas.containsKey(idComanda)) {
            comandas.remove(idComanda);
        }
    }

    public Long putProduto(String nmProduto, Double vlProduto) {
        Long idProduto = Long.valueOf(produtos.size() + 1);
        produtos.put(idProduto, new Produto(idProduto, nmProduto, vlProduto));
        return  idProduto;
    }

    public Long postProduto(Long idProduto, String newNmProduto, Double newVlProduto) {
        if (produtos.containsKey(idProduto)) {
            Produto produto =  produtos.get(idProduto);
            produto.setNome(newNmProduto);
            produto.setValor(newVlProduto);
            return idProduto;
        }
        return -1L;
    }

    public String getProduto(Long idProduto) {
        if (produtos.containsKey(idProduto)) {
            return produtos.get(idProduto).toString();
        }
        return "Produto não encontrado!";
    }

    public void deleteProduto(Long idProduto) {
        if (produtos.containsKey(idProduto)) {
            produtos.remove(idProduto);
        }
    }

    public String addItemComanda(Long idComanda, Long idProduto, Integer qtd) {
        if (comandas.containsKey(idComanda)) {
            Comanda comanda = comandas.get(idComanda);
            if (produtos.containsKey(idProduto)) {
                Produto produto = produtos.get(idProduto);
                comanda.addItemPedido(new ItemPedido(produto, qtd));
                return "Item adicionado com sucesso!";
            } else {
                return "Produto não encontrado!";
            }
        } else {
            return "Comanda não encontrada";
        }
    }

    public String removeItemComanda(Long idComanda, Long idProduto, Integer qtd){
        if (comandas.containsKey(idComanda)) {
            Comanda comanda = comandas.get(idComanda);
            if (produtos.containsKey(idProduto)) {
                Produto produto = produtos.get(idProduto);
                comanda.removeItemPedido(new ItemPedido(produto, qtd));
                return "Item removido com sucesso!";
            } else {
                return "Produto não encontrado!";
            }
        } else {
            return "Comanda não encontrada";
        }
    }

}
