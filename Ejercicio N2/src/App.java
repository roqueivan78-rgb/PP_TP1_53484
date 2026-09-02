import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a. Construir lista de estudiantes
        List<Estudiante> estudiantes = new ArrayList<>();
        System.out.print("¿Cuántos estudiantes querés registrar?: ");
        int cantEstudiantes = scanner.nextInt();
        scanner.nextLine(); // Limpiar búfer

        for (int i = 1; i <= cantEstudiantes; i++) {
            System.out.println("\n--- Estudiante " + i + " ---");
            System.out.print("Legajo: ");
            String legajo = scanner.nextLine();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            estudiantes.add(new Estudiante(legajo, nombre));
        }

        // b. Construir evento
        System.out.println("\n=== REGISTRO DE EVENTO ===");
        System.out.print("ID del evento: ");
        String idEvento = scanner.nextLine();
        System.out.print("Título del evento: ");
        String tituloEvento = scanner.nextLine();
        System.out.print("Costo base: ");
        double costoBase = scanner.nextDouble();
        System.out.print("¿Es gratuito? (true/false): ");
        boolean gratuito = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar búfer

        EventoUniversitario evento = new EventoUniversitario(idEvento, tituloEvento, costoBase, gratuito);

        // c. Asignar sala al evento
        System.out.println("\n=== REGISTRO DE SALA ===");
        System.out.print("ID de la sala: ");
        int idSala = scanner.nextInt();
        scanner.nextLine(); // Limpiar búfer
        System.out.print("Nombre de la sala: ");
        String nombreSala = scanner.nextLine();

        Sala sala = new Sala(idSala, nombreSala);
        evento.asignarSala(sala);

        // d. Crear actividades propias del evento
        System.out.println("\n=== REGISTRO DE ACTIVIDADES ===");
        System.out.print("¿Cuántas actividades querés agregar al evento?: ");
        int cantActividades = scanner.nextInt();
        scanner.nextLine(); // Limpiar búfer

        for (int i = 1; i <= cantActividades; i++) {
            System.out.println("\n--- Actividad " + i + " ---");
            System.out.print("ID de actividad: ");
            int idAct = scanner.nextInt();
            scanner.nextLine(); // Limpiar búfer
            System.out.print("Título de la actividad: ");
            String tituloAct = scanner.nextLine();
            System.out.print("Cupo máximo: ");
            int cupoAct = scanner.nextInt();
            scanner.nextLine(); // Limpiar búfer

            evento.crearActividad(idAct, tituloAct, cupoAct);
        }

        // e. Inscribir estudiantes en las actividades creadas
        if (!estudiantes.isEmpty() && !evento.getActividades().isEmpty()) {
            System.out.println("\n=== INSCRIPCIONES ===");
            for (Actividad actividad : evento.getActividades()) {
                System.out.println("Inscribiendo estudiantes en: " + actividad.getTitulo());
                for (Estudiante est : estudiantes) {
                    actividad.inscribir(est);
                }
            }
        }

        // f. Mostrar el resumen de datos por cada evento creado
        System.out.println("\n==========================================");
        System.out.println("            RESUMEN DEL EVENTO            ");
        System.out.println("==========================================");
        evento.mostrarDatos();

        // g. Mostrar el total de eventos creados
        System.out.println("\n------------------------------------------");
        System.out.println("Total de eventos creados: " + EventoUniversitario.getCantidadEventos());

        scanner.close();
    }
}