package ob.ejercicios_temas_7_8_9;

import java.io.*;

public class Ejercicio09 {

    /*
    9 - Utilizando InputStream y PrintStream, crea una función que reciba dos parámetros:
    "fileIn" y "fileOut". La tarea de la función será realizar la copia del fichero
    dado en el parámetro "fileIn" al fichero dado en "fileOut".
     */

    public static void main(String[] args) {

        String fileIn = "S:/IdeaProjects/fichero1.txt";
        String fileOut = "S:/IdeaProjects/fichero2.txt";

        CopiaFicheros(fileIn, fileOut);

    }

    private static void CopiaFicheros(String fileIn, String fileOut) {
        byte[] datos;
        try {
            InputStream in = new FileInputStream(fileIn);
            datos = in.readAllBytes();
            in.close();

            PrintStream out = new PrintStream(fileOut);
            out.write(datos);
            out.close();

            System.out.println("¡Fichero copiado!");
        } catch (Exception e) {
            System.out.println("Ha dado el error: " + e.getMessage());
            }

    }
}
