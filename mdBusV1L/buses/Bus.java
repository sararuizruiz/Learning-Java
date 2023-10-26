package org.uma.mbd.mdBusV1L.buses;

import java.util.Objects;

public class Bus {

    private int codBus;
    private String matricula;
    private int codLinea;

    public Bus(int cb, String mat) {
        codBus = cb;
        matricula = mat;
    }

    public void setCodLinea(int codLinea) {
        this.codLinea = codLinea;
    }

    public int getCodBus() {
        return this.codBus;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public int getCodLinea() {
        return this.codLinea;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Bus bus 
            && this.codBus == bus.codBus
            && this.matricula.equalsIgnoreCase(bus.matricula);
    } 

    @Override
    public int hashCode() {
        return Objects.hash(codBus, matricula.toLowerCase());
    }

   @Override
   public String toString() {
    return "Bus("+codBus+","+matricula+","+codLinea+")";
   } 
    
}
