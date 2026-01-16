package estudio.personal;
// Nombre del paquete utilizado.
// Servira para agrupar clases relacionadas.

import estudio.personal.contenido.Genero;
import estudio.personal.contenido.Pelicula;
import estudio.personal.contenido.ResumenContenido;
import estudio.personal.excepcion.PeliculaExistenteException;
import estudio.personal.plataforma.Plataforma;
import estudio.personal.plataforma.Usuario;
import estudio.personal.util.FileUtils;
import estudio.personal.util.ScannerUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

// A partir del dia 5 se borro el contenido anterior para crear una nueva version del proyecto.
// Aca aplico todo lo antes visto de manera mas organizada y estructurada.

// Clase principal que correra nuestro codigo.
public class Main {
    // Constantes en Java.
    public static final String VERSION = "1.0.0";
    public static final String NOMBRE_PLATAFORMA = "PeList";
    public static final int AGREGAR = 1;
    public static final int MOSTRAR_TODO = 2;
    public static final int BUSCAR_POR_TITULO = 3;
    public static final int BUSCAR_POR_GENERO = 4;
    public static final int VER_POPULARES= 5;
    public static final int REPRODUCIR = 6;
    public static final int VER_MUY_POPULARES = 0;
    public static final int CONTENIDO_LARGO = 7;
    public static final int CONTENIDO_CORTO = 8;
    public static final int ELIMINAR = 9;
    public static final int SALIR = 10;

    public static void main(String[] args) {
        // sout que sirve para mostrar mensajes por consola.
        System.out.println(NOMBRE_PLATAFORMA + " V " + VERSION);

        Plataforma plataforma = new Plataforma(NOMBRE_PLATAFORMA);

        cargarPeliculas(plataforma);

        System.out.println("Mas de " + plataforma.getDuracionTotal() + " minutos de contenido! \n");


        while (true) {
            int opcionElegida = ScannerUtils.capturarNumero("""
                       Ingresa una de las siguientes opciones: 
                        1. Agregar contenido.
                        2. Mostrar todo.
                        3. Buscar por titulos. 
                        4. Buscar por genero.
                        5. Ver populares.
                        6. Ver muy populares.
                        7. Contenido mas largo.
                        8. Contenido mas corto.
                        9. Eliminar contenido.
                        10. Salir de la plataforma.
                    """);
            System.out.println("Opcion elegida: " + opcionElegida);

            switch (opcionElegida) {
                case AGREGAR -> {
                    String nombre = ScannerUtils.capturarTexto("Cual es el nombre del contenido");
                    Genero genero = ScannerUtils.capturarGenero("Genero del contenido");
                    int duracion = ScannerUtils.capturarNumero("Duracion del contenido");
                    double calificacion = ScannerUtils.capturarDecimal("Calificacion del contenido");

                    try{
                        plataforma.agregar(new Pelicula(nombre, duracion, genero, calificacion));
                    }catch (PeliculaExistenteException e){
                        System.out.println(e.getMessage());
                    }
                }
                case MOSTRAR_TODO -> {
                    List<ResumenContenido> contenidos = plataforma.getResumenes();
                    contenidos.forEach(resumen -> System.out.println(resumen.titulo()));
                }

                case BUSCAR_POR_TITULO -> {
                    String nombreBuscado = ScannerUtils.capturarTexto("Nombre de la pelicula a buscar");
                    Pelicula pelicula = plataforma.buscarPorTitulo(nombreBuscado);

                    if (pelicula != null){
                        System.out.println(pelicula.obtenerFichaTecnica());
                    }else{
                        System.out.println(nombreBuscado + " no existe dentro de " + NOMBRE_PLATAFORMA);
                    }
                }

                case BUSCAR_POR_GENERO -> {
                    Genero generoBuscado = ScannerUtils.capturarGenero("Genero a buscar: ");
                    List<Pelicula> busquedaPorGenero = plataforma.buscarPorGenero(generoBuscado);
                    System.out.println(busquedaPorGenero.size() + " encontrados para el genero " + generoBuscado);
                    busquedaPorGenero.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }

                case VER_POPULARES -> {
                    int cantidad = ScannerUtils.capturarNumero("Cantidad de contenido popular a mostrar: ");
                    List<Pelicula> contenidoPopular = plataforma.getPopulares(cantidad);
                    contenidoPopular.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }

                case REPRODUCIR -> {
                    String nombre = ScannerUtils.capturarTexto("Nombre del contenido a reproducir");
                    Pelicula contenido = plataforma.buscarPorTitulo(nombre);

                    if (contenido != null){
                        plataforma.reproducir(contenido);
                    }else{
                        System.out.println(nombre + " no exite dentro de " + NOMBRE_PLATAFORMA);
                    }
                }

                case VER_MUY_POPULARES -> {
                    List<Pelicula> masPopulares = plataforma.getMuyPopulares();
                    masPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }

                case CONTENIDO_LARGO -> {
                    Pelicula peliculaLarga = plataforma.getMasLarga();
                    System.out.println("La pelicula mas larga es " + peliculaLarga.obtenerFichaTecnica() + "\n");
                    System.out.println("con una duracion de: " + peliculaLarga.getDuracion() + " minutos \n");
                }

                case CONTENIDO_CORTO -> {
                    Pelicula peliculaCorta = plataforma.getMasCorta();
                    System.out.println("La pelicula mas corta es " + peliculaCorta.obtenerFichaTecnica() + "\n");
                    System.out.println("con una duracion de: " + peliculaCorta.getDuracion() + " minutos \n");
                }

                case ELIMINAR -> {
                    String peliculaAEliminar = ScannerUtils.capturarTexto("Escribe el nombre de la pelicula que quieres eliminar: ");
                    Pelicula obtenerPelicula = plataforma.buscarPorTitulo(peliculaAEliminar);

                    if (obtenerPelicula != null){
                        System.out.println(obtenerPelicula.getTitulo() + " Eliminada con exito");
                        plataforma.eliminar(obtenerPelicula);
                    }else {
                        System.out.println(peliculaAEliminar + " No existe dentro de " + plataforma.getNombre());
                    }
                }

                case SALIR -> System.exit(0);
            }
        }

    }

    private static void cargarPeliculas(Plataforma plataforma) {
        plataforma.getContenido().addAll(FileUtils.leerContenido());
    }

}


