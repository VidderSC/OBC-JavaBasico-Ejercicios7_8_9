package ob.ejercicios_temas_7_8_9;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

public class Ejercicios_2_3_4_5_6 {

    public static void main(String[] args) {
        System.out.println("Ejercicio 2:");
        // 2 - Crea un array unidimensional de Strings y recórrelo,
        // mostrando únicamente sus valores.
        arrayNombres();
        System.out.println();

        System.out.println("Ejercicio 3:");
        // 3 - Crea un array bidimensional de enteros y recórrelo,
        // mostrando la posición y el valor de cada elemento en ambas dimensiones.
        arrayBidi();
        System.out.println();

        System.out.println("Ejercicio 4:");
        // 4 - Crea un "Vector" del tipo de dato que prefieras, y añádele 5 elementos.
        // Elimina el 2o y 3er elemento y muestra el resultado final.
        vectores();
        System.out.println();

        System.out.println("Ejercicio 5:");
        // 5 - Indica cuál es el problema de utilizar un Vector con la capacidad por defecto
        // si tuviésemos 1000 elementos para ser añadidos al mismo.
        System.out.println("""
                Respuesta:\s
                El problema de los Vectores es que es una operación muy costosa,
                ya que duplica en memoria nuestro array para copiarlo a otro array más grande.
                Por defecto comienza por una capacidad de 10, y va doblando
                la capacidad del nuevo array antes de copiarlo.""");
        System.out.println();

        System.out.println("Ejercicio 6:");
        //6 - Crea un ArrayList de tipo String, con 4 elementos. Cópialo en una LinkedList.
        // Recorre ambos mostrando únicamente el valor de cada elemento.
        listaArray();



    }

    private static void arrayNombres() {
        String[] nombres = new String[]{"Nombre 1", "Nombre 2", "Nombre 3"};

        for (String nombre : nombres) {
            System.out.println(nombre);
        }
    }

    private static void arrayBidi() {
        int[][] numeros = new int[3][3];
        numeros[0][0] = 1;
        numeros[0][1] = 2;
        numeros[0][2] = 3;
        numeros[1][0] = 10;
        numeros[1][1] = 20;
        numeros[1][2] = 30;

        for (int i = 0; i < numeros.length-1; i++) {
            for (int j = 0; j < numeros.length; j++) {
                System.out.println("Posición [" + i + "] " + "[" + j + "] : " + numeros[i][j]);
            }
        }
    }

    private static void vectores(){
        Vector<String> vectorTexto = new Vector<>();
        vectorTexto.add("Valor 1");
        vectorTexto.add("Valor 2");
        vectorTexto.add("Valor 3");
        vectorTexto.add("Valor 4");
        vectorTexto.add("Valor 5");

        vectorTexto.remove(1);
        vectorTexto.remove(2);

        System.out.println(vectorTexto);
    }

    private static void listaArray() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Elemento 1");
        lista.add("Elemento 2");
        lista.add("Elemento 3");
        lista.add("Elemento 4");

        LinkedList<String> listaEnlazada = new LinkedList<>(lista);

        for (String elemento: lista) {
            System.out.println(elemento);
        }

        for (String elemento: listaEnlazada) {
            System.out.println(elemento);
        }



    }
}
