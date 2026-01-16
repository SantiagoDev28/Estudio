package estudio.personal.plataforma;

import estudio.personal.contenido.Genero;
import estudio.personal.contenido.Pelicula;
import estudio.personal.contenido.ResumenContenido;
import estudio.personal.excepcion.PeliculaExistenteException;
import estudio.personal.util.FileUtils;

import java.io.File;
import java.util.*;

// LSTAS.
public class Plataforma {
    private String nombre;
    private List<Pelicula> contenido; // Lista de peliculas.  Relacion: Agregacion
    // Esta lista de contenidos pueden estar fuera de la plataforma, no depende de la clase.
    private Map<Pelicula, Integer> visualizaciones;

    public Plataforma(String nombre){
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
        this.visualizaciones = new HashMap<>();
    }

    public void agregar(Pelicula elemento){
        Pelicula contenido = this.buscarPorTitulo(elemento.getTitulo());

        if (contenido != null){
            throw new PeliculaExistenteException(elemento.getTitulo());
        }

        FileUtils.escribirContenido(elemento);
        this.contenido.add(elemento);
    }

    public void reproducir(Pelicula contenido){
        int conteoActual = visualizaciones.getOrDefault(contenido, 0);
        System.out.println(contenido.getTitulo() + " ha sido reproducido " +  conteoActual + " veces");

        this.contarReproducciones(contenido);
        contenido.reproducir();
    }

    private void contarReproducciones(Pelicula contenido){
        int conteoActual = visualizaciones.getOrDefault(contenido, 0);
        visualizaciones.put(contenido,conteoActual + 1);
    }


    public void eliminar(Pelicula elemento) {
        this.contenido.remove(elemento);
    }

    public Pelicula buscarPorTitulo(String titulo){
        return contenido.stream()
                .filter(contenido -> contenido.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public List<Pelicula> buscarPorGenero(Genero genero){
        return contenido.stream()
                .filter(contenido -> contenido.getGenero().equals(genero))
                .toList();
    }

    public List<String> getTitulos(){
        // Este tipo de for mejorado se lee de la siguiente manera:
        // Para cada Pelicula llamada pelicula dentro de la coleccion contenido obtener su titulo.
//        for (Pelicula pelicula : contenido){
//            System.out.println(pelicula.getTitulo());
//        }

        // Con forEach
        // Lambda
        return contenido.stream()
                .map(Pelicula::getTitulo)
                .toList();

    }

    public List<ResumenContenido> getResumenes(){
        return contenido.stream()
                .map(c -> new ResumenContenido(c.getTitulo(), c.getDuracion(), c.getGenero()))
                .toList();
    }

    public int getDuracionTotal(){
       return contenido.stream()
                .mapToInt(Pelicula::getDuracion)
               .sum();
    }

    public List<Pelicula> getPopulares(int cantidad){
        return contenido.stream()
                .sorted(Comparator.comparing(Pelicula::getCalificacion).reversed())
                .limit(cantidad)
                .toList();
    }

    public List<Pelicula> getMuyPopulares(){
        return contenido.stream()
                .filter(Pelicula::esPopular)
                .toList();
    }

    public Pelicula getMasCorta(){
        return contenido.stream().min(Comparator.comparingInt(Pelicula::getDuracion))
                .orElse(null);
    }

    public Pelicula getMasLarga(){
        return contenido.stream()
                .max(Comparator.comparingInt(Pelicula::getDuracion))
                .orElse(null);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pelicula> getContenido() {
        return contenido;
    }
}
