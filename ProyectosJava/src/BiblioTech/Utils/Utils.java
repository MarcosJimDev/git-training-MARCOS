package BiblioTech.Utils;

/**
 * Clase de utilidad utilizada para la conversión de datos booleanos y su posibilidad visual en la clase que la incorpore.
 *
 * @author Marcos Jiménez
 * @version 1.5.2
 * @since 10-04-2026
 */
public class Utils {
    private static final String VALOR_SI = "Sí";
    private static final String VALOR_NO = "No";

    /**
     * Método que realiza la conversión del booleano a String.
     *
     * @param booleano es el valor booleano que recibe.
     * @return el valor String: "Sí" si es true y "No" si es false.
     * */
    public static String convertirBooleanAString(boolean booleano) {
        return booleano ? VALOR_SI : VALOR_NO;
    }
}
