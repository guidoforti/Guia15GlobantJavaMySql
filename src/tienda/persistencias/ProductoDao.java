package tienda.persistencias;

import tienda.entidades.*;
import tienda.servicios.*;
import java.util.*;
public final class ProductoDao extends DAO{

    private final ProductoServicio productoServicio;

    public ProductoDao() {
        this.productoServicio = new ProductoServicio();
    }

    public void guardarUnProducto (Producto producto) throws Exception {

        try {
        if ( producto == null) {
            throw new Exception("el producto no puede estar vacio");
        }
        String sql = "INSERT INTO producto (codigo, nombre, precio , codigo_fabricante)"
                + "VALUES ('" + producto.getId() + "' , '" + producto.getNombre() +
                "' , '" + producto.getPrecio() + "' , '" + producto.getIdFabricante() + "'); ";
        insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        }
    }

    public  void modificarProducto (Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("el producto no puede estar vacio");
            }

            String sql = "UPDATE producto SET" +
                    "nombre = '" + producto.getNombre()+ "precio = '" + producto.getPrecio()
                    + "codigo_fabricante = '" + producto.getIdFabricante()
                    +"' WHERE codigo = '" + producto.getId() + "'";
            insertarModificarEliminar(sql);

        }catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarProducto ( int id) throws Exception {

        try {
        String sql = "DELETE from procuto WHERE codigo = '" + id + "'";
        insertarModificarEliminar(sql);

        } catch (Exception e) {

            throw e;
        }finally {
            desconectarBase();
        }
    }

    public Producto buscarProductoPorId (int id) throws Exception {

        try {
            String sql = "SELECT * FROM producto WHERE codigo = '" + id + "'";

            consultarBase(sql);
            Producto p = null;
            while (resultado.next()) {
                p = new Producto();
                p.setId(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setIdFabricante(resultado.getInt(4));

            }
            desconectarBase();

            return p;
        }catch (Exception e) {
            desconectarBase();
            throw e;
        }

    }

    public Collection<Producto> listarNombreProductos () throws Exception {
        try {
        String sql = "SELECT nombre FROM producto";
        consultarBase(sql);

        Producto p = null;
        Collection <Producto> productos = new ArrayList<>();

        while (resultado.next()) {
            p = new Producto();

            p.setNombre(resultado.getString(2));

            productos.add(p);
        }
        desconectarBase();
        return productos;

        }catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Producto> listarNombrePrecioProductos () throws Exception {
        try {
            String sql = "SELECT nombre , precio FROM producto";
            consultarBase(sql);

            Producto p = null;
            Collection <Producto> productos = new ArrayList<>();

            while (resultado.next()) {
                p = new Producto();

                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));

                productos.add(p);
            }
            desconectarBase();
            return productos;

        }catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    public Collection<Producto> listarProductosSegunPreco (int valor1, int valor2) throws Exception {
        try {
            String sql = "SELECT * FROM producto WHERE precio = ";
            consultarBase(sql);

            Producto p = null;
            Collection <Producto> productos = new ArrayList<>();

            while (resultado.next()) {
                p = new Producto();

                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));

                productos.add(p);
            }
            desconectarBase();
            return productos;

        }catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }
}
