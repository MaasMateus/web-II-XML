package app;

import app.entities.Comanda;
import app.entities.ItemPedido;
import app.entities.Produto;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface AppServer {
	
	@WebMethod Long putComanda();

    @WebMethod String getComanda(Long idComanda);

    @WebMethod void deleteComanda(Long idComanda);

    @WebMethod Long putProduto(String nmProduto, Double vlProduto);

    @WebMethod Long postProduto(Long idProduto, String newNmProduto, Double newVlProduto);

    @WebMethod String getProduto(Long idProduto);

    @WebMethod void deleteProduto(Long idProduto);

    @WebMethod String addItemComanda(Long idComanda, Long idProduto, Integer qtd);
    
//    @WebMethod float removeItemComanda(Long idComanda, Long idProduto, Integer qtd);
//
//    @WebMethod float updateItemComanda(Long idComanda, Long idProduto, Integer qtd);
//
//    @WebMethod float listarItensComanda(Long idComanda, Long idProduto, Integer qtd);



}