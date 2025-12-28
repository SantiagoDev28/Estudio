package estudio.personal.contenido;

import java.time.LocalDate;

// Creamos la clase pelicula con cada uno de sus atributos.
public class Pelicula {
    // ATRIBUTOS
    public String titulo;
    public String descripcion;
    public int duracion;
    public String genero;
    public double calificacion;
    public LocalDate fechaDeEstreno;
    public boolean disponible;

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
}
