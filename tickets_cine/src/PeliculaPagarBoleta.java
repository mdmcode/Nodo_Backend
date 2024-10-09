import java.util.Scanner;

class PeliculaPagarBoleta {
    // Method para pagar la boleta
    public void pagarBoleta(Pelicula pelicula, String[] asientos) {
        int total = pelicula.precio * asientos.length;
        System.out.println("Total a pagar: " + total + "€");
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Desea pagar la boleta? (S/N)");
        String respuesta = scanner.nextLine();

        if (respuesta.equals("S")) {
            System.out.println("Pago exitoso.");
        } else {
            System.out.println("Transacción cancelada.");
        }
    }
}