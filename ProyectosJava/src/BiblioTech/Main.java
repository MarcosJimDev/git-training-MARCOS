package BiblioTech;

import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Clase principal que ejecuta la interfaz de consola de BiblioTech.
 * Coordina la interacción entre el usuario, la biblioteca y los libros.
 *
 * @author Marcos Jiménez
 * @version 1.0
 * @since 10-04-2026
 */
public class Main {
    static Scanner sc = new Scanner(System.in);

    /**
     * Método principal que inicia el flujo del programa.
     *
     * @param args Argumentos de la línea de comandos (no utilizados).
     * @throws InputMismatchException Si el usuario introduce un carácter no numérico en el menú.
     */
    public static void main(String[] args) {
        Biblioteca biblioTech = new Biblioteca("BiblioTech");

        Autor cervantes = new Autor("Miguel de Cervantes", "Española");
        Autor follett = new Autor("Ken Follett", "Británica");

        Libro quijote = new Libro("El Quijote", cervantes, 5.5);
        Libro pilares = new Libro("Los Pilares de la Tierra", follett, 6.5);
        Libro mundo = new Libro("Un mundo sin fin", follett, 6);

        biblioTech.agregarLibro(quijote);
        biblioTech.agregarLibro(pilares);
        biblioTech.agregarLibro(mundo);

        int respuesta;
        boolean primeraVuelta = true;

        mostrarMenu();

        do {
            if (!primeraVuelta) {
                System.out.println("Escoge una opción: ");
            }

            try {
                respuesta = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debes introducir un número.");
                sc.nextLine();
                respuesta = 0;
                continue;
            }

            sc.nextLine();

            switch (respuesta) {
                case 1:
                    primeraVuelta = false;
                    System.out.println("\n*** ALQUILAR LIBRO ***");
                    alquilarLibro(biblioTech);
                    break;
                case 2:
                    primeraVuelta = false;
                    System.out.println("\n*** CATÁLOGO DE BIBLIOTECH ***");
                    biblioTech.mostrarCatalogo();
                    break;
                case 3:
                    System.out.println("Saliendo de BiblioTech...");
                    break;
                default:
                    System.out.println("ERROR: opción inválida.");
                    break;
            }
        } while (respuesta != 3);
    }

    /**
     * Muestra las opciones disponibles en el menú principal por consola.
     */
    public static void mostrarMenu() {
        System.out.println("*** BIENVENIDO A BIBLIOTECH ***");
        System.out.println("Escoge una de las siguientes opciones: ");
        System.out.println("\t1. Alquilar un libro.");
        System.out.println("\t2. Ver el catálogo.");
        System.out.println("\t3. Salir.");
    }

    /**
     * Gestiona el proceso completo de búsqueda y alquiler de un libro.
     * Solicita datos al usuario y actualiza el estado del libro alquilado.
     *
     * @param biblioteca El objeto Biblioteca donde se realizará la búsqueda.
     */
    public static void alquilarLibro(Biblioteca biblioteca) {
        System.out.println("\nIntroduce el título del libro que estás buscando: ");
        String titulo = sc.nextLine();

        Libro libro = biblioteca.buscarLibro(titulo);

        if (libro != null) {
            System.out.println("¡El libro '" + libro.getTitulo() + "' ha sido encontrado!");
            System.out.println(libro.toString());

            System.out.println("¿Eres estudiante? (s/n)");

            String respuesta;
            boolean esEstudiante, respuestaInvalida;

            do {
                respuesta = sc.nextLine();

                if (respuesta.equalsIgnoreCase("s")) {
                    respuestaInvalida = false;
                    esEstudiante = true;
                    System.out.println("Precio final: " + libro.calcularPrecioFinal(esEstudiante) + "€");
                    libro.setDisponible(false);
                } else if (respuesta.equalsIgnoreCase("n")) {
                    respuestaInvalida = false;
                    esEstudiante = false;
                    System.out.println("Precio final: " + libro.calcularPrecioFinal(esEstudiante) + "€");
                    libro.setDisponible(false);
                } else {
                    respuestaInvalida = true;
                    System.out.println("ERROR: respuesta inválida. Por favor, introduce una nueva respuesta: ");
                }
            } while (respuestaInvalida);
        } else {
            System.out.println("ERROR: el libro buscado no existe o no está disponible.");
        }
    }
}