/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.model.ProdProvId;
import client.model.ProductoProv;
import client.model.Proveedor;
import java.util.Date;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {

    private Client client;
    private static final String REST_URI_PROVEEDOR = "http://localhost:8090/api/v1/proveedor";
    private static final String REST_URI_PRODUCTOPROV = "http://localhost:8090/api/v1/productoprov";

    public RestClient() {
        client = ClientBuilder.newClient();
    }

    public List<Proveedor> listarProveedores() {
        return client.target(REST_URI_PROVEEDOR + "/list").request(MediaType.APPLICATION_JSON).get(new GenericType<List<Proveedor>>() {
        });
    }

    public Response saveProveedor(Proveedor proveedor) {
        return client.target(REST_URI_PROVEEDOR + "/save").request(MediaType.APPLICATION_JSON).post(Entity.entity(proveedor, MediaType.APPLICATION_JSON));
    }

    public Response updateProveedor(Proveedor proveedor, String cif) {
        return client.target(REST_URI_PROVEEDOR + "/update/" + cif).request(MediaType.APPLICATION_JSON).put(Entity.entity(proveedor, MediaType.APPLICATION_JSON));
    }

    public Response deleteProveedor(String cif) {
        return client.target(REST_URI_PROVEEDOR + "/delete/" + cif).request(MediaType.APPLICATION_JSON).delete();
    }

    public List<ProductoProv> listarProductoProv() {
        return client.target(REST_URI_PRODUCTOPROV + "/list").request(MediaType.APPLICATION_JSON).get(new GenericType<List<ProductoProv>>() {
        });
    }

    public Response saveProductoProv(ProductoProv productoProv) {
        return client.target(REST_URI_PRODUCTOPROV + "/save").request(MediaType.APPLICATION_JSON).post(Entity.entity(productoProv, MediaType.APPLICATION_JSON));
    }

    public Response updateProductoProv(ProductoProv productoProv, String cif, String cod) {
        return client.target(REST_URI_PRODUCTOPROV + "/update/" + cod + "/" + cif).request(MediaType.APPLICATION_JSON).put(Entity.entity(productoProv, MediaType.APPLICATION_JSON));
    }

    public Response deleteProductoProv(String cif, String cod) {
        return client.target(REST_URI_PRODUCTOPROV + "/delete/" + cod + "/" + cif).request(MediaType.APPLICATION_JSON).delete();
    }

    public void makeCrudProveedor() {
        System.out.println("Lista de proveedores ------------------------->");
        List<Proveedor> proveedores = this.listarProveedores();
        for (Proveedor p : proveedores) {
            System.out.println(p.toString());
        }
        System.out.println("\n");

        Proveedor proveedor = new Proveedor();
        proveedor.setCif("1232");
        proveedor.setNombre("Proveedor 4");
        proveedor.setDireccion("En algun lugar del mundo mundial");
        proveedor.setTelefono("1221321");
        proveedor.setEstado("hab");

        System.out.println("Creando proveedor --------------------------->");
        Response responseSave = this.saveProveedor(proveedor);
        System.out.println(responseSave.readEntity(String.class));
        System.out.println("\n");

        System.out.println("Actualizando proveedor --------------------------->");
        Response responseUpd = this.updateProveedor(proveedor, proveedor.getCif());
        System.out.println(responseUpd.readEntity(Proveedor.class));
        System.out.println("\n");

        System.out.println("Eliminando proveedor --------------------------->");
        Response responseDel = this.deleteProveedor(proveedor.getCif());
        System.out.println("Producto eliminado...");
        System.out.println("\n");
    }

    public void makeCrudProductoProv() {
//        System.out.println("Lista de productos por proveedor------------------------->");
//        List<ProductoProv> productoProvs = this.listarProductoProv();
//        for (ProductoProv p : productoProvs) {
//            System.out.println(p.toString());
//        }
//        System.out.println("\n");

        System.out.println("Creando producto por proveedor --------------------------->");
        ProdProvId prodProvId = new ProdProvId("P0001", "PR0003");
        ProductoProv productoProv = new ProductoProv();
        productoProv.setProdProvId(prodProvId);
        productoProv.setNombre("Producto1");
        productoProv.setCantidad(15);
        productoProv.setPrecio(2.5);
        productoProv.setFechaEnt("2011-12-12");
        productoProv.setEstado("hab");

        Response responseSave = this.saveProductoProv(productoProv);
        System.out.println(responseSave.readEntity(String.class));
        System.out.println("\n");

//        System.out.println("Actualizando producto por proveedor --------------------------->");
//        productoProv.setNombre("Producto1 editado");
//        productoProv.setCantidad(20);
//        productoProv.setPrecio(3.75);
//        Response responseUpd = this.updateProductoProv(productoProv, productoProv.getProdProvId().getCif(), productoProv.getProdProvId().getCod());
//        System.out.println(responseUpd.readEntity(ProductoProv.class));
//        System.out.println("\n");
//
//        System.out.println("Eliminando producto por proveedor --------------------------->");
//        Response responseDel = this.deleteProductoProv(productoProv.getProdProvId().getCif(), productoProv.getProdProvId().getCod());
//        System.out.println("Producto por proveedor eliminado...");
//        System.out.println("\n");
    }

    public static void main(String args[]) {
        RestClient restClient = new RestClient();
//        restClient.makeCrudProveedor();
        restClient.makeCrudProductoProv();
    }
}
