package tienda.servicios;

import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.persistencias.FabricanteDao;

import java.util.*;

public class FabricanteServicio {

    Scanner leer = new Scanner(System.in);
    private FabricanteDao fabricanteDao;

    public void FabricanteDao () {
        this.fabricanteDao = new FabricanteDao();
    }


    public void crearFabricante () throws Exception {
        try {
            System.out.println("ingrese el nombre del fabricante");
            String nombre = leer.next();
            System.out.println("ingrese el codigo del fabricante");
            int id = leer.nextInt();


            if (nombre == null || nombre.isEmpty()) {
                throw new Exception("debe indicar el nombre");
            }

            Fabricante f = new Fabricante(id, nombre);

            fabricanteDao.guardarFabricante(f);




        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }


}
