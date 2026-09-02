public class EventoUniversitario {
    // Atributos privados (Encapsulamiento)
    private final String id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private static int cantidadEventos = 0; // Atributo de clase (contador)

    // Constructor principal
    public EventoUniversitario(String id, String titulo, double costoBase, boolean gratuito) {
        this.id = id;
        this.titulo = titulo;
        this.costoBase = costoBase;
        this.gratuito = gratuito;
        cantidadEventos++; // Incrementa el contador global
    }

    // Constructor de copia
    public EventoUniversitario(EventoUniversitario otro) {
        this(otro.id, otro.titulo, otro.costoBase, otro.gratuito); // Reutiliza el constructor principal
    }

    // Método para calcular el costo
    public double calcularCostoEstimado() {
        if (gratuito) {
            return 0.0;
        } else {
            return costoBase * 1.21; // Costo base + 21% de impuestos
        }
    }

    // Métodos requeridos por el UML (se dejan simples por ahora)
    public void asignarSala(Object sala) {
        // En este ejercicio no se utiliza
    }

    public void crearActividad(int id, String titulo, int cupo) {
        // En este ejercicio no se utiliza
    }

    // Muestra la información del evento
    public void mostrarDatos() {
        System.out.println("ID: " + id);
        System.out.println("Título: " + titulo);
        System.out.println("Gratuito: " + (gratuito ? "Sí" : "No"));
        System.out.println("Costo Estimado: $" + calcularCostoEstimado());
    }

    // Getter estático para consultar el total de eventos
    public static int getCantidadEventos() {
        return cantidadEventos;
    }
}