package ejerciciosclases;

public class Banco {
    public static void main(String[] args) {
        // Creamos una cuenta bancaria con un saldo inicial de 500.0
        CuentaBancaria cuenta = new CuentaBancaria("987654", 500.0);

        // Intentamos realizar varias operaciones
        try {
            // Intentamos depositar una cantidad negativa (esto lanzará una excepción)
            cuenta.depositar(-200.0);
        } catch (IllegalArgumentException e) {
            // Capturamos la excepción lanzada por la validación
            System.out.println("Error al depositar: " + e.getMessage());
        }

        // Intentamos realizar un depósito correcto
        try {
            cuenta.depositar(300.0);  // Este depósito debería ser exitoso
        } catch (IllegalArgumentException e) {
            System.out.println("Error al depositar: " + e.getMessage());
        }

        // Intentamos realizar un retiro exitoso
        try {
            cuenta.retirar(200.0);  // Este retiro debería ser exitoso
        } catch (IllegalArgumentException e) {
            System.out.println("Error al retirar: " + e.getMessage());
        }

        // Intentamos realizar un retiro con saldo insuficiente
        try {
            cuenta.retirar(1000.0);  // Esto lanzará una excepción
        } catch (IllegalArgumentException e) {
            System.out.println("Error al retirar: " + e.getMessage());
        }
    }
}




