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

