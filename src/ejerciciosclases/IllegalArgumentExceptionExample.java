package ejerciciosclases;

    public class IllegalArgumentExceptionExample {
        public static void validarEdad(int edad) {
            if (edad < 0) {
                throw new IllegalArgumentException("La edad no puede ser negativa.");
            }
            System.out.println("Edad válida: " + edad);
        }

        public static void main(String[] args) {
            try {
                validarEdad(-5); // Edad inválida
            } catch (IllegalArgumentException ex) {
                System.err.println("Excepción capturada: " + ex.getMessage());
            } finally {
                System.out.println("Finalizando validación de edad.\n");
            }
        }
    }
