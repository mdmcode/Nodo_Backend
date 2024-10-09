class CuentaCajeroAutomatic {
    // Atributos
    int numeroCuenta;
    int pin;
    double saldo;

    // Constructor
    public CuentaCajeroAutomatic(int numeroCuenta, int pin, double saldo) {
        // Inicializamos los atributos con los valores pasados como argumentos
        this.numeroCuenta = numeroCuenta;
        this.pin = pin;
        this.saldo = saldo;
    }
}