package ejerciciosclases;

public class FactorialStackDemo {
        public static void main(String[] args) {
            int n = 5;
            System.out.println("Factorial de " + n + " es: " + factorial(n));
        }

        public static int factorial(int n) {
            System.out.println("Calculando factorial(" + n + ")");
            if (n == 0) {
                return 1;
            } else {
                int result = n * factorial(n - 1);
                System.out.println("Retornando factorial(" + n + ") = " + result);
                return result;
            }
        }

}



