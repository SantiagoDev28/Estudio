package estudio.personal.util;

import estudio.personal.contenido.Contenido;
import estudio.personal.contenido.Documental;
import estudio.personal.contenido.Genero;
import estudio.personal.contenido.Pelicula;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static final String NOMBRE_ARCHIVO = "contenido.txt";
    public static final String SEPARADOR = "|";

    public static void escribirContenido(Contenido contenido){
        String linea = String.join(SEPARADOR,
                contenido.getTitulo(),
                String.valueOf(contenido.getDuracion()),
                contenido.getGenero().name(),
                String.valueOf(contenido.getCalificacion()),
                contenido.getFechaDeEstreno().toString()
                );

        String lineaFinal;

        if (contenido instanceof Documental documental){
            lineaFinal = "DOCUMENTAL" + SEPARADOR + linea + SEPARADOR + documental.getNarrador();
        }else{
            lineaFinal = "PELICULA" + SEPARADOR + linea;
        }
        try {
            Files.writeString(Path.of(NOMBRE_ARCHIVO),
                    lineaFinal + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND);
        }catch (IOException e){
            System.out.println("Error al escribir en el archivo." + e.getMessage());
        }
    }
    public static List<Contenido> leerContenido(){
        List<Contenido> contenidoDesdeArchivo = new ArrayList<>();

        try {
            List<String> lineas = Files.readAllLines(Path.of(NOMBRE_ARCHIVO));

            lineas.forEach(linea -> {
                String[] datos = linea.split("\\" + SEPARADOR);
                String tipoContenido = datos[0];

                if (("PELICULA".equals(tipoContenido) && datos.length == 6) || ("DOCUMENTAL".equals(tipoContenido) && datos.length==7)) {
                    String titulo = datos[1];
                    int duracion = Integer.parseInt(datos[2]);
                    Genero genero = Genero.valueOf(datos[3].toUpperCase());
                    double calificacion = datos[4].isBlank() ? 0 : Double.parseDouble(datos[4]);
                    LocalDate fechaEstreno = LocalDate.parse(datos[5]);

                    Contenido contenido;

                    if ("PELICULA".equals(tipoContenido)){
                        contenido = new Pelicula(titulo, duracion, genero, calificacion);
                        contenido.setFechaDeEstreno(fechaEstreno);
                    }else{
                        String narrador = datos[6];
                        contenido = new Documental(titulo,duracion,genero,calificacion,narrador);
                    }


                    contenidoDesdeArchivo.add(contenido);

                }
            });

        } catch (IOException e) {
            System.out.println("No se encontro el archivo." + e.getMessage());
        }
        return contenidoDesdeArchivo;
    }
}