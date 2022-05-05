package ob.ejercicios_temas_7_8_9;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

    /*
    10 - Sorpréndenos creando un programa de tu elección que utilice InputStream,
    PrintStream, excepciones, un HashMap y un ArrayList, LinkedList o array.
     */

public class Ejercicio10 {
    static ArrayList<Integer> opciones = new ArrayList<>();
    static int[] contador = new int[6];
    static String[] nombres = new String[3];
    static int[] edades = new int[3];
    static String archivo = "";
    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        System.out.println("""
                            Bienvenido a este mini programa de mi elección.
                            """);
        Menu();


    }

    private static void Menu() {

        boolean opcionValida = false;

        System.out.print("""
            1. Escribe 3 nombres.
            2. Introduce las edades.
            3. Imprime los nombres y las edades por pantalla.
            4. lee e imprime por pantalla un archivo de texto.
            5. Añade al final del archivo de texto del punto 4 los nombres y las edades.
            6. Imprime el archivo final.
            0. Salir.
            
            Introduce tu opción (0-6): """);

        try {
            while (!opcionValida) {
                int opcion = scanner.nextInt();
                if (opcion >= 0 && opcion <= 6) {
                    opcionValida = true;
                    if (opcion == 0) {
                        System.out.println("Me salgo.");
                        break;
                    }
                    if (opcion > 0 && opcion <= 6) {
                        opciones.add(opcion);
                        OpcionMenu(opcion);
                    }
                } else {
                    System.out.print("""
                        Opción incorrecta, inténtalo de nuevo usando un número del 0 al 6.
                        Introduce tu opción (0-6): """);
                }
            }
        } catch (Exception e) {
            System.out.println("Ha dado el error: " + e.getMessage());
            Wait();
            Menu();
        }
    }

    private static void OpcionMenu(int op) {
        if (ValidarOpcion(op)) {
            switch (op) {
                case 1 -> EscribeNombres();
                case 2 -> EscribeEdades();
                case 3 -> ImprimeNombreEdad();
                case 4 -> LeeArchivo();
                case 5 -> EscribeArchivo();
                case 6 -> ImprimeArchivo();
                default -> {
                }
            }
        }
        Menu();
    }

    private static void ImprimeArchivo() {
        try {
            System.out.println(new String(Files.readAllBytes(Path.of(archivo))));
        } catch (Exception e) {
            System.out.println("La ruta o fichero introducido no existe");
        }
        Wait();
    }

    private static void Wait() {
        System.out.print("Pulsa Intro para continuar...");
        try {
            System.in.read();
        } catch (IOException e) {
            System.out.println("Ha dado el error: " + e.getMessage());
        }
    }

    private static void EscribeArchivo() {
        byte[] datos;
        try {
            InputStream in = new FileInputStream(archivo);
            datos = in.readAllBytes();
            in.close();

            PrintStream writeFile = new PrintStream(archivo);
            writeFile.write(datos);
            writeFile.append('\n');
            for (int i = 0; i <= 2; i++) {
                writeFile.append(nombres[i]).append(' ').append(Integer.toString(edades[i])).append('\n');
            }
            writeFile.close();
        } catch (Exception e) {
            System.out.println("La ruta o fichero introducido no existe");
            Wait();
        }
    }

    private static void LeeArchivo() {
        System.out.println("Introduce la ruta completa del archivo a leer e imprimir por consola:");
        try {
            archivo = scanner.next();
            System.out.println(new String(Files.readAllBytes(Path.of(archivo))));
        } catch (Exception e) {
            System.out.println("La ruta o fichero introducido no existe");
        }
        Wait();
    }

    private static void ImprimeNombreEdad() {
        for (int i = 0; i <= 2; i++) {
            System.out.println("Nombre: " + nombres[i] + ", Edad: " + edades[i]);
        }
        Wait();
    }

    private static void EscribeEdades() {
        for (int i = 0; i <= 2; i++) {
            System.out.println("Introduce la edad de " + nombres[i] + ":" );
            edades[i] = scanner.nextInt();
        }
    }

    private static void EscribeNombres() {
        for (int i = 0; i <= 2; i++) {
            System.out.println("Introduce Nombre:");
            String nombre = scanner.next();
            nombres[i] = nombre;
        }
    }

    private static Boolean ValidarOpcion(int o) {
        int cont = 0;
        for (int opcion : opciones) {
            if (o == opcion) {
                cont++;
            }
        }
        int index = o - 1;
        contador[index] = cont;
        // Opción 1, que continue pero que avise que se van a sobreescribir los datos
        // Opción 2, que compruebe primero que 1 haya sido introducido.
        // Opción 3, que compruebe primero que 1 Y 2 han sido ya introducidos
        // Opción 4, que continue.
        // Opción 5, las opciones 1, 2 Y 4 han tenido que ser introducidas previamente.
        switch (o){
            case 1:
                if (contador[0] > 1) {
                    System.out.println("Vas a sobreescribir los datos introducidos previamente.");
                    return true;
                } else {
                    return true;
                }
            case 2:
                if (contador[0] == 0) {
                    System.out.println("Tienes que meter los nombres primero.");
                    Wait();
                    return false;
                } else {
                    System.out.println("Puede ser que sobreescribas las edades.");
                    return true;
                }

            case 3:
                if (contador[0] > 0 && contador[1] > 0) {
                    return true;
                } else {
                    System.out.println("Tienes que meter los nombres y las edades primero.");
                    Wait();
                    return false;
                }
            case 4:
            case 6:
                return true;
            case 5:
                if (contador[0] > 0 && contador[1] > 0 && contador[3] > 0) {
                    return true;
                } else {
                    System.out.println("Tienes que meter los nombres, las edades y seleccionar el archivo primero.");
                    Wait();
                    return false;
                }
            default: break;
        }
        return false;
    }

}
