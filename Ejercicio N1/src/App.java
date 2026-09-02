import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a. Pedir datos para crear el evento
        System.out.println("=== INGRESO DE DATOS DEL EVENTO ===");
        System.out.print("Ingrese ID del evento: ");
        String id = scanner.nextLine();

        System.out.print("Ingrese título del evento: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese costo base: ");
        double costoBase = scanner.nextDouble();

        System.out.print("¿Es gratuito? (true/false): ");
        boolean gratuito = scanner.nextBoolean();

        // Crear el objeto con los datos ingresados
        EventoUniversitario evento1 = new EventoUniversitario(id, titulo, costoBase, gratuito);

        // b. Crear la copia usando el constructor de copia
        EventoUniversitario copiaEvento1 = new EventoUniversitario(evento1);

        // c. Mostrar los resultados
        System.out.println("\n=================================");
        System.out.println("=== DATOS DEL EVENTO ORIGINAL ===");
        System.out.println("=================================");
        evento1.mostrarDatos();

        System.out.println("\n=================================");
        System.out.println("=== DATOS DEL EVENTO COPIADO ===");
        System.out.println("=================================");
        copiaEvento1.mostrarDatos();

        // d. Mostrar el contador total de eventos
        System.out.println("\n---------------------------------");
        System.out.println("Total de eventos creados: " + EventoUniversitario.getCantidadEventos());

        scanner.close();
    }
}