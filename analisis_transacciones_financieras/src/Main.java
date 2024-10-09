import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        Desarrolla un programa que lea un archivo CSV con un registro de transacciones
        financieras (fecha, descripción, monto).

        El programa debe generar un reporte que clasifique las transacciones por categoría
        (alimentación, transporte, etc.) y mostrar un balance mensual.
         */

        // Crea un objeto para leer el archivo
        File file = new File("transacciones.csv");
        FileReader fr = new FileReader(file);
    }
}

class Transaction {
    LocalDate fecha;
    String descripcion;
    double monto;
    String categoria;

    // Constructor
    public Transaction(LocalDate fecha, String descripcion, double monto, String categoria) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.monto = monto;
        this.categoria = categoria;
    }
}