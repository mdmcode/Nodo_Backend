import java.time.Duration;
import java.util.ArrayList;
import java.time.LocalTime;
import java.time.LocalDate;

public class Main {
    public static LocalTime horaPrueba = LocalTime.of(14, 30);
    static ArrayList<Reunion> reuniones = new ArrayList<>();
    public static ArrayList<LocalTime> horasInicio = new ArrayList<>();
    public static ArrayList<LocalTime> horasFin = new ArrayList<>();

    public static void main(String[] args) {
        /*
        Implementa una aplicación para agendar reuniones.
        Los usuarios pueden:
            - Crear
            - Editar
            - Eliminar
            - Agregar participantes

        El programa debe asegurarse de que no haya solapamientos de horarios
        entre reuniones y debe enviar recordatorios (simulados con mensajes en la consola)
        antes de la reunión.
         */

        // Creamos un arreglo para guardar las reuniones y sus horarios para verificar que no se solapen
        for (Reunion reunion : reuniones) {
            horasInicio.add(reunion.horaInicio);
            horasFin.add(reunion.horaFin);
        }

        // Pruebas
        Reunion reunion1 = new Reunion("Reunion 1", LocalDate.of(2021, 10, 10), LocalTime.of(10, 0), LocalTime.of(11, 0));
        Reunion reunion2 = new Reunion("Reunion 2", LocalDate.of(2021, 10, 10), LocalTime.of(11, 0), LocalTime.of(12, 0));
        Reunion reunion3 = new Reunion("Reunion 3", LocalDate.of(2021, 10, 10), LocalTime.of(12, 0), LocalTime.of(13, 0));

        // Agregar esta reunion debería dar error porque se solapa con la anterior
        Reunion reunion4 = new Reunion("Reunion 4", LocalDate.of(2021, 10, 10), LocalTime.of(12, 0), LocalTime.of(13, 0));

        // Mostramos las reuniones en su estado original por consola
        System.out.println("Reuniones en su estado original:");
        mostrarReuniones();

        // Agregar participantes
        AgregarParticipante agregarParticipante = new AgregarParticipante();
        agregarParticipante.agregarParticipante(reunion1, "Juan");
        agregarParticipante.agregarParticipante(reunion1, "Pedro");
        agregarParticipante.agregarParticipante(reunion1, "Maria");

        // Editar reunión
        EditarReunion editarReunion = new EditarReunion();
        editarReunion.editarNombre(reunion1, "Primera Reunion");
        editarReunion.editarFecha(reunion3, LocalDate.now());
        editarReunion.editarHoraInicio(reunion1, LocalTime.of(14, 0));
        editarReunion.editarHoraFin(reunion1, LocalTime.of(15, 0));

        // Eliminar reunión
        EliminarReunion eliminarReunion = new EliminarReunion();
        eliminarReunion.eliminarReunion(reuniones, reunion2);

        // Mostrar recordatorio
        MostrarRecordatorio mostrarRecordatorio = new MostrarRecordatorio();
        mostrarRecordatorio.mostrarRecordatorio(reunion1);

        // Mostramos las reuniones después de las modificaciones
        System.out.println("\nReuniones después de las modificaciones:");
        mostrarReuniones();
    }

    static void mostrarReuniones() {
        for (Reunion reunion : reuniones) {
            System.out.println(reunion.nombre);
            System.out.println(reunion.fecha);
            System.out.println(reunion.horaInicio);
            System.out.println(reunion.horaFin);
            System.out.println(reunion.participantes);
        }
    }

    // Esta function verifica si una reunion se solapa con otra
    public static boolean estaSolapado(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        for (Reunion reunion : reuniones) {
            // Si están en la misma fecha y la hora de inicio o fin es la misma entonces se solapan
            if (reunion.fecha.equals(fecha)) {
                if (reunion.horaInicio.equals(horaInicio) || reunion.horaFin.equals(horaFin)) {
                    return true;
                }
            }
        }

        // Si los tiempos pasan el filtro no se solapan
        return false;
    }
}

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

class EditarReunion {
    // Edita el nombre de la reunión
    public void editarNombre(Reunion reunion, String nombre) {
        reunion.nombre = nombre;
    }

    // Edita la fecha de la reunión
    public void editarFecha(Reunion reunion, LocalDate fecha) {
        reunion.fecha = fecha;
    }

    // Edita la hora de inicio de la reunión
    public void editarHoraInicio(Reunion reunion, LocalTime horaInicio) {
        reunion.horaInicio = horaInicio;
    }

    // Edita la hora de fin de la reunión
    public void editarHoraFin(Reunion reunion, LocalTime horaFin) {
        reunion.horaFin = horaFin;
    }
}

class AgregarParticipante {
    // Agrega participante al arreglo de participantes de la reunión
    public void agregarParticipante(Reunion reunion, String participante) {
        reunion.participantes.add(participante);
    }
}

class EliminarReunion {
    // Elimina la reunion de la agenda
    public void eliminarReunion(ArrayList<Reunion> reuniones, Reunion reunion) {
        reuniones.remove(reunion);
    }
}

class MostrarRecordatorio {
    public void mostrarRecordatorio(Reunion reunion) {
        // Muestra el recordatorio si faltan 30 minutos o menos para la reunión
        if (Duration.between(Main.horaPrueba, reunion.horaInicio).toMinutes() <= 30) {
            System.out.println("Recordatorio: La reunión " + reunion.nombre + " está por comenzar");
        }
    }
}