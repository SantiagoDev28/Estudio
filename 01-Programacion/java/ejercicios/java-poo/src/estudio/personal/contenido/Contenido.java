package estudio.personal.contenido;

import java.time.LocalDate;

// Creamos la clase pelicula con cada uno de sus atributos.
public class Contenido {
    // ATRIBUTOS
    // Una buena practica es mantener los atributos de las clases privados por defecto.
    private String titulo;
    private String descripcion;
    private int duracion;
    private Genero genero;
    private double calificacion;
    private LocalDate fechaDeEstreno;
    private boolean disponible;

    // CONSTRUCTOR
    // Se debe crear despues de los atributos como buena practica.
    public Contenido(String titulo, int duracion, Genero genero){
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.fechaDeEstreno = LocalDate.now();

    }

    public Contenido(String titulo, int duracion, Genero genero, double calificacion) {
        this(titulo,duracion,genero);
        this.calificar(calificacion);
    }

    // METODOS
    public void reproducir(){
        System.out.println("Reproduciendo " + titulo);
    }

    public String obtenerFichaTecnica(){
            return titulo + " (" + fechaDeEstreno.getYear() + ")\n" +
                    "Genero: " + genero + "\n" +
                    "Calificación: " + calificacion + "/5";
    }

    public void calificar(double calificacion){
        if (calificacion >= 0 && calificacion <= 5){
            this.calificacion = calificacion;
        }
    }

    public boolean esPopular(){
        return calificacion >= 4;
    }


    // GETTERS Y SETTERS
    // Es considerada una buena practica mantenerlos al final de la clase.

    // Metodo encargado de obtener el valor almacenado en el atributo titulo.
    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public Genero getGenero() {
        return genero;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public LocalDate getFechaDeEstreno() {
        return fechaDeEstreno;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setFechaDeEstreno(LocalDate fechaDeEstreno) {
        this.fechaDeEstreno = fechaDeEstreno;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
