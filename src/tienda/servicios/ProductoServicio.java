package tienda.servicios;

import tienda.entidades.Producto;
import tienda.persistencias.ProductoDao;
import java.util.*;

public class ProductoServicio {
    Scanner leer = new Scanner(System.in);

    private ProductoDao productoDao;

    public ProductoServicio () {
    this.productoDao = new ProductoDao ();
    }


    public void crearProducto () throws Exception {

        try {
            System.out.println("ingrese el nombre del producto");
            String nombre = leer.next();
            System.out.println("ingrese el codigo del producto");
            int id = leer.nextInt();
            System.out.println("ingrese el precio del producto");
            Double precio = leer.nextDouble();
            System.out.println("ingrese el id del fabricante");
            int idf = leer.nextInt();

            if (nombre == null || nombre.isEmpty()) {
                throw new Exception("debe indicar el nombre");
            }
            if (precio == null) {
                throw new Exception("debe indicar el precio del proucto");
            }
            if (idf > 7) {
                throw new Exception("el codigo del fabricante no puede ser mayor a 7");
            }
            //CREO EL PRODUCTO
            Producto p = new Producto(id, nombre ,precio, idf);
            productoDao.guardarUnProducto(p);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }


    };

    public Collection<Producto> listarNombreDeProductos () throws Exception {

        try {

            Collection<Producto> productos =  productoDao.listarNombreProductos();
            if (productos.isEmpty()) {
                throw new Exception("no existe productos para listar");
            } else  {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
            return productos;

        } catch (Exception e) {
            throw e;
        }
    }
    public Collection<Producto> listarNombreYPrecioDeProductos () throws Exception {

        try {

            Collection<Producto> productos =  productoDao.listarNombrePrecioProductos();
            if (productos.isEmpty()) {
                throw new Exception("no existe productos para listar");
            } else  {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
            return productos;

        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarProductosSegunPrecio () throws Exception {

        System.out.println("ingrese los valores entre los cuales quiere buscar los productos");
        int valor1 = leer.nextInt();
        int valor2 =leer.nextInt();
        try {

            Collection<Producto> productos =  productoDao.listarProductosSegunPreco(valor1,valor2);
            if (productos.isEmpty()) {
                throw new Exception("no existe productos para listar");
            } else  {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }

            return productos;


        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> listarPorString () throws Exception {

        System.out.println("ingrese un filtro por el cual quiera buscar");
        String str = leer.next();

        try {

            Collection<Producto> productos =  productoDao.listarSegunString(str);
            if (productos.isEmpty()) {
                throw new Exception("no existe productos para listar");
            } else  {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
            return productos;

        } catch (Exception e) {
            throw e;
        }
    }

    public Producto mostrarProductoMasBarato () throws Exception {


        try {

            Producto p = productoDao.productoMasBarato();

            System.out.println(p);

            return p;


        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarNombreProducto () throws Exception {

        System.out.println("ingrese el id del producto que quiere cambiar su nombre");
        int id = leer.nextInt();
        System.out.println("ingrese el nombre antiguo");
        String nombreAntiguo = leer.next();
        System.out.println("ingrese el nombre actual");
        String nombreNuevo = leer.next();
        try {
            if(nombreAntiguo.isEmpty()) {
                throw new Exception("el nombre antiguo no puede estar vacio");
            }
            if(nombreNuevo.isEmpty()) {
                throw new Exception("el nombre antiguo no puede estar vacio");
            }


            Producto p = productoDao.buscarProductoPorId(id);

            if ( p == null) {
                throw new Exception("el producto esta vacio");

            }
            if (!p.getNombre().equalsIgnoreCase(nombreAntiguo)) {
                throw new Exception("el nombre ingresado como nombre actual" +
                        "no coincide con el id del producto ingresado");

            }
            if (p.getNombre().equalsIgnoreCase(nombreNuevo)) {
                throw new Exception("el nombre nuevo no puede ser igual a la clave antigua");
            }

        }catch (Exception e) {
            throw e;
        }
    }
}
