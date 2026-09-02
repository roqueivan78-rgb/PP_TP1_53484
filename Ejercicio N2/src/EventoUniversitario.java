import java.util.ArrayList;
import java.util.List;

public class EventoUniversitario {
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos = 0;

    private Sala sala;
    private List<Actividad> actividades;

    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        this.actividades = new ArrayList<>();
        cantidadEventos++;
    }

    public EventoUniversitario(EventoUniversitario otro) {
        this(otro.id, otro.titulo, otro.costoBase, otro.gratuito);
        this.sala = otro.sala;
        this.actividades = new ArrayList<>(otro.actividades);
    }

    public void asignarSala(Sala sala) {
        this.sala = sala;
    }

    public void crearActividad(int id, String titulo, int cupo) {
        Actividad nuevaActividad = new Actividad(id, titulo, cupo);
        actividades.add(nuevaActividad);
    }

    public double calcularCostoEstimado() {
        return gratuito ? 0.0 : costoBase * 1.21;
    }

    public void mostrarDatos() {
        System.out.println("\n=== EVENTO: " + titulo + " (ID: " + id + ") ===");
        System.out.println("Gratuito: " + (gratuito ? "Sí" : "No"));
        System.out.println("Sala: " + (sala != null ? sala.getNombre() : "Sin asignación"));
        System.out.println("Costo Estimado: $" + calcularCostoEstimado());
        System.out.println("--- Agenda de Actividades ---");
        for (Actividad act : actividades) {
            System.out.println(" * Actividad ID: " + act.getId() + " - " + act.getTitulo());
            act.mostrarInscripciones();
        }
    }

    public static int getCantidadEventos() {
        return cantidadEventos;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }
}