package estudio.personal.util;

import estudio.personal.contenido.Contenido;
import estudio.personal.contenido.Genero;

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
        try {
            Files.writeString(Path.of(NOMBRE_ARCHIVO),
                    linea + System.lineSeparator(),
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
                if (datos.length == 5) {
                    String titulo = datos[0];
                    int duracion = Integer.parseInt(datos[1]);
                    Genero genero = Genero.valueOf(datos[2].toUpperCase());
                    double calificacion = datos[3].isBlank() ? 0 : Double.parseDouble(datos[3]);
                    LocalDate fechaEstreno = LocalDate.parse(datos[4]);

                    Contenido contenido = new Contenido(titulo, duracion, genero, calificacion);

                    contenido.setFechaDeEstreno(fechaEstreno);
                    contenidoDesdeArchivo.add(contenido);

                }
            });

        } catch (IOException e) {
            System.out.println("No se encontro el archivo." + e.getMessage());
        }
        return contenidoDesdeArchivo;
    }
}