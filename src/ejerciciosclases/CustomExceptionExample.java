package ejerciciosclases;

class MyCustomException extends Exception {
        public MyCustomException(String message) {
            super(message);
        }
    }
public class CustomExceptionExample {
    public static void verificarNumero(int numero) throws MyCustomException {
        if (numero < 10) {
            throw new MyCustomException("Número demasiado bajo: " + numero);
        }
        System.out.println("Número aceptado: " + numero);
    }

    public static void main(String[] args) {
        try {
            verificarNumero(5); // Lanza la excepción personalizada
        } catch (MyCustomException ex) {
            System.err.println("Excepción capturada: " + ex.getMessage());
        } finally {
            System.out.println("Finalizando verificación de número.\n");
        }
    }
}
