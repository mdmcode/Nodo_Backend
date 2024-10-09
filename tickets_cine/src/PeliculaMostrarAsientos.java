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