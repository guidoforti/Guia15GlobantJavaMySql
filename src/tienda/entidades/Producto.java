package tienda.entidades;

public class Producto {

    private Integer id;
    private String nombre;

    private Double precio;


    private int idFabricante;

    public Producto() {

    }

    public Producto(Integer id, String nombre, Double precio, int idFabricante) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;

        this.idFabricante= idFabricante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }



    public int getIdFabricante() {
        return idFabricante;
    }

    public void setIdFabricante(int idFabricante) {
        this.idFabricante = idFabricante;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", idFabricante=" + idFabricante +
                '}';
    }
}
