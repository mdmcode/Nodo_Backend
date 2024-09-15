import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static String alfabeto = "KJIHGFEDCBA";
    static ArrayList<Pelicula> peliculas = new ArrayList<>();

    public static void main(String[] args) {
        /*
        Crea una aplicación que permita a los usuarios reservar entradas para el cine.
        El programa debe
        - mostrar las películas disponibles
        - permitir la selección de asientos
        - procesar el pago (simulado).

        Asegúrate de gestionar la disponibilidad de asientos de manera eficiente.
         */

        // Crear una nueva película
        Pelicula pelicula = new Pelicula("El señor de los anillos", 10);
    }
}

class Pelicula {
    String nombre;
    String[][] asientos;
    int precio;

    // Constructor
    public Pelicula(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.asientos = new String[Main.alfabeto.length()][15];

        // Recorre el alfabeto y los números del 1 al 12 para crear los asientos
        for (int i = 0; i < Main.alfabeto.length(); i++) {
            for (int j = 0; j < 15; j++) {
                asientos[i][j] = Main.alfabeto.charAt(i) + String.valueOf(j);
            }
        }
    }
}