import models.Venta;
import models.Producto;
import models.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    private static List<Producto> productos = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Venta> ventas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Inicializar productos de ejemplo
        productos.add(new Producto(1, "Producto 1", "Descripción 1", 10.0, 5, LocalDate.of(2023, 12, 31)));
        productos.add(new Producto(2, "Producto 2", "Descripción 2", 20.0, 10, LocalDate.of(2024, 06, 15)));

        // Inicializar usuarios de ejemplo
        usuarios.add(new Usuario("admin", "password", "administrador"));
        usuarios.add(new Usuario("vendedor", "password", "vendedor"));
        usuarios.add(new Usuario("gerente", "password", "gerente"));

        // Menú principal
        while (true) {
            System.out.println("Sistema de Gestión de Inventario para una Tienda de Electrónica");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();

            if (option == 1) {
                System.out.print("Ingrese su nombre de usuario: ");
                String username = scanner.next();
                System.out.print("Ingrese su contraseña: ");
                String password = scanner.next();

                Usuario user = login(username, password);
                if (user != null) {
                    switch (Usuario.getRol)) {
                        case "administrador":
                            administradorMenu(scanner, formatter);
                            break;
                        case "vendedor":
                            vendedorMenu(scanner, formatter);
                            break;
                        case "gerente":
                            gerenteMenu(scanner, formatter);
                            break;
                    }
                } else {
                    System.out.println("Nombre de usuario o contraseña incorrectos.");
                }
            } else if (option == 2) {
                break;
            } else {
                System.out.println("Opción inválida.");
            }
        }

        scanner.close();
    }

    private static Usuario login(String username, String password) {
        for (Usuario user : usuarios) {
            if (user.getNombreUsuario().equals(username) && user.verifyPassword(password)) {
                return user;
            }
        }
        return null;
    }

    private static void administradorMenu(Scanner scanner, DateTimeFormatter formatter) {
        while (true) {
            System.out.println("\nMenú de administrador");
            System.out.println("1. Administrar productos");
            System.out.println("2. Administrar usuarios");
            System.out.println("3. Generar informe de inventario");
            System.out.println("4. Generar informe de ventas");
            System.out.println("5. Salir");
            System.out

        }
    }
}