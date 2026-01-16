package estudio.personal.contenido;

public class Documental extends Contenido {
    private String narrador;

    public Documental(String titulo, int duracion, Genero genero, double calificacion, String narrador) {
        super(titulo, duracion, genero, calificacion);
        this.narrador = narrador;
    }

    public String getNarrador() {
        return narrador;
    }
}
