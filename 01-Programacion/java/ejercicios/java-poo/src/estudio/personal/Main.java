package estudio.personal;
// Nombre del paquete utilizado.
// Servira para agrupar clases relacionadas.

import estudio.personal.contenido.*;
import estudio.personal.excepcion.ContenidoExistenteException;
import estudio.personal.plataforma.Plataforma;
import estudio.personal.util.FileUtils;
import estudio.personal.util.ScannerUtils;

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
    public static final int BUSCAR_POR_TIPO= 7;
    public static final int VER_MUY_POPULARES = 0;
    public static final int CONTENIDO_LARGO = 11;
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
                        6. Reproducir.
                        7. Buscar por tipo.
                        6. Ver muy populares.
                        7. Contenido mas largo.
                        8. Contenido mas corto.
                        9. Eliminar contenido.
                        10. Salir de la plataforma.
                    """);
            System.out.println("Opcion elegida: " + opcionElegida);

            switch (opcionElegida) {
                case AGREGAR -> {
                    int tipoDeContenido = ScannerUtils.capturarNumero("Que tipo de contenido quieres agregar? \n 1. Pelicula \n 2. Documental");
                    String nombre = ScannerUtils.capturarTexto("Cual es el nombre del contenido");
                    Genero genero = ScannerUtils.capturarGenero("Genero del contenido");
                    int duracion = ScannerUtils.capturarNumero("Duracion del contenido");
                    double calificacion = ScannerUtils.capturarDecimal("Calificacion del contenido");

                    try{
                        if (tipoDeContenido == 1 ){
                            plataforma.agregar(new Pelicula(nombre, duracion, genero, calificacion));
                        }else{
                            String narrador = ScannerUtils.capturarTexto("Narrador del documental");
                            plataforma.agregar(new Documental(nombre, duracion, genero, calificacion, narrador));
                        }
                    }catch (ContenidoExistenteException e){
                        System.out.println(e.getMessage());
                    }
                }
                case MOSTRAR_TODO -> {
                    List<ResumenContenido> contenidos = plataforma.getResumenes();
                    contenidos.forEach(resumen -> System.out.println(resumen.titulo()));
                }

                case BUSCAR_POR_TITULO -> {
                    String nombreBuscado = ScannerUtils.capturarTexto("Nombre de la contenido a buscar");
                    Contenido contenido = plataforma.buscarPorTitulo(nombreBuscado);

                    if (contenido != null){
                        System.out.println(contenido.obtenerFichaTecnica());
                    }else{
                        System.out.println(nombreBuscado + " no existe dentro de " + NOMBRE_PLATAFORMA);
                    }
                }

                case BUSCAR_POR_GENERO -> {
                    Genero generoBuscado = ScannerUtils.capturarGenero("Genero a buscar: ");
                    List<Contenido> busquedaPorGenero = plataforma.buscarPorGenero(generoBuscado);
                    System.out.println(busquedaPorGenero.size() + " encontrados para el genero " + generoBuscado);
                    busquedaPorGenero.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }

                case VER_POPULARES -> {
                    int cantidad = ScannerUtils.capturarNumero("Cantidad de contenido popular a mostrar: ");
                    List<Contenido> contenidoPopular = plataforma.getPopulares(cantidad);
                    contenidoPopular.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }

                case REPRODUCIR -> {
                    String nombre = ScannerUtils.capturarTexto("Nombre del contenido a reproducir");
                    Contenido contenido = plataforma.buscarPorTitulo(nombre);

                    if (contenido != null){
                        plataforma.reproducir(contenido);
                    }else{
                        System.out.println(nombre + " no exite dentro de " + NOMBRE_PLATAFORMA);
                    }
                }

                case BUSCAR_POR_TIPO -> {
                    int tipoContenido = ScannerUtils.capturarNumero("Que tipo de contenido quieres buscar? \n 1. Peliculas \n 2. Documentales");
                    if (tipoContenido == 1 ){
                        List<Pelicula> peliculas = plataforma.getPeliculas();
                        peliculas.forEach(pelicula -> System.out.println(pelicula.obtenerFichaTecnica()+"\n"));
                    }else {
                        List<Documental> documentales = plataforma.getDocumentales();
                        documentales.forEach(documental -> System.out.println(documental.obtenerFichaTecnica()+ "\n"));
                    }
                }

                case VER_MUY_POPULARES -> {
                    List<Contenido> masPopulares = plataforma.getMuyPopulares();
                    masPopulares.forEach(contenido -> System.out.println(contenido.obtenerFichaTecnica() + "\n"));
                }

                case CONTENIDO_LARGO -> {
                    Contenido contenidoLarga = plataforma.getMasLarga();
                    System.out.println("La pelicula mas larga es " + contenidoLarga.obtenerFichaTecnica() + "\n");
                    System.out.println("con una duracion de: " + contenidoLarga.getDuracion() + " minutos \n");
                }

                case CONTENIDO_CORTO -> {
                    Contenido contenidoCorta = plataforma.getMasCorta();
                    System.out.println("La pelicula mas corta es " + contenidoCorta.obtenerFichaTecnica() + "\n");
                    System.out.println("con una duracion de: " + contenidoCorta.getDuracion() + " minutos \n");
                }

                case ELIMINAR -> {
                    String peliculaAEliminar = ScannerUtils.capturarTexto("Escribe el nombre de la pelicula que quieres eliminar: ");
                    Contenido obtenerContenido = plataforma.buscarPorTitulo(peliculaAEliminar);

                    if (obtenerContenido != null){
                        System.out.println(obtenerContenido.getTitulo() + " Eliminada con exito");
                        plataforma.eliminar(obtenerContenido);
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


