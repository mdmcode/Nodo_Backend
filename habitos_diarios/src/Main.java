import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Desarrolla un programa que permita al usuario ingresar sus hábitos diarios
        (por ejemplo, beber agua, hacer ejercicio, leer).
        El programa debe almacenar el progreso de cada hábito
        y mostrar un resumen diario o semanal del cumplimiento de los hábitos.
         */
        Scanner scanner = new Scanner(System.in);
        ArrayList<Habito> listaHabits = new ArrayList<>();

        while (true) {
            // Menú
            System.out.println("1. Agregar hábito");
            System.out.println("2. Incrementar progreso de hábito");
            System.out.println("3. Decrementar progreso de hábito");
            System.out.println("4. Mostrar progreso de hábito");
            System.out.println("5. Salir");
            System.out.print("Opción: ");

            // Leer opción
            int op = scanner.nextInt();

            // Realizar acción según la opción
            switch (op) {
                case 1:
                    // Agregar hábito a la lista de hábitos
                    System.out.println("Nombre del hábito: ");
                    String nombre = scanner.nextLine();
                    System.out.println("Meta del hábito: ");
                    int meta = scanner.nextInt();

                    // Crear un nuevo hábito y agregarlo a la lista de hábitos
                    listaHabits.add(new Habito(nombre, meta));
                    break;
                case 2:
                    // Incrementar progreso de un hábito
                    System.out.println("Nombre del hábito: ");
                    String nombreIncrementar = scanner.nextLine();

                    // Busca el hábito en la lista de hábitos y aumenta su progreso
                    for (Habito habito : listaHabits) {
                        if (habito.nombre.equals(nombreIncrementar)) {
                            habito.incrementarProgreso();
                        }
                    }

                    break;
                case 3:
                    // Decrementa el progreso de un hábito
                    System.out.println("Nombre del hábito: ");
                    // Leer el nombre del hábito
                    String nombreDecrementar = scanner.nextLine();

                    // Busca el hábito en la lista de hábitos y disminuye su progreso
                    for (Habito habito : listaHabits) {
                        if (habito.nombre.equals(nombreDecrementar)) {
                            habito.decrementarProgreso();
                        }
                    }

                    break;
                case 4:
                    // Muestra el progreso de un hábito
                    System.out.println("Nombre del hábito: ");
                    String nombreMostrar = scanner.nextLine();

                    // Busca el hábito en la lista de hábitos y muestra su progreso
                    for (Habito habito : listaHabits) {
                        if (habito.nombre.equals(nombreMostrar)) {
                            habito.mostrarProgreso();
                        }
                    }

                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}

class Habito {
    // Atributos
    String nombre;
    int progreso;
    int meta;

    // Constructor
    public Habito(String nombre, int meta) {
        // Establece las propiedades del hábito al crearlo según los parámetros
        this.nombre = nombre;
        this.meta = meta;
        this.progreso = 0;
    }

    // Métodos

    // Incrementa el progreso del hábito
    public void incrementarProgreso() {
        this.progreso++;
    }

    // Decrementa el progreso del hábito
    public void decrementarProgreso() {
        this.progreso--;
    }

    // Muestra el progreso del hábito
    public void mostrarProgreso() {
        // Muestra por consola el nombre del hábito, el progreso actual y la meta
        System.out.println("Hábito: " + this.nombre);
        System.out.println("Progreso: " + this.progreso + "/" + this.meta);
    }
}