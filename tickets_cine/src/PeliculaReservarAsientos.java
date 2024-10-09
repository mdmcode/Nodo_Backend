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