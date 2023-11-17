package org.uma.mbd.mdPartidos.partidos;

public class Partido {

    private String nombre;
    private int votos;

    public Partido(String nombre, int votos) {
        this.nombre = nombre;
        this.votos = votos;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getVotos() {
        return this.votos;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Partido part 
            && this.nombre.equalsIgnoreCase(part.nombre);
    }

    @Override
    public int hashCode() {
        return this.nombre.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return nombre + " : " + votos;
    }  
}
