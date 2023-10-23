package org.uma.mbd.mdLibreriaV3L.libreria;

import java.util.Arrays;

public class OfertaAutor implements OfertaFlex {
    private double descuento;
    private String [] autoresEnOferta;

    public OfertaAutor(double des, String [] aeo) {
        descuento = des;
        autoresEnOferta = aeo;
    }

    @Override
    public double getDescuento(Libro libro) {
        double des = 0;
        if (autorEnOferta(libro.getAutor()))
            des = descuento;
        return des;
    }

    private boolean autorEnOferta(String autor) {
        int pos = 0;
        while (pos < autoresEnOferta.length && !autoresEnOferta[pos].equalsIgnoreCase(autor))
            pos++;
        return pos < autoresEnOferta.length;
    }

    @Override 
    public String toString() {
        return descuento + "%" + Arrays.toString(autoresEnOferta);
    }
    
}
