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