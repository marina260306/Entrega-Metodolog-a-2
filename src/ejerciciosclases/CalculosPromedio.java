package ejerciciosclases;

// Definimos una excepción personalizada para los casos en los que el denominador es cero
class DivisorCeroException extends Exception {
    public DivisorCeroException(String message) {
        super(message);
    }
}

public class CalculosPromedio {

    // Método que realiza el cálculo del promedio de un conjunto de números
    public static double calcularPromedio(int[] numeros) throws DivisorCeroException {
        int suma = 0;
        for (int num : numeros) {
            suma += num;
        }

        // Si el conjunto está vacío (longitud cero), lanzamos una excepción
        if (numeros.length == 0) {
            throw new DivisorCeroException("Error: El conjunto de números está vacío, no se puede dividir por cero.");
        }

        // Calculamos el promedio
        return (double) suma / numeros.length;
    }

    // Método intermedio que llama a calcularPromedio y debe declarar throws DivisorCeroException
    public static void metodoB() throws DivisorCeroException {
        int[] numeros = {10, 20, 30, 40}; // Un conjunto de números para calcular el promedio
        System.out.println("Calculando el promedio en metodoB...");
        double promedio = calcularPromedio(numeros);
        System.out.println("Promedio en metodoB: " + promedio);
    }

    // Método intermedio que también llama a metodoB
    public static void metodoC() throws DivisorCeroException {
        System.out.println("Llamando a metodoB desde metodoC...");
        metodoB();
    }

    // Método principal que maneja la excepción
    public static void metodoA() {
        try {
            System.out.println("Iniciando calculo en metodoA...");
            metodoC(); // Llama a metodoC que a su vez llama a metodoB
        } catch (DivisorCeroException e) {
            // Aquí se captura la excepción y se maneja
            System.out.println("Excepción capturada en metodoA: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Llamamos al método principal para iniciar el proceso
        metodoA();
    }
}

