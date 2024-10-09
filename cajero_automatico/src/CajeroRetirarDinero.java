class CajeroRetirarDinero {
    public void retirarDinero(CuentaCajeroAutomatic cuenta, double cantidad) {
        // Le quita la cantidad dada al saldo de la cuenta siempre y cuando haya suficiente saldo
        if (cuenta.saldo >= cantidad) {
            cuenta.saldo -= cantidad;
            System.out.println("Retiro exitoso");
            System.out.println("Su saldo actual es: " + cuenta.saldo);
        } else {
            // Si no hay suficiente saldo, muestra un mensaje de error
            System.out.println("Saldo insuficiente");
        }
    }
}