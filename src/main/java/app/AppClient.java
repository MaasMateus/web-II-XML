package app;

import app.entities.Comanda;
import app.entities.ItemPedido;
import app.entities.Produto;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

class AppClient {

    public static void main(String args[]) throws Exception {
        URL url = new URL("http://127.0.0.1:9876/app?wsdl");
        QName qname = new QName("http://app/","AppServerImplService");
        Service ws = Service.create(url, qname);
        AppServer app = ws.getPort(AppServer.class);

        Comanda comanda = new Comanda();

        Produto chopp = new Produto("Torre de Chopp", 30.00);
        Produto batata = new Produto("Batata frita", 35.00);

        comanda.addItemPedido(new ItemPedido(chopp, 3));
        comanda.addItemPedido(new ItemPedido(batata, 1));
        comanda.addItemPedido(new ItemPedido(chopp, 2));


        System.out.println(comanda);
//        System.out.println("Subtracao (5-1): " + app.subtracao(5,1));
//        System.out.println("Multiplicacao (5*1): " + app.multiplicacao(5,1));
//        System.out.println("Divisao (5/1): " + app.divisao(5,1));

    }
}