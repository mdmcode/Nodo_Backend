import java.util.ArrayList;
import java.util.Scanner;

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
        // Creamos las películas
        Pelicula pelicula1 = new Pelicula("El señor de los anillos", 10);
        Pelicula pelicula2 = new Pelicula("Harry Potter", 8);
        Pelicula pelicula3 = new Pelicula("Star Wars", 12);
        Pelicula pelicula4 = new Pelicula("Indiana Jones", 9);

        // Instanciamos las clases para mostrar y reservar asientos
        PeliculaMostrarAsientos mostrarAsientos = new PeliculaMostrarAsientos();
        PeliculaReservarAsientos reservarAsientos = new PeliculaReservarAsientos();

        // Instanciamos la clase para pagar la boleta
        PeliculaPagarBoleta pagarBoleta = new PeliculaPagarBoleta();

        System.out.println("Bienvenido al cine");
        System.out.println("Películas disponibles:");
        // Mostramos las películas disponibles
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula.nombre);
        }

        // Bucle de la app
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce el nombre de la película a la que deseas asistir:");
            String nombrePelicula = scanner.nextLine();

            // Buscamos la película seleccionada
            Pelicula peliculaSeleccionada = null;
            for (Pelicula pelicula : peliculas) {
                if (pelicula.nombre.equals(nombrePelicula)) {
                    peliculaSeleccionada = pelicula;
                }
            }

            // Si la película no existe, mostramos un mensaje y volvemos al inicio del bucle
            if (peliculaSeleccionada == null) {
                System.out.println("La película seleccionada no existe.");
                continue;
            }

            // Mostramos la información de la película seleccionada
            mostrarInfo(peliculaSeleccionada);

            // Mostramos los asientos disponibles
            mostrarAsientos.mostrarAsientos(peliculaSeleccionada);

            // Pedimos los asientos a reservar
            System.out.println("Introduce los asientos que deseas reservar (separados por comas):");
            String asientosString = scanner.nextLine();
            String[] asientos = asientosString.split(",");

            // Reservamos los asientos
            reservarAsientos.reservarAsientos(peliculaSeleccionada, asientos);
            System.out.println("Asientos reservados: ");
            mostrarAsientos.mostrarAsientos(peliculaSeleccionada);

            // Preguntamos si desea pagar la boleta
            pagarBoleta.pagarBoleta(peliculaSeleccionada, asientos);

            // Preguntamos si desea ver otra película
            System.out.println("¿Desea ver otra película? (S/N)");
            String respuesta = scanner.nextLine();
            if (respuesta.equals("N")) {
                break;
            }
        }

    }

    static void mostrarInfo(Pelicula pelicula) {
        System.out.println("Nombre: " + pelicula.nombre);
        System.out.println("Precio: " + pelicula.precio);
    }
}