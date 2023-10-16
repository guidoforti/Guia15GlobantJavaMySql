package tienda;
import tienda.entidades.*;
import tienda.persistencias.*;
import tienda.servicios.*;

public class MainTienda {
    public static void main(String[] args) throws Exception {

        FabricanteServicio fService = new FabricanteServicio();
        ProductoServicio pService = new ProductoServicio();

        try {
            fService.crearFabricante();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erro en sistema por " + e.getMessage());
        }

        try {
           pService.crearProducto();

       } catch (Exception e) {
           e.printStackTrace();
           System.out.println("erro en sistema por " + e.getMessage());
       }

        try {
            pService.listarNombreDeProductos();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erro en sistema por " + e.getMessage());
        }

        try {
            pService.listarNombreYPrecioDeProductos();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erro en sistema por " + e.getMessage());
        }

        try {
            pService.listarProductosSegunPrecio();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erro en sistema por " + e.getMessage());
        }

        try {
            pService.listarProductosSegunPrecio();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erro en sistema por " + e.getMessage());
        }

        try {
            pService.listarPorString();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erro en sistema por " + e.getMessage());
        }

        try {
            pService.mostrarProductoMasBarato();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erro en sistema por " + e.getMessage());
        }

        try {
            pService.modificarNombreProducto();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("erro en sistema por " + e.getMessage());
        }
    }
}
