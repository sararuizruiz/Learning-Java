package org.uma.mbd.mdTesoro.tesoro;

import org.uma.mbd.mdRectas.rectas.Punto;
import org.uma.mbd.mdRectas.rectas.Vector;

public class Tesoro {
    private Punto pAmarilla, pAzul, pRosa, eAmarilla, eAzul, tesoro;

    public Tesoro(Punto pAm, Punto pAz, Punto pR ) {
        pAmarilla = pAm;
        pAzul = pAz;
        pRosa = pR;
        this.calculaPosiciones();
    }

    private void calculaPosiciones() {
        eAmarilla = getEstacaAmarilla();
        eAzul = getEstacaAzul();
        tesoro = getTesoro();
    }

    public void setPalmeraAmarrilla(Punto p) {
        pAmarilla = p;
        this.calculaPosiciones();
    }
    public void setPalmeraAzul(Punto p) {
        pAzul = p;
        this.calculaPosiciones();
    }
    public void setPalmeraRosa(Punto p) {
        pRosa = p;
        this.calculaPosiciones();
    }

    public Punto getEstacaAmarilla() {
        Vector v1 = new Vector(pRosa, pAmarilla);
        Vector v2 = v1.ortogonal();
        Punto p = v2.extremoDesde(pAmarilla);
        return p;
    }
    public Punto getEstacaAzul() {
        Vector v1 = new Vector(pRosa, pAzul);
        Vector v2 = new Vector(v1.getComponenteY(), -v1.getComponenteX());
        Punto p = v2.extremoDesde(pAzul);
        return p;
    }
    public Punto getTesoro() {
        double xTesoro = (eAmarilla.getX() + eAzul.getX()) / 2;
        double yTesoro = (eAmarilla.getY() + eAzul.getY()) / 2;
        return new Punto(xTesoro, yTesoro);
    }
}
