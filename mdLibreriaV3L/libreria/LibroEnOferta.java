package org.uma.mbd.mdLibreriaV3L.libreria;

public class LibroEnOferta extends Libro {
    private double descuento;

    public LibroEnOferta(String autor, String titulo, double precioBase, double d) {
        super(autor, titulo, precioBase);
        descuento = d;
    }

    public double getDescuento() {
        return this.descuento;
    }

    @Override
    public double getPrecioFinal() {
        double pf = super.getPrecioFinal();
        return (pf - pf*descuento/100);
    }

    @Override
    public String toString() {
        return "(" + getAutor() + ";" + getTitulo() + ";" + getPrecioBase() + ";" + descuento + "%;"
        + (getPrecioBase() * (1-descuento/100)) + getIVA() + "%;" + getPrecioFinal() + ")" ;
    }

}
