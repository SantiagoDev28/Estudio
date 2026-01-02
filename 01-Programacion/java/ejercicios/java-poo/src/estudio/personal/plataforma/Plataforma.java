package estudio.personal.plataforma;

import estudio.personal.contenido.Pelicula;

import java.util.ArrayList;
import java.util.List;

// LSTAS.
public class Plataforma {
    private String nombre;
    private List<Pelicula> contenido; // Lista de peliculas.

    public Plataforma(String nombre){
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
    }

    public void agregar(Pelicula elemento){
        this.contenido.add(elemento);
    }

    public void mostrarTitulos(){
        // Este tipo de for mejorado se lee de la siguiente manera:
        // Para cada Pelicula llamada pelicula dentro de la coleccion contenido obtener su titulo.
        for (Pelicula pelicula : contenido){
            System.out.println(pelicula.getTitulo());
        }
    }

    public void eliminar(Pelicula elemento){
        this.contenido.remove(elemento);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pelicula> getContenido() {
        return contenido;
    }
}
