package estudio.personal;
// Nombre del paquete utilizado.
// Servira para agrupar clases relacionadas.

import java.util.Scanner;
// Clase que permite leer datos desde la consola.

// Clase principal que correra nuestro codigo.
public class Main {
    public static void main(String[] args) {
        // sout que sirve para mostrar mensajes por consola.
        System.out.println("Estudio Personal ");

        // definimos un nuevo objeto de la clase scanner para recibir datos desde la terminal con el parametro system.in
        Scanner scanner = new Scanner(System.in);


        System.out.println("Ingresa tu nombre completo");

        // Variable para guardar una linea de texto.
        String nombre = scanner.nextLine();

        // Concatenamos variables y lineas de texto.
        System.out.println("Hola " + nombre + "Esta es tu primera practica con java");

        System.out.println(nombre + "Cuantos años tienes?");

        // Variable que guarda numero enteros ingresados por consola.
        int edad = scanner.nextInt();

        System.out.println(nombre + "Tu edad es " + edad);


    }
}
