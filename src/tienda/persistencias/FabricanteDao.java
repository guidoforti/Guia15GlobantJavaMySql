package tienda.persistencias;

import tienda.entidades.*;
import tienda.servicios.*;
import java.util.*;
public final class FabricanteDao  extends  DAO {

    private final FabricanteServicio fabricanteServicio;


    public FabricanteDao() {
        this.fabricanteServicio = new FabricanteServicio();
    }


    public void guardarFabricante(Fabricante fabricante) throws Exception {

        try {
            if (fabricante == null) {
                throw new Exception("el fabricante no debe estar vacio");

            }

            String sql = "INSERT INTO fabricante (codigo, nombre) " + "VALUES ( '" + fabricante.getId() + "' , '"
                    + fabricante.getNombre() + "' ) ; ";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarFabricante(Fabricante fabricante) throws Exception {

        try {
            if (fabricante == null) {
                throw new Exception("el fabricante no debe estar vacio");
            }
            String sql = "UPDATE fabricante SET" +
                    "nombre = '" + fabricante.getNombre() + "' WHERE codigo = '" + fabricante.getId() + "'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarFabricantePorCodigo(int id) throws Exception {

        try {

            String sql = "DELET FROM fabricante Where codigo = '" + id + "'";

            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public void eliminarFabricantePorNombre(String nombre) throws Exception {

        try {

            String sql = "DELET FROM fabricante Where nombre = '" + nombre + "'";

            insertarModificarEliminar(sql);

        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }

    public Fabricante buscarFabricantePorCodigo(int id) throws Exception {

        try {

            String sql = "SELECT * FROM  fabricante " + " WHERE codigo = ' " + id + "'";
            consultarBase(sql);
            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setId(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }


    }


    public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {

        try {

            String sql = "SELECT * FROM  fabricante " + " WHERE nombre = ' " + nombre + "'";
            consultarBase(sql);
            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setId(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
            }
            desconectarBase();
            return fabricante;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }


    }


    public Collection<Fabricante> listarFabricantes () throws Exception {

    try {
        String sql = "SELECT * FROM fabricante";

        consultarBase(sql);

        Fabricante fabricante = null;
        Collection<Fabricante> fabricantes = new ArrayList <>();
        while (resultado.next()) {
            fabricante = new Fabricante();
            fabricante.setId(resultado.getInt(1));
            fabricante.setNombre(resultado.getString(2));
            fabricantes.add(fabricante);
        }
        desconectarBase();
        return fabricantes;
    }catch (Exception e) {
        e.printStackTrace();
        desconectarBase();
        throw new Exception("error en sistema");
    }


    }
}
