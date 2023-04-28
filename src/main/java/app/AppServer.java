package app;

import app.entities.Comanda;
import app.entities.ItemPedido;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface AppServer {
	
	
    @WebMethod void addItemComanda(Comanda comanda, ItemPedido item);
    
//    @WebMethod float removeItemComanda(Long idComanda, Long idProduto, Integer qtd);
//
//    @WebMethod float updateItemComanda(Long idComanda, Long idProduto, Integer qtd);
//
//    @WebMethod float listarItensComanda(Long idComanda, Long idProduto, Integer qtd);



}