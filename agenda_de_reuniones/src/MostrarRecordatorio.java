import java.time.Duration;

class MostrarRecordatorio {
    public void mostrarRecordatorio(Reunion reunion) {
        // Muestra el recordatorio si faltan 30 minutos o menos para la reunión
        if (Duration.between(Main.horaPrueba, reunion.horaInicio).toMinutes() <= 30) {
            System.out.println("Recordatorio: La reunión " + reunion.nombre + " está por comenzar");
        }
    }
}