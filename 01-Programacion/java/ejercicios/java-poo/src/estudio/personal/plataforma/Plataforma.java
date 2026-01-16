package estudio.personal.plataforma;

import estudio.personal.contenido.Contenido;
import estudio.personal.contenido.Genero;
import estudio.personal.contenido.ResumenContenido;
import estudio.personal.excepcion.ContenidoExistenteException;
import estudio.personal.util.FileUtils;

import java.util.*;

// LSTAS.
public class Plataforma {
    private String nombre;
    private List<Contenido> contenido; // Lista de peliculas.  Relacion: Agregacion
    // Esta lista de contenidos pueden estar fuera de la plataforma, no depende de la clase.
    private Map<Contenido, Integer> visualizaciones;

    public Plataforma(String nombre){
        this.nombre = nombre;
        this.contenido = new ArrayList<>();
        this.visualizaciones = new HashMap<>();
    }

    public void agregar(Contenido elemento){
        Contenido contenido = this.buscarPorTitulo(elemento.getTitulo());

        if (contenido != null){
            throw new ContenidoExistenteException(elemento.getTitulo());
        }

        FileUtils.escribirContenido(elemento);
        this.contenido.add(elemento);
    }

    public void reproducir(Contenido contenido){
        int conteoActual = visualizaciones.getOrDefault(contenido, 0);
        System.out.println(contenido.getTitulo() + " ha sido reproducido " +  conteoActual + " veces");

        this.contarReproducciones(contenido);
        contenido.reproducir();
    }

    private void contarReproducciones(Contenido contenido){
        int conteoActual = visualizaciones.getOrDefault(contenido, 0);
        visualizaciones.put(contenido,conteoActual + 1);
    }


    public void eliminar(Contenido elemento) {
        this.contenido.remove(elemento);
    }

    public Contenido buscarPorTitulo(String titulo){
        return contenido.stream()
                .filter(contenido -> contenido.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public List<Contenido> buscarPorGenero(Genero genero){
        return contenido.stream()
                .filter(contenido -> contenido.getGenero().equals(genero))
                .toList();
    }

    public List<String> getTitulos(){
        // Este tipo de for mejorado se lee de la siguiente manera:
        // Para cada Contenido llamada pelicula dentro de la coleccion contenido obtener su titulo.
//        for (Contenido pelicula : contenido){
//            System.out.println(pelicula.getTitulo());
//        }

        // Con forEach
        // Lambda
        return contenido.stream()
                .map(Contenido::getTitulo)
                .toList();

    }

    public List<ResumenContenido> getResumenes(){
        return contenido.stream()
                .map(c -> new ResumenContenido(c.getTitulo(), c.getDuracion(), c.getGenero()))
                .toList();
    }

    public int getDuracionTotal(){
       return contenido.stream()
                .mapToInt(Contenido::getDuracion)
               .sum();
    }

    public List<Contenido> getPopulares(int cantidad){
        return contenido.stream()
                .sorted(Comparator.comparing(Contenido::getCalificacion).reversed())
                .limit(cantidad)
                .toList();
    }

    public List<Contenido> getMuyPopulares(){
        return contenido.stream()
                .filter(Contenido::esPopular)
                .toList();
    }

    public Contenido getMasCorta(){
        return contenido.stream().min(Comparator.comparingInt(Contenido::getDuracion))
                .orElse(null);
    }

    public Contenido getMasLarga(){
        return contenido.stream()
                .max(Comparator.comparingInt(Contenido::getDuracion))
                .orElse(null);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Contenido> getContenido() {
        return contenido;
    }
}
