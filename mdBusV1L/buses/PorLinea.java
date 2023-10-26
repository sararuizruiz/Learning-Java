package org.uma.mbd.mdBusV1L.buses;

public class PorLinea implements Criterio {

    private int cLinea;

    public PorLinea(int cl) {
        cLinea = cl;
    }

    public boolean esSeleccionable(Bus bus) {
        return bus.getCodLinea() == cLinea;
    }

    @Override
    public String toString() {
        return "Autobuses de la linea "+cLinea;
    }
    
}
