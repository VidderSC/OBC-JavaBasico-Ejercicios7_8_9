package ob.ejercicios_temas_7_8_9;

public class Ejercicio08 {

    /*
    8 - Crea una función DividePorCero. Esta, debe generar una excepción ("throws")
    a su llamante del tipo ArithmeticException que será capturada por su llamante
    (desde "main", por ejemplo).
    Si se dispara la excepción, mostraremos el mensaje "Esto no puede hacerse".
    Finalmente, mostraremos en cualquier caso: "Demo de código".
     */

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;

        try {
            System.out.println(DividePorCero(num1, num2));
        } catch (ArithmeticException e) {
            System.out.println("Esto no puede hacerse");
        } finally {
            System.out.println("Demo de código");
        }
    }

    private static int DividePorCero(int num1, int num2) throws ArithmeticException {
        return (num1 / num2);
    }


}
