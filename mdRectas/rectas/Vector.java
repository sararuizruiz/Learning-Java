package org.uma.mbd.mdRectas.rectas;

public class Vector {
    private Punto extremo;

    public Vector(Punto p1) {
        extremo = p1;
    }
    public Vector(Punto org, Punto ext) {
        extremo = new Punto(ext.getX() - org.getX(), ext.getY() - org.getY());
    }
    public Vector(double d1, double d2) {
        extremo = new Punto(d1, d2);
    }


    public double getComponenteX() {
        return extremo.getX();
    }
    public double getComponenteY() {
        return extremo.getY();
    }

    public Punto extremoDesde(Punto org) {
        Punto ext = new Punto(getComponenteX() + org.getX(), getComponenteY() + org.getY());
        return ext;
    }

    public double modulo() {
        return Math.sqrt( Math.pow(getComponenteX(), 2) + Math.pow(getComponenteY(), 2) );
    }

    public Vector ortogonal() {
        return new Vector( -getComponenteY(), getComponenteX());
    }

    public boolean paraleloA(Vector vct) {
        return (getComponenteX() * vct.getComponenteY()) == (getComponenteY() * vct.getComponenteX());
    }

    @Override
    public String toString() {
        return "V(" + getComponenteX() + "," + getComponenteY() + ")";
    }
}