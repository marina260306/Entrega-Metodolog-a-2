package ejerciciosclases;

import java.io.*;

public class IOExceptionExample { // 🔹 Renombramos la clase para evitar conflicto con java.io.IOException
    public static void main(String[] args) {
        File file = new File("archivo_no_existente.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            System.out.println("El archivo se ha abierto correctamente.");
        } catch (FileNotFoundException ex) {  // 🔹 Capturamos FileNotFoundException primero
            System.err.println("Error: El archivo no fue encontrado.");
        } catch (IOException ex) {  // 🔹 Capturamos IOException para otros errores de E/S
            System.err.println("Error de entrada/salida.");
        } finally {
            System.out.println("Se ha finalizado la operación de lectura de archivo.\n");
        }
    }
}

