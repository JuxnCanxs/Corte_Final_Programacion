
import Controllers.Informe;
import models.Producto;
import models.Usuario;
import models.Venta;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static ArrayList<Producto> productos;
    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Venta> ventas;
    private static Informe informe;

    public static void main(String[] args) {
        productos = new ArrayList<>();
        usuarios = new ArrayList<>();
        ventas = new ArrayList<>();
        informe = new Informe();

        Scanner scanner = new Scanner(System.in);
        boolean ejecutar = true;

        while (ejecutar) {
            System.out.println("Opciones:");
            System.out.println("1. Ingresar Producto");
            System.out.println("2. Ingresar Usuario");
            System.out.println("3. Realizar Venta");
            System.out.println("4. Generar Informe de Ventas");
            System.out.println("5. Generar Informe de Inventario");
            System.out.println("6. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    ingresarProducto();
                    break;
                case 2:
                    ingresarUsuario();
                    break;
                case 3:
                    realizarVenta();
                    break;
                case 4:
                    informe.generarInformeVentas(ventas);
                    break;
                case 5:
                    informe.generarInformeInventario(productos);
                    break;
                case 6:
                    ejecutar = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }

        scanner.close();
    }

    private static void ingresarProducto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del producto:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la cantidad en stock del producto:");
        int cantidadEnStock = scanner.nextInt();

        System.out.println("Ingrese el precio del producto:");
        double precio = scanner.nextDouble();

        Producto producto = new Producto(productos.size() + 1, nombre, cantidadEnStock, precio);
        productos.add(producto);

        System.out.println("Producto ingresado correctamente");
    }

    private static void ingresarUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de usuario:");
        String nombreUsuario = scanner.nextLine();

        System.out.println("Ingrese la contraseña:");
        String contraseña = scanner.nextLine();

        System.out.println("Ingrese el rol del usuario (Admin, Cajero, Cliente):");
        String rol = scanner.nextLine();

        Usuario usuario = new Usuario(nombreUsuario, contraseña, rol);
        usuarios.add(usuario);

        System.out.println("Usuario ingresado correctamente");
    }

    private static void realizarVenta() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre de usuario para realizar la venta:");
        String nombreUsuario = scanner.nextLine();

        Usuario usuario = usuarios.stream().filter(u -> u.getNombreUsuario().equals(nombreUsuario)).findFirst().orElse(null);

        if (usuario == null) {
            System.out.println("Usuario no encontrado");
            return;
        }

        if (!usuario.getRol().equals("Cajero")) {
            System.out.println("El usuario no tiene permisos para realizar ventas");
            return;
        }

        Venta venta = new Venta(ventas.size() + 1);

        while (true) {
            System.out.println("Ingrese el id del producto a vender:");
            int idProducto = scanner.nextInt();

            Producto producto = productos.stream().filter(p -> p.getId() == idProducto).findFirst().orElse(null);

            if (producto == null) {
                System.out.println("Producto no encontr100% free. 100% original. No reused. Search for 'translate english to spanish' in the internet for more info.");
                continue;
            }

            if (producto.getCantidadEnStock() <= 0) {
                System.out.println("El producto no tiene stock disponible");
                continue;
            }

            System.out.println("Ingrese la cantidad a vender:");
            int cantidad = scanner.nextInt();

            if (cantidad > producto.getCantidadEnStock()) {
                System.out.println("La cantidad a vender supera la cantidad en stock");
                continue;
            }

            producto.actualizarCantidadEnStock(-cantidad);
            venta.agregarProducto(producto);

            System.out.println("Producto vendido correctamente");
        }
    }
}

