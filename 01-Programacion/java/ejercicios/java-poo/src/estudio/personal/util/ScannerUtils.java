package estudio.personal.util;

import java.util.Scanner;

// En este ejercicio volveremos a utilizar la clase scanner para aprender a manejar
// metodos estaticos.
public class ScannerUtils {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static String capturarTexto(String mensaje){
        System.out.println(mensaje + ": ");
        return SCANNER.nextLine();
    }

    public static int capturarNumero(String mensaje){
        System.out.println(mensaje + ": ");

        int dato = SCANNER.nextInt();
        SCANNER.nextLine();
        return dato;

    }

    public static double capturarDecimal(String mensaje){
        System.out.println(mensaje + ": ");

        double dato = SCANNER.nextDouble();
        SCANNER.nextLine();
        return dato;

    }
}
