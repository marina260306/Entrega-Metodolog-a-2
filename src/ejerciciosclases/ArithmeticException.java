package ejerciciosclases;

public class ArithmeticException extends Throwable {
    public static void main(String[] args) {
        int a= 10, b=0;
        try{
            System.out.println("El resultado es:"+ (a/b));// División por cero
        } catch (java.lang.ArithmeticException ex){
            System.out.println("Excepción capturada: "+ex.getMessage());
        } finally{
            System.out.println("Se va a finalizar la operación matemática. \n");
        }
    }
}
