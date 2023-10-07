package org.uma.mbd.mdJarras;

import org.uma.mbd.mdJarras.jarras.Jarra;
import org.uma.mbd.mdJarras.jarras.Mesa;

public class MainJarra {
    public static void main(String[] args) {

        /* Apartado 2 */
        Jarra j1 = new Jarra(7);
        Jarra j2 = new Jarra(5);
        j2.llena();
        j1.llenaDesde(j2);
        j2.llena();
        j1.llenaDesde(j2);
        j1.vacia();
        j1.llenaDesde(j2);
        j2.llena();
        j1.llenaDesde(j2);
        System.out.println("El resultado final del apartado 2 tras 8 operaciones es:");
        System.out.println("j1 "+j1);
        System.out.println("j2 "+ j2);

        /* Apartado 4 */
        Mesa m1 = new Mesa(7,5);
        m1.llenaB();
        m1.vuelcaBsobreA();
        m1.llenaB();
        m1.vuelcaBsobreA();
        m1.vaciaA();
        m1.vuelcaBsobreA();
        m1.llenaB();
        m1.vuelcaBsobreA();
        System.out.println("El resultado final del apartado 4 tras 8 operaciones es:");
        System.out.println("m1 "+m1);
    }
}
