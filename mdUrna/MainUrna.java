package org.uma.mbd.mdUrna;

import org.uma.mbd.mdUrna.urna.Urna;

public class MainUrna {
    public static void main(String [] args){
        if (args.length != 2)
            throw new RuntimeException("Debe introducir exactamente dos números como argumentos, el primero será el número de bolas Blancas y el segundo el número de bolas negras.");
        int nB = Integer.parseInt(args[0]);
        int nN = Integer.parseInt(args[1]);
        Urna urna = new Urna(nB, nN);

        while (urna.totalBolas() > 1) {
            Urna.ColorBola cBola1 = urna.extraerBola();
            Urna.ColorBola cBola2 = urna.extraerBola();
            if (cBola1 == cBola2) {
                urna.ponerBlanca();
            } else {
                urna.ponerNegra();
            }
        }
        Urna.ColorBola cFinal = urna.extraerBola();
        System.out.println(cFinal);
    } 

    /* Análisis de los resultados:
     * El color de la bola final depende únicamente de la paridad del número de bolas negras iniciales que pasamos como argumento.
     * Si el número de bolas negras iniciales es par   ---> La bola final será de color blanca
     * Si el número de bolas negras iniciales es impar ---> La bola final será de color negra
     * 
     * Explicación:
     * 
     * Extraigo bolas de dos en dos, si son de dif color, he sacado una negra pero vuelvo a meter una negra,
     *      luego el num de bolas negras se mantiene CONSTANTE (y por lo tanto su paridad).
     *      Si en cambio las bolas son del mismo color, o bien saco dos blancas y vuelvo a meter una blanca
     *      (num Bolas negras se mantiene constante y por lo tanto su paridad), o bien saco dos negras y vuelvo a meter 
     *      una blanca, por lo que el num de bolas negras pasa a ser dos menos 
     *      (PERO lo importante, la PARIDAD sigue siendo la misma)
     * 
     * Por ello, independientemente del comienzo, NUNCA cambiará la paridad del número de bolas negras.
     * Si comienza siendo par, siempre será par y nunca podrá ser 1. La bola devuelta que se queda sola tiene que ser blanca.
     * Si comienza siendo impar, siempre será impar y acabará siendo 1. La bola devuelta será negra.
     */
}
