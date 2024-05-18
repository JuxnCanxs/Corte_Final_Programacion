package models;
import java.util.*;
public class Venta {
    private int idVenta;
    private ArrayList<Producto> productosVendidos;
    private double totalVenta;
    private Date fechaYHora;

    public Venta(int idVenta, ArrayList<Producto> productosVendidos, double totalVenta, Date fechaYHora) {
        this.idVenta = idVenta;
        this.productosVendidos = productosVendidos;
        this.totalVenta = totalVenta;
        this.fechaYHora = fechaYHora;
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

    public void setProductosVendidos(ArrayList<Producto> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }

    public double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Date getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(Date fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public void addProduct(Producto producto, int cantidad) {
        this.productosVendidos.add(producto);
        this.totalVenta += producto.getPrecio() * cantidad;
    }

    public void calculateTotal() {
        this.totalVenta = 0;
        for (Producto producto : productosVendidos) {
            this.totalVenta += producto.getPrecio();
        }
    }
}
