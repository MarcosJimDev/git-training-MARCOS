package BiblioTech;

import BiblioTech.Utils.Utils;

/**
 * Representa un libro individual en el inventario.
 * Gestiona el cálculo de precios, disponibilidad y asignación automática de ISBN.
 *
 * @author Marcos Jiménez
 * @version 1.5.0
 * @since 10-04-2026
 */
public class Libro {
    private final int isbn;
    private String titulo;
    private Autor autor;
    private double precioAlquiler;
    private boolean disponible = true;
    private static int contadorIsbn = 500;
    private final double DESCUENTO_ESTUDIANTE = 0.15;

    /**
     * Constructor de la clase Libro. Genera automáticamente un ISBN único.
     *
     * @param titulo El título de la obra.
     * @param autor Objeto de la clase Autor que escribió el libro.
     * @param precioAlquiler El coste base por alquilar el libro.
     */
    public Libro(String titulo, Autor autor, double precioAlquiler) {
        this.titulo = titulo;
        this.autor = autor;
        this.precioAlquiler = precioAlquiler;
        isbn = contadorIsbn;
        contadorIsbn++;
    }

    /**
     * Calcula el precio final del alquiler aplicando descuentos si procede.
     *
     * @param esEstudiante Indica si el cliente tiene perfil de estudiante para aplicar el 15%.
     * @return El precio final tras aplicar (o no) el descuento.
     */
    public double calcularPrecioFinal(boolean esEstudiante) {
        if (esEstudiante) {
            return precioAlquiler - (precioAlquiler * DESCUENTO_ESTUDIANTE);
        } else {
            return precioAlquiler;
        }
    }

    /**
     * Genera una ficha detallada del libro con sus atributos.
     *
     * @return Una cadena formateada con el ISBN, título, autor y disponibilidad.
     */
    @Override
    public String toString() {
        return "\n*** INFORMACIÓN DEL LIBRO ***" +
                "\n\tISBN: " + isbn +
                "\n\tTítulo: " + titulo +
                "\n\tAutor: " + autor.getNombre() +
                "\n\t¿Está disponible?: " + Utils.convertirBooleanAString(disponible);
    }

    // --- Getters y Setters ---

    /** @return El título actual del libro. */
    public String getTitulo() { return titulo; }

    /** @param titulo El nuevo título a asignar. */
    public void setTitulo(String titulo) { this.titulo = titulo; }

    /** @return El precio base de alquiler. */
    public double getPrecioAlquiler() { return precioAlquiler; }

    /** @param precioAlquiler El nuevo precio base de alquiler. */
    public void setPrecioAlquiler(double precioAlquiler) { this.precioAlquiler = precioAlquiler; }

    /** @return true si el libro puede ser alquilado, false en caso contrario. */
    public boolean isDisponible() { return disponible; }

    /** @param disponible Estado de disponibilidad a establecer. */
    public void setDisponible(boolean disponible) { this.disponible = disponible; }

    /** @return El código ISBN único asignado al libro. */
    public int getIsbn() { return isbn; }
}