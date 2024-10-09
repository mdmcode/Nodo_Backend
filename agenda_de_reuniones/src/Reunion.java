import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

class Reunion {
    String nombre;
    LocalDate fecha;
    LocalTime horaInicio;
    LocalTime horaFin;
    ArrayList<String> participantes;

    // Constructor
    public Reunion(String nombre, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        this.nombre = nombre;
        this.fecha = fecha;

        // Verificamos si la reunión se solapa con otra
        if (Main.estaSolapado(fecha, horaInicio, horaFin)) {
            System.out.println("Error: La reunión se solapa con otra");
            return;
        }

        // Asignamos los valores a los atributos
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.participantes = new ArrayList<>();
        Main.reuniones.add(this);
    }
}