package ejerciciosclases;

    // Clase que representa una cuenta bancaria
    class CuentaBancaria {

        private String numeroCuenta;
        private double saldo;

        public CuentaBancaria(String numeroCuenta, double saldo) {
            this.numeroCuenta = numeroCuenta;
            this.saldo = saldo;
        }

        // Método para depositar dinero en la cuenta
        public void depositar(double cantidad) {
            if (cantidad <= 0) {
                // Lanzamos una excepción si la cantidad es negativa o cero
                throw new IllegalArgumentException("La cantidad a depositar debe ser mayor que cero.");
            }
            this.saldo += cantidad;
            System.out.println("Depósito exitoso. Nuevo saldo: " + this.saldo);
        }

        // Método para retirar dinero de la cuenta
        public void retirar(double cantidad) {
            if (cantidad <= 0) {
                throw new IllegalArgumentException("La cantidad a retirar debe ser mayor que cero.");
            }
            if (this.saldo < cantidad) {
                // Si el saldo es insuficiente, lanzamos una excepción
                throw new IllegalArgumentException("Saldo insuficiente para realizar la operación.");
            }
            this.saldo -= cantidad;
            System.out.println("Retiro exitoso. Nuevo saldo: " + this.saldo);
        }
    }
