package ejerciciosclases;

public class SistemaBancario3 {

    // Definimos una excepción verificada para el caso de saldo insuficiente
    static class SaldoInsuficienteException extends Exception {
        public SaldoInsuficienteException(String message) {
            super(message);
        }
    }

    // Definimos una excepción no verificada para cuentas no encontradas
    static class CuentaNoEncontradaException extends RuntimeException {
        public CuentaNoEncontradaException(String message) {
            super(message);
        }
    }

    // Simulamos un error grave en el sistema (Error)
    static class ErrorSistemaLimiteCuentas extends Error {
        public ErrorSistemaLimiteCuentas(String message) {
            super(message);
        }
    }

    // Clase que representa una cuenta bancaria
    static class CuentaBancaria {
        private String numeroCuenta;
        private double saldo;

        public CuentaBancaria(String numeroCuenta, double saldo) {
            this.numeroCuenta = numeroCuenta;
            this.saldo = saldo;
        }

        public String getNumeroCuenta() {
            return numeroCuenta;
        }

        public double getSaldo() {
            return saldo;
        }

        public void depositar(double cantidad) {
            if (cantidad < 0) {
                throw new IllegalArgumentException("La cantidad a depositar debe ser positiva.");
            }
            this.saldo += cantidad;
        }

        public void retirar(double cantidad) throws SaldoInsuficienteException {
            if (cantidad < 0) {
                throw new IllegalArgumentException("La cantidad a retirar debe ser positiva.");
            }
            if (this.saldo < cantidad) {
                throw new SaldoInsuficienteException("No hay suficiente saldo en la cuenta.");
            }
            this.saldo -= cantidad;
        }
    }

    // Clase que simula el sistema de gestión de cuentas bancarias
    public static class SistemaBancarioManager {
        private static final int MAX_CUENTAS = 1000;  // Límite máximo de cuentas
        private static int cantidadCuentas = 0;  // Contador de cuentas creadas
        private static CuentaBancaria[] cuentas = new CuentaBancaria[MAX_CUENTAS];

        // Método para crear una nueva cuenta bancaria
        public static CuentaBancaria crearCuenta(String numeroCuenta, double saldoInicial) {
            if (cantidadCuentas >= MAX_CUENTAS) {
                throw new ErrorSistemaLimiteCuentas("Error grave del sistema: Se alcanzó el límite de cuentas bancarias.");
            }
            CuentaBancaria cuenta = new CuentaBancaria(numeroCuenta, saldoInicial);
            cuentas[cantidadCuentas++] = cuenta;
            return cuenta;
        }

        // Método para buscar una cuenta por su número
        public static CuentaBancaria buscarCuenta(String numeroCuenta) {
            for (int i = 0; i < cantidadCuentas; i++) {
                if (cuentas[i].getNumeroCuenta().equals(numeroCuenta)) {
                    return cuentas[i];
                }
            }
            throw new CuentaNoEncontradaException("Cuenta no encontrada con el número: " + numeroCuenta);
        }

        // Método para realizar una transferencia de una cuenta a otra
        public static void transferir(String cuentaOrigen, String cuentaDestino, double cantidad) {
            try {
                CuentaBancaria origen = buscarCuenta(cuentaOrigen);
                CuentaBancaria destino = buscarCuenta(cuentaDestino);

                origen.retirar(cantidad);
                destino.depositar(cantidad);

                System.out.println("Transferencia realizada de " + cantidad + " desde " + cuentaOrigen + " a " + cuentaDestino);

            } catch (CuentaNoEncontradaException e) {
                System.out.println("Excepción capturada: " + e.getMessage());
            } catch (SaldoInsuficienteException e) {
                System.out.println("Excepción capturada: " + e.getMessage());
            } catch (ErrorSistemaLimiteCuentas e) {
                System.out.println("Error capturado: " + e.getMessage());
            }
        }

        public static void main(String[] args) {
            // Intentamos crear algunas cuentas
            try {
                CuentaBancaria cuenta1 = crearCuenta("12345", 1000.0);
                System.out.println("Cuenta 1 creada con saldo inicial de 1000.0");

                CuentaBancaria cuenta2 = crearCuenta("67890", 500.0);
                System.out.println("Cuenta 2 creada con saldo inicial de 500.0");

                // Intentamos realizar una transferencia exitosa
                transferir("12345", "67890", 200.0);  // Transferencia válida

                // Intentamos realizar una transferencia con saldo insuficiente
                transferir("12345", "67890", 1500.0);  // Esto lanzará una SaldoInsuficienteException

                // Intentamos realizar una transferencia a una cuenta no encontrada
                transferir("12345", "00000", 100.0);  // Esto lanzará una CuentaNoEncontradaException

                // Intentamos crear más cuentas hasta superar el límite
                for (int i = 0; i < 999; i++) {
                    crearCuenta("Cuenta" + (i + 3), 0);
                }
                // Intentamos crear una cuenta que superaría el límite
                crearCuenta("1001", 0);  // Esto lanzará un ErrorSistemaLimiteCuentas

            } catch (ErrorSistemaLimiteCuentas e) {
                System.out.println("Error capturado: " + e.getMessage());
            }
        }
    }
}

