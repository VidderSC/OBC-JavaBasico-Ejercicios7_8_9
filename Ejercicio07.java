package ob.ejercicios_temas_7_8_9;

import java.util.ArrayList;

public class Ejercicio07 {

    public static void main(String[] args) {

        // 7 - Crea un ArrayList de tipo int
        ArrayList<Integer> lista = new ArrayList<>();

        // utilizando un bucle rellénalo con elementos 1..10.
        for (int i = 1; i < 11; i++) {
            lista.add(i);
        }

        // Con otro bucle, recórrelo y elimina los números pares.
        for (int i = 0; i < lista.size(); i++) {
             if (lista.get(i) % 2 == 0) {
                 lista.remove(i);
             }
        }

        // Por último, vuelve a recorrerlo y muestra el ArrayList final.
        for (Integer elemento : lista) {
            System.out.println(elemento);
        }

        // Si te atreves, puedes hacerlo en menos pasos, siempre y cuando cumplas el primer "for" de relleno.
        ArrayList<Integer> lista2 = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            if (i % 2 != 0) {
                lista2.add(i);
            }
        }

        for (Integer elemento : lista2) {
            System.out.println(elemento);
        }

    }

}
