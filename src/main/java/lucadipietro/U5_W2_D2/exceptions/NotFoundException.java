package lucadipietro.U5_W2_D2.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id){
        super("Elemento con id " + id + " non trovato!");
    }
}
