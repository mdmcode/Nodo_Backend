import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Crea un programa que simule un cajero automático.
        Debe permitir al usuario iniciar sesión con un número de cuenta y un PIN.
        Luego, debe ofrecer opciones para
            - consultar el saldo
            - retirar dinero
            - depositar dinero
        Asegúrate de que las operaciones mantengan el saldo de la cuenta de manera consistente.
        */

        // Inicializamos el Scanner
        Scanner scanner = new Scanner(System.in);

        // Mostramos un mensaje de bienvenida
        System.out.println("Bienvenido al cajero automático");
        System.out.println("Inicie sesión para continuar");

        // Pedimos al usuario que ingrese su número de cuenta
        System.out.println("Ingrese su número de cuenta:");
        int numeroCuenta = scanner.nextInt();

        // Pedimos al usuario que ingrese su PIN
        System.out.println("Ingrese su PIN:");
        int pin = scanner.nextInt();

        // Creamos una nueva cuenta con el número de cuenta y el PIN ingresados
        CuentaCajeroAutomatic cuenta = new CuentaCajeroAutomatic(numeroCuenta, pin, 0);

        while (true) {
            System.out.println("Bienvenido a su cuenta");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Consultar saldo
                    CajeroObtenerSaldo cajeroObtenerSaldo = new CajeroObtenerSaldo();
                    cajeroObtenerSaldo.obtenerSaldo(cuenta);
                    break;
                case 2:
                    // Retirar dinero
                    System.out.println("Ingrese la cantidad a retirar:");
                    double cantidadRetirar = scanner.nextDouble();
                    CajeroRetirarDinero cajeroRetirarDinero = new CajeroRetirarDinero();
                    cajeroRetirarDinero.retirarDinero(cuenta, cantidadRetirar);
                    break;
                case 3:
                    // Depositar dinero
                    System.out.println("Ingrese la cantidad a depositar:");
                    double cantidadDepositar = scanner.nextDouble();
                    CajeroDepositarDinero cajeroDepositarDinero = new CajeroDepositarDinero();
                    cajeroDepositarDinero.depositarDinero(cuenta, cantidadDepositar);
                    break;
                case 4:
                    // Salir
                    System.out.println("Gracias por usar el cajero automático");
                    return;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        }
    }
}

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

class CajeroObtenerSaldo {
    public void obtenerSaldo(CuentaCajeroAutomatic cuenta) {
        // Devuelve el saldo de la cuenta
        System.out.println("Su saldo es: " + cuenta.saldo);
    }
}

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

class CajeroDepositarDinero {
    public void depositarDinero(CuentaCajeroAutomatic cuenta, double cantidad) {
        // Agrega la cantidad dada al saldo de la cuenta
        cuenta.saldo += cantidad;
        System.out.println("Depósito exitoso");
        System.out.println("Su saldo actual es: " + cuenta.saldo);
    }
}