import java.util.Scanner;

public class criba {
    /**
     * Genera los números primos desde 1 hasta el número máximo especificado por el usuario.
     * Utiliza el algoritmo de la Criba de Eratóstenes.
     *
     * @param max el número máximo hasta el cual generar los números primos
     * @return un arreglo de números primos generados
     */
    public static int[] generarPrimos(int max) {
        if (max < 2) {
            return new int[0]; // Retorna un arreglo vacío si el número máximo es menor a 2
        }

        boolean[] esPrimo = new boolean[max + 1];
        for (int i = 0; i <= max; i++) {
            esPrimo[i] = true;
        }

        for (int i = 2; i * i <= max; i++) {
            if (esPrimo[i]) {
                for (int j = i * i; j <= max; j += i) {
                    esPrimo[j] = false; // Marca los múltiplos de i como no primos
                }
            }
        }

        int cuenta = 0;
        for (int i = 2; i <= max; i++) {
            if (esPrimo[i]) {
                cuenta++; // Cuenta la cantidad de números primos encontrados
            }
        }

        int[] primos = new int[cuenta];
        int index = 0;
        for (int i = 2; i <= max; i++) {
            if (esPrimo[i]) {
                primos[index++] = i; // Almacena los números primos en el arreglo
            }
        }

        return primos; // Retorna el arreglo de números primos
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Eratóstenes:");
        int dato = teclado.nextInt();
        int[] vector = generarPrimos(dato);

        System.out.println("\nVector de primos hasta: " + dato);
        for (int i = 0; i < vector.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(vector[i] + "\t");
        }
    }
}