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