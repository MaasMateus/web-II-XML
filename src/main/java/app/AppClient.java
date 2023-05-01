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

        app.putComanda();
        app.putComanda();
        app.putComanda();

        app.putProduto("Torre de Chopp", 30.00);
        app.putProduto("Batata frita", 35.00);
        app.putProduto("Água sem gás 350ml", 6.50);

        app.addItemComanda(1L, 1L, 2);
        app.addItemComanda(1L, 2L, 1);

        app.addItemComanda(2L, 2L, 2);
        app.addItemComanda(2L, 3L, 1);
        app.addItemComanda(3L, 1L, 2);

        System.out.println(app.getComanda(1L));
        System.out.println(app.getComanda(2L));
        System.out.println(app.getComanda(3L));

        //Teste excluindo comanda
        app.deleteComanda(3L);
        System.out.println(app.getComanda(3L));

        //Teste alterando produto
        app.postProduto(3L, "Água sem gás 500ml", 12.0);
        System.out.println(app.getComanda(2L));
        System.out.println(app.getProduto(3L));

        //Teste excluindo produto
        app.deleteProduto(3L);
        System.out.println(app.getComanda(2L));
        System.out.println(app.getProduto(3L));
//        System.out.println("Subtracao (5-1): " + app.subtracao(5,1));
//        System.out.println("Multiplicacao (5*1): " + app.multiplicacao(5,1));
//        System.out.println("Divisao (5/1): " + app.divisao(5,1));

    }
}