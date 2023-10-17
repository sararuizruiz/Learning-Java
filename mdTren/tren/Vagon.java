package org.uma.mbd.mdTren.tren;

public class Vagon {
    private int capacidad, carga;

    public Vagon(int cap) {
        capacidad = cap; // esta variable es la capacidad que puede todavía almacenar el vagón, por ello cambia a lo largo del programa.
        carga = 0;
    }

    public int carga(int ton) {
        int sobra = 0;
        if (ton >= capacidad){
            sobra = ton - capacidad;
            carga += capacidad;
            capacidad = 0;
        } else {
            carga += ton;
            capacidad -= ton;
        }
        return sobra;
    }

    public int descarga(int ton) {
        int sobra = 0;
        if (ton >= carga){
            sobra = ton - carga;
            capacidad += carga;
            carga = 0;
        } else {
            capacidad += ton;
            carga -= ton;
        }
        return sobra;
    }


    public int getCapacidad() {
        return capacidad;
    }

    public int getCarga() {
        return carga;
    }

    @Override
    public String toString() {
        int capTotal = carga+capacidad;
        return "V(" + carga + "/" + capTotal + ")";
    }
    
}
