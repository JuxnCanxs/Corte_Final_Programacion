package Controllers;

import models.Venta;

import java.util.ArrayList;

public class Informe {
    public void generateSalesReport(ArrayList<Venta> ventas) {
        System.out.println("Informe de Ventas:");
        for (Venta venta : ventas) {
            System.out.println("Venta ID: " + venta.getIdVenta());
            System.out.println("Fecha y Hora: " + venta.getFechaYHora());
            System.out.println("Total Venta: " + venta.getTotalVenta());
            System.out.println();
        }
    }
}
