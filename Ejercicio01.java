package ob.ejercicios_temas_7_8_9;

public class Ejercicio01 {

    /*
    1 - Escribe el código que devuelva una cadena al revés.
    Por ejemplo, la cadena "hola mundo", debe retornar "odnum aloh".
    */

    public static void main(String[] args) {
        String texto = "Hola mundo!";
        String alReves = reverse(texto);
        System.out.println(alReves);
    }

    public static String reverse(String texto) {
        String devuelve = "";
        int contador = texto.length()-1;

        while (contador>=0){
            devuelve = devuelve + texto.charAt(contador);
            contador-=1;
        }

        return devuelve;
    }

}
