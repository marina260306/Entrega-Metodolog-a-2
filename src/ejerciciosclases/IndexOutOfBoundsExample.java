package ejerciciosclases;

public class IndexOutOfBoundsExample {
    public static void main(String[] args) {
        int[] numbers= {1,2,3,4,5,6,7,8,9,10};

        try{
            System.out.println("Accediendo al índice 20: " + numbers[20]); //Este índice va a ser inválido
        } catch (IndexOutOfBoundsException ex) {
            System.err.println("Excepción capturada: " + ex.getMessage());
        } finally {
            System.out.println("Se va a finalizar la operación con arrays.\n");
        }
    }
}
