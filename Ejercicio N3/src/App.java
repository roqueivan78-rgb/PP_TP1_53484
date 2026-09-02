import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lista para almacenar varios estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();
        String continuarEstudiantes;

        System.out.println("=== REGISTRO DE ESTUDIANTES ===");
        do {
            System.out.print("Ingrese legajo del estudiante: ");
            String legajo = scanner.nextLine();
            System.out.print("Ingrese nombre del estudiante: ");
            String nombreEstudiante = scanner.nextLine();

            // Se agrega el estudiante a la lista
            estudiantes.add(new Estudiante(legajo, nombreEstudiante));

            System.out.print("¿Desea agregar otro estudiante? (s/n): ");
            continuarEstudiantes = scanner.nextLine();
            System.out.println();
        } while (continuarEstudiantes.equalsIgnoreCase("s"));

        System.out.println("=== REGISTRO DE SALA ===");
        System.out.print("Ingrese ID de la sala: ");
        int idSala = scanner.nextInt();
        scanner.nextLine(); // Limpiar el búfer
        System.out.print("Ingrese nombre de la sala: ");
        String nombreSala = scanner.nextLine();
        Sala sala = new Sala(idSala, nombreSala);

        System.out.println("\n=== REGISTRO DE EVENTO ===");
        System.out.print("Ingrese ID del evento: ");
        String idEvento = scanner.nextLine();
        System.out.print("Ingrese título del evento: ");
        String tituloEvento = scanner.nextLine();
        System.out.print("Ingrese costo base del evento: ");
        double costoBase = scanner.nextDouble();
        System.out.print("¿Es gratuito? (true/false): ");
        boolean gratuito = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar el búfer

        EventoUniversitario evento = new EventoUniversitario(idEvento, tituloEvento, costoBase, gratuito);
        evento.asignarSala(sala);

        System.out.println("\n=== REGISTRO DE ACTIVIDADES ===");
        System.out.print("¿Cuántas actividades querés agregar al evento?: ");
        int cantidadActividades = scanner.nextInt();
        scanner.nextLine(); // Limpiar búfer

        for (int i = 1; i <= cantidadActividades; i++) {
            System.out.println("\n--- Actividad " + i + " ---");
            System.out.print("Tipo de actividad (Charla / Taller): ");
            String tipo = scanner.nextLine();

            System.out.print("ID de la actividad: ");
            int idAct = scanner.nextInt();
            scanner.nextLine(); // Limpiar búfer

            System.out.print("Título de la actividad: ");
            String tituloAct = scanner.nextLine();

            System.out.print("Cupo máximo: ");
            int cupo = scanner.nextInt();
            scanner.nextLine(); // Limpiar búfer

            if (tipo.equalsIgnoreCase("Charla")) {
                System.out.print("Nombre del disertante: ");
                String disertante = scanner.nextLine();
                evento.crearActividad(idAct, tituloAct, cupo, "Charla", disertante, false);

            } else if (tipo.equalsIgnoreCase("Taller")) {
                System.out.print("¿Requiere notebook? (true/false): ");
                boolean requiereNotebook = scanner.nextBoolean();
                scanner.nextLine(); // Limpiar búfer
                evento.crearActividad(idAct, tituloAct, cupo, "Taller", null, requiereNotebook);
            } else {
                System.out.println("Tipo no válido, se omitirá esta actividad.");
            }
        }

        // Inscribir a todos los estudiantes registrados en las actividades creadas
        System.out.println("\nInscribiendo estudiantes en las actividades...");
        for (Actividad act : evento.getActividades()) {
            for (Estudiante est : estudiantes) {
                act.inscribir(est);
            }
        }

        // Mostrar los resultados calculados
        System.out.println("\n============================================");
        System.out.println("            RESULTADO DEL EVENTO            ");
        System.out.println("============================================");
        evento.mostrarDatos();

        System.out.println("\nTotal de eventos creados en el sistema: " + EventoUniversitario.getCantidadEventos());

        scanner.close();
    }
}