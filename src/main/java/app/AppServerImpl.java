package app;

import app.entities.Comanda;
import app.entities.ItemPedido;

import javax.jws.WebService;

@WebService(endpointInterface = "app.AppServer")
public class AppServerImpl {

    public void addItemComanda(Comanda comanda, ItemPedido item) {
        comanda.addItemPedido(item);
    }


}
