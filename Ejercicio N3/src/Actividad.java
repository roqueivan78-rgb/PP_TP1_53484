import java.util.ArrayList;
import java.util.List;

public abstract class Actividad {
    private int id;
    private String titulo;
    private int cupoMaximo;
    public static final int CUPO_MINIMO = 5;
    private List<Inscripcion> inscripciones;

    public Actividad(int id, String titulo, int cupoMaximo) {
        this.id = id;
        this.titulo = titulo;
        this.cupoMaximo = cupoMaximo;
        this.inscripciones = new ArrayList<>();
    }

    public Inscripcion inscribir(Estudiante estudiante) {
        if (inscripciones.size() < cupoMaximo) {
            Inscripcion inscripcion = new Inscripcion(estudiante, "CONFIRMADA");
            inscripciones.add(inscripcion);
            return inscripcion;
        } else {
            System.out.println("Cupo agotado para la actividad: " + titulo);
            return null;
        }
    }

    public void mostrarInscripciones() {
        System.out.println("Inscripciones para: " + titulo);
        for (Inscripcion ins : inscripciones) {
            System.out.println(" - " + ins.getEstudiante().getNombre() + " | Fecha: " + ins.getFecha() + " | Estado: " + ins.getEstado());
        }
    }

    // Método marcado como FINAL para evitar que las subclases lo usen
    public final void mostrarIdentificacion() {
        System.out.println("[" + getTipo() + "] ID: " + id + " - Título: " + titulo + " - Cupo Máx: " + cupoMaximo);
    }


    public abstract double calcularCostoMateriales();
    public abstract String getTipo();

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }
}
