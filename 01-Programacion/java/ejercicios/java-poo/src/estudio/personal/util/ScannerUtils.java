package estudio.personal.util;

import estudio.personal.contenido.Genero;

import javax.sound.midi.Soundbank;
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

        while (!SCANNER.hasNextInt()){
            System.out.println("Dato no aceptado." + mensaje + ": ");
            SCANNER.next();
        }

        int dato = SCANNER.nextInt();
        SCANNER.nextLine();
        return dato;

    }

    public static double capturarDecimal(String mensaje){
        System.out.println(mensaje + ": ");

        while (!SCANNER.hasNextDouble()){
            System.out.println("Dato no aceptado." + mensaje + ": ");
            SCANNER.next();
        }

        double dato = SCANNER.nextDouble();
        SCANNER.nextLine();
        return dato;

    }

    public static Genero capturarGenero(String mensaje){
        while (true){
            System.out.println(mensaje + ": ...OPCIONES...");
            for (Genero genero : Genero.values()){
                System.out.println("-" + genero.name());
            }

            System.out.println("¿Cual quieres? ");
            String entrada = SCANNER.nextLine();
            try {
                return Genero.valueOf(entrada.toUpperCase());
            }catch(IllegalArgumentException e){
                System.out.println("Genero no aceptado.");
            }
        }
    }
}
