package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.Objects;

public class Persona implements Comparable<Persona> {

    private String nombre;
    private Persona amigo;

    public Persona(String n) {
        nombre = n;
    }

    public void setAmigo(Persona am) {
        amigo = am;
    }

    public String getNombre() {
        return nombre;
    }
    public Persona getAmigo() {
        return amigo;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Persona p
                && this.getNombre().equalsIgnoreCase(p.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nombre.toLowerCase());
    }

    @Override
    public int compareTo(Persona p) {
        return this.nombre.toLowerCase().compareTo(p.nombre.toLowerCase());
    } 

    @Override
    public String toString() {
        String st = nombre + " --> ";
        if (amigo==null) {
            st = st + "sin amigo";
        } else {
            st = st + amigo.nombre;
        }
        return  st;
    }
    
}
