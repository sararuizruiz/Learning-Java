package org.uma.mbd.mdRectas.rectas;

public class Recta {
    private Vector direccion;
    private Punto pto;

    public Recta(Vector v, Punto p) {
        direccion = v;
        pto = p;
    }
    public Recta(Punto p1, Punto p2) {
        this(new Vector(p1, p2), p1);
    }

    private static double determinante(double a11, double a12, double a21, double a22) {
        return a11*a22 - a12*a21;
    }

    public double distanciaDesde(Punto p) {
        Recta rp = this.perpendicularPor(p);
        Punto inters = this.interseccionCon(rp);
        return inters.distancia(p);
    }

    static record Implicita(double a, double b, double c){};
    private Implicita implicita() {
        double a0 = direccion.getComponenteY();
        double b0 = - direccion.getComponenteX();
        double c0 = direccion.getComponenteX() * pto.getY() - direccion.getComponenteY() * pto.getX();
        Implicita imp = new Implicita(a0,b0,c0);
        return imp;
    }

    public Punto interseccionCon(Recta r) {
        if (this.paralelaA(r)) { // Caso en el que el denominador es cero
            throw new RuntimeException("Rectas paralelas");
        }
        Implicita imp1 = this.implicita();
        Implicita imp2 = r.implicita();
        double d = determinante(imp1.a, imp1.b, imp2.a, imp2.b);
        double x = determinante(-imp1.c, imp1.b, -imp2.c, imp2.b) / d;
        double y = determinante(imp1.a, -imp1.c, imp2.a, -imp2.c) / d;
        return new Punto(x,y);
    }

    public boolean paralelaA(Recta r) {
        return direccion.paraleloA(r.direccion);
    }

    public Recta paralelaPor(Punto p) {
        return new Recta(this.direccion, p);
    }

    public boolean pasaPor(Punto p) {
        return direccion.paraleloA(new Vector(p, pto));
    }

    public Recta perpendicularPor(Punto p) {
        return new Recta(this.direccion.ortogonal(), p);
    }

    @Override
    public String toString() {
        return "R(" + direccion + "," + pto + ")";
    }

}