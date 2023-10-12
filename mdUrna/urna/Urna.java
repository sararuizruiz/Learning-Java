package org.uma.mbd.mdUrna.urna;

import java.util.NoSuchElementException;
import java.util.Random;

public class Urna {
    static public enum ColorBola {Blanca, Negra};
    private static Random alea = new Random();
    
    private int blancas, negras;

    public Urna(int nBlancas, int nNegras) {
        if (nBlancas<0 || nNegras<0) {
            throw new IllegalArgumentException("No se puede crear una urna con un número negativo de bolas.");
        }
        blancas = nBlancas;
        negras = nNegras;
    }

    public int totalBolas() {
        return blancas + negras;
    }

    public ColorBola extraerBola() {
        int tot = totalBolas();
        if (tot <= 0)
            throw new NoSuchElementException("No se puede extraer ninguna bola porque la urna está vacía");
        ColorBola bolaSacada;
        int ran = alea.nextInt(tot);
        if (ran < blancas) {
            bolaSacada = ColorBola.Blanca;
            blancas--;
        } else {
            bolaSacada = ColorBola.Negra;
            negras--;
        }
        return bolaSacada;
    }

    public void ponerBlanca() {
        blancas++;
    }

    public void ponerNegra() {
        negras++;
    }

    @Override
    public String toString() {
        return "U(nBlancas : " + blancas + ", nNegras : " + negras + ")";
    }
}