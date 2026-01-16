package estudio.personal.excepcion;

public class ContenidoExistenteException extends RuntimeException{
    public ContenidoExistenteException(String titulo){
        super("El contenido " + titulo + " ya existe");
    }
}
