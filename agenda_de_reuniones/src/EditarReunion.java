import java.time.LocalDate;
import java.time.LocalTime;

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