import java.util.ArrayList;
import java.util.List;

public class Actividad {
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
        System.out.println("   Inscritos en [" + titulo + "]:");
        if (inscripciones.isEmpty()) {
            System.out.println("   (No hay alumnos inscritos)");
        } else {
            for (Inscripcion ins : inscripciones) {
                System.out.println("    - " + ins.getEstudiante().getNombre() + " (Legajo: " + ins.getEstudiante().getLegajo() + ") | Estado: " + ins.getEstado());
            }
        }
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}