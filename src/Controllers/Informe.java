package Controllers;

import models.Venta;

import models.Producto;

import java.util.ArrayList;

public class Informe {
    public void generarInformeVentas(ArrayList<Venta> ventas) {
        System.out.println("Informe de Ventas:");
        for (Venta venta : ventas) {
            System.out.println("Venta #" + venta.getIdVenta() + ":");
            for (Producto producto : venta.getProductosVendidos()) {
                System.out.println("  - " + producto.getNombre() + " x " + producto.getCantidadEnStock());
            }
            System.out.println("  Total: " + venta.getTotalVenta());
        }
    }

    public void generarInformeInventario(ArrayList<Producto> productos) {
        System.out.println("Informe de Inventario:");
        for (Producto producto : productos) {
            System.out.println("Producto #" + producto.getId() + ": " + producto.getNombre() + " - Cantidad en Stock: " + producto.getCantidadEnStock());
        }
    }
}