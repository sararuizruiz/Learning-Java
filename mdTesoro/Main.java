package org.uma.mbd.mdTesoro;

import org.uma.mbd.mdTesoro.tesoro.Tesoro;

import org.uma.mbd.mdRectas.rectas.Punto;

public class Main {
    public static void main(String [] args) {
        if (args.length != 6) {
            throw new RuntimeException("Debes proporcionar como argumentos exactamente los 6 puntos que localizan a las palmeras!");
        }
        Punto p1 = new Punto(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        Punto p2 = new Punto(Double.parseDouble(args[2]), Double.parseDouble(args[3]));
        Punto p3 = new Punto(Double.parseDouble(args[4]), Double.parseDouble(args[5]));
        Tesoro tes = new Tesoro(p1, p2, p3);
        System.out.println("Si la palmera amarilla se encuentra en " +p1+ ", la palmera azul en " +p2+ " y la palmera rosa en " +p3+ " entonces el tesoro se encuentra en la posición: ");
        System.out.println(tes.getTesoro());
    }
}
