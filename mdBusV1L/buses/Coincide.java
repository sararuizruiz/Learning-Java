package org.uma.mbd.mdBusV1L.buses;

public class Coincide implements Criterio {

    private Bus busCoincide;

    public Coincide(Bus b) {
        busCoincide = b;
    }

    public boolean esSeleccionable(Bus bus) {
        return bus.equals(busCoincide);
    }

    @Override
    public String toString() {
        return "Autobús "+busCoincide;
    }
    
}
