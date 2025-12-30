package estudio.personal;
// Nombre del paquete utilizado.
// Servira para agrupar clases relacionadas.

import estudio.personal.contenido.Pelicula;
import estudio.personal.plataforma.Usuario;
import estudio.personal.util.ScannerUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;
// Clase que permite leer datos desde la consola.

// Clase principal que correra nuestro codigo.
public class Main {
    // Constantes en Java.
    public static final String VERSION = "1.0.0";
    public static final String NOMBRE_PLATAFORMA = "PeList";

    public static void main(String[] args) {
        // sout que sirve para mostrar mensajes por consola.
        System.out.println( NOMBRE_PLATAFORMA + " V " + VERSION);

        // CLASE 2 = Implementando metodos estaticos.
        String nombre = ScannerUtils.capturarTexto("Cual es el nombre del contenido");
        String genero = ScannerUtils.capturarTexto("Genero del contenido");
        int duracion = ScannerUtils.capturarNumero("Duracion del contenido");
        double calificacion = ScannerUtils.capturarDecimal("Calificacion del contenido");

        // EJERCICIO #2 = Uso de la clase Pelicula 
        Pelicula pelicula = new Pelicula(nombre , duracion , genero, calificacion);
//        pelicula.titulo = nombre;
//        pelicula.duracion = duracion;
//        pelicula.fechaDeEstreno = LocalDate.of(2018,10,15);
//        pelicula.genero = genero;


        System.out.println(pelicula.obtenerFichaTecnica());

//        // Casting Implicito
//        long duracionLong = pelicula.duracion;
//        System.out.println("Duracion Long: "+ duracionLong);
//        System.out.println(pelicula.obtenerFichaTecnica());
//
//        // Casting explicito
//        int calificacionInt = (int) pelicula.calificacion;
//        System.out.println("La calificacion es: " + calificacionInt);
//        Long numeroDePremios = Long.parseLong("25");
//        System.out.println("La cantidad de premios es: " + numeroDePremios);

        // EJERCICIO #3 = Uso de la clase Usuario
        Usuario usuario = new Usuario();

        usuario.nombre = "Santiago";

        // Uso de datos por referencia (LocalDate)
        usuario.fechaRegistro = LocalDateTime.now();

        System.out.println(usuario.fechaRegistro);
        usuario.ver(pelicula);



//        // EJERCICIO #1 = Uso de la clase Scanner
//        // definimos un nuevo objeto de la clase scanner para recibir datos desde la terminal con el parametro system.in
//        Scanner scanner = new Scanner(System.in);
//
//
//        System.out.println("Ingresa tu nombre completo");
//
//        // Variable para guardar una linea de texto.
//        String nombre = scanner.nextLine();
//
//        // Concatenamos variables y lineas de texto.
//        System.out.println("Hola " + nombre + "Esta es tu primera practica con java");
//
//        System.out.println(nombre + "Cuantos años tienes?");
//
//        // Variable que guarda numero enteros ingresados por consola.
//        int edad = scanner.nextInt();
//
//        System.out.println(nombre + "Tu edad es " + edad);



    }
}
