package org.uma.mbd.mdLibreriaV3L.libreria;

public class Libro {
    private String autor;
    private String titulo;
    private double precioBase;
    private static double IVA = 10;

    public Libro(String au, String tit, double precio) {
        autor = au;
        titulo = tit;
        precioBase = precio;
    }

    public String getAutor() {return autor;}
    public String getTitulo() {return titulo;}
    public double getPrecioBase() {return precioBase;}
    public double getPrecioFinal() {
        return precioBase + (precioBase * IVA / 100);
    }
    public static double getIVA() {return IVA;}
    public static void setIVA(double num) {IVA = num;}

    @Override public String toString() {
        return "(" + autor + ";" + titulo + ";" + precioBase + ";" + IVA + ";" + getPrecioFinal() + ")" ;
    }
}
