class CajeroDepositarDinero {
    public void depositarDinero(CuentaCajeroAutomatic cuenta, double cantidad) {
        // Agrega la cantidad dada al saldo de la cuenta
        cuenta.saldo += cantidad;
        System.out.println("Depósito exitoso");
        System.out.println("Su saldo actual es: " + cuenta.saldo);
    }
}