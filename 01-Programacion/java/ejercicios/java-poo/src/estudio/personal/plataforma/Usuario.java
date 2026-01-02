package estudio.personal.plataforma;

import estudio.personal.contenido.Pelicula;

import java.time.LocalDateTime;

public class Usuario {
    private String nombre;
    private String email;
    private LocalDateTime fechaRegistro;
    private String contrasena;
    private int edad;
    private String genero;

    public void ver(Pelicula pelicula){
        System.out.println(nombre + " esta viendo...");
        pelicula.reproducir();
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public LocalDateTime getFechaRegistro() {
        return fechaRegistro;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
