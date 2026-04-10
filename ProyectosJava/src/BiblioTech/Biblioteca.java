package BiblioTech;

/**
 * Gestiona un inventario limitado de libros y permite realizar operaciones de gestión.
 *
 * @author Marcos Jiménez
 * @version 1.1.1
 * @since 10-04-2026
 */
public class Biblioteca {
    private Libro[] inventario;
    private String nombreBiblioteca;
    private static final int NUMERO_MAX_LIBROS = 5;
    private int numLibros = 0;

    /**
     * Constructor que inicializa la biblioteca con un nombre y capacidad predefinida.
     *
     * @param nombreBiblioteca Nombre comercial de la biblioteca.
     */
    public Biblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
        this.inventario = new Libro[NUMERO_MAX_LIBROS];
    }

    /**
     * Intenta añadir un libro al inventario si hay espacio disponible.
     *
     * @param nuevo El objeto Libro que se desea añadir.
     * @return true si el libro se añadió con éxito; false si el inventario está lleno.
     */
    public boolean agregarLibro(Libro nuevo) {
        if (numLibros >= NUMERO_MAX_LIBROS) {
            return false;
        } else {
            inventario[numLibros] = nuevo;
            numLibros++;
            return true;
        }
    }

    /**
     * Busca un libro en el inventario por coincidencia parcial en el título.
     *
     * @param titulo El texto o título completo a buscar.
     * @return El primer objeto Libro que coincida; null si no se encuentra nada.
     */
    public Libro buscarLibro(String titulo) {
        for (int cont = 0; cont < inventario.length; cont++) {
            if (inventario[cont] != null) {
                if (inventario[cont].getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                    return inventario[cont];
                }
            }
        }
        return null;
    }

    /**
     * Imprime por consola la información de todos los libros presentes en el inventario.
     */
    public void mostrarCatalogo() {
        for (int cont = 0; cont < inventario.length; cont++) {
            if (inventario[cont] != null) {
                System.out.println(inventario[cont].toString());
            }
        }
    }

    /**
     * Obtiene el nombre de la institución.
     * @deprecated Este método podría ser eliminado en futuras versiones a favor de nombres dinámicos.
     * @return El nombre de la biblioteca.
     */
    @Deprecated
    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    /**
     * Cambia el nombre de la biblioteca.
     * @param nombreBiblioteca Nuevo nombre de la biblioteca.
     */
    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }

    /**
     * Devuelve el array completo que conforma el inventario.
     * @return El array de objetos Libro.
     */
    public Libro[] getInventario() {
        return inventario;
    }
}