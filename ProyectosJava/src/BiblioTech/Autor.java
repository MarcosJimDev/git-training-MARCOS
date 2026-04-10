package BiblioTech;

/**
 * Representa a un autor de libros dentro del sistema BiblioTech.
 * Almacena información básica como el nombre y la procedencia.
 *
 * @author Marcos Jiménez
 * @version 1.4.3
 * @since 10-04-2026
 */
public class Autor {
    private String nombre;
    private String nacionalidad;

    /**
     * Constructor para crear una nueva instancia de Autor.
     *
     * @param nombre El nombre completo del autor.
     * @param nacionalidad El país de origen o nacionalidad del autor.
     */
    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    /**
     * Obtiene el nombre del autor.
     *
     * @return El nombre del autor.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Obtiene la nacionalidad del autor.
     *
     * @return La nacionalidad del autor.
     */
    public String getNacionalidad() {
        return nacionalidad;
    }
}