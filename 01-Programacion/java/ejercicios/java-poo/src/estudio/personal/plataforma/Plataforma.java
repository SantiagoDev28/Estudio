package estudio.personal.plataforma;

import estudio.personal.contenido.Genero;
import estudio.personal.contenido.Pelicula;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// LSTAS.
public class Plataforma {
    private String nombre;
    private List<Pelicula> contenido; // Lista de peliculas.  Relacion: Agregacion
    // Esta lista de contenidos pueden estar fuera de la plataforma, no depende de la clase.

    public Plataforma(String nombre){
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
    }

    public void agregar(Pelicula elemento){
        this.contenido.add(elemento);
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
