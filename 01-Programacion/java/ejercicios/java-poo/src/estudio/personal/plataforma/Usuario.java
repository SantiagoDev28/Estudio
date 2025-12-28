package estudio.personal.plataforma;

import estudio.personal.contenido.Pelicula;

import java.time.LocalDateTime;

public class Usuario {
    public String nombre;
    public String email;
    public LocalDateTime fechaRegistro;
    public String contrasena;
    public int edad;
    public String genero;

    public void ver(Pelicula pelicula){
        System.out.println(nombre + " esta viendo...");
        pelicula.reproducir();
    }
}
