package estudio.personal.contenido;

public class Documental extends Contenido implements Promocionable{
    private String narrador;

    public Documental(String titulo, int duracion, Genero genero, double calificacion, String narrador) {
        super(titulo, duracion, genero, calificacion);
        this.narrador = narrador;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo el documental " + getTitulo() + " narrad@ por " + getNarrador());

    }

    public String getNarrador() {
        return narrador;
    }


    @Override
    public String promocionar() {
        return "Descubre el documental " + getTitulo() + " narrado por " + getNarrador() ;
    }
}
