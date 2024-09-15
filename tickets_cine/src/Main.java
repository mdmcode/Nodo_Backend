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

// Clases
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

        // Añade la película a la lista de películas
        Main.peliculas.add(this);
    }
}

class PeliculaMostrarAsientos {
    // Method para mostrar los asientos disponibles
    public void mostrarAsientos(Pelicula pelicula) {
        System.out.println("Asientos disponibles para la película " + pelicula.nombre);
        // Recorre la matriz de asientos y los muestra
        for (int i = 0; i < Main.alfabeto.length(); i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(pelicula.asientos[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class PeliculaReservarAsientos {
    // Method para reservar asientos
    public void reservarAsientos(Pelicula pelicula, String[] asientos) {
        // Recorre la matriz de asientos y si el asiento está disponible, lo reserva
        for (String asiento : asientos) {
            for (int i = 0; i < Main.alfabeto.length(); i++) {
                for (int j = 0; j < 15; j++) {
                    // Si el asiento está disponible, lo reserva
                    if (pelicula.asientos[i][j].equals(asiento)) {
                        // Cambia el asiento a "X" para indicar que está reservado
                        pelicula.asientos[i][j] = "X";
                        System.out.println("Asiento " + asiento + " reservado con éxito.");
                    }
                }
            }
        }
    }
}

class PeliculaPagarBoleta {
    // Method para pagar la boleta
    public void pagarBoleta(Pelicula pelicula, String[] asientos) {
        int total = pelicula.precio * asientos.length;
        System.out.println("Total a pagar: " + total + "€");
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Desea pagar la boleta? (S/N)");
        String respuesta = scanner.nextLine();

        if (respuesta.equals("S")) {
            System.out.println("Pago exitoso.");
        } else {
            System.out.println("Transacción cancelada.");
        }
    }
}