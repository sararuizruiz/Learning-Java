package org.uma.mbd.mdAmigoInvisible.amigos;

public class AmigoException extends RuntimeException {
    public AmigoException() { super(); }
    
    public AmigoException(String msg) {
        super(msg);
    }
}
