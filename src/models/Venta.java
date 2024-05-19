package models;
import java.util.*;
public class Venta {
    private int idVenta;
    private ArrayList<Producto> productosVendidos;
    private double totalVenta;
    private Date fechaYHora;

    public Venta(int idVenta) {
        this.idVenta = idVenta;
        this.productosVendidos = new ArrayList<>();
        this.totalVenta = 0.0;
        this.fechaYHora = new Date();
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public ArrayList<Producto> getProductosVendidos() {
        return productosVendidos;
    }

    public void agregarProducto(Producto producto) {
        this.productosVendidos.add(producto);
        this.totalVenta += producto.getPrecio();
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public Date getFechaYHora() {
        return fechaYHora;
    }
}