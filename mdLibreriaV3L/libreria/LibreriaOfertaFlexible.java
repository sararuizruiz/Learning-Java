package org.uma.mbd.mdLibreriaV3L.libreria;

public class LibreriaOfertaFlexible extends Libreria {
    private OfertaFlex oferta;

    public LibreriaOfertaFlexible(OfertaFlex of) {
        oferta = of;
    }

    public void setOferta(OfertaFlex of) {
        oferta = of;
        for (Libro libro : libros) {
            addLibro(libro);
        }
    }

    public OfertaFlex getOferta() {
        return oferta;
    }

    @Override
    public void addLibro(String autor, String titulo, double precioBase) {
        Libro libro = new Libro(autor, titulo, precioBase);
        double descuento = oferta.getDescuento(libro);
        if (descuento>0)
            libro = new LibroEnOferta(autor, titulo, precioBase, descuento);
        addLibro(libro);
    }
}
