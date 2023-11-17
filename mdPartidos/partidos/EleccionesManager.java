package org.uma.mbd.mdPartidos.partidos;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class EleccionesManager {
    
    private String[] datos;
    private int numEsc;
    private CriterioSeleccion cs;
    private Elecciones elecciones;
    private String fEntrada;
    private String fSalida;
    private boolean consola;

    public EleccionesManager(Elecciones elecciones) {
        this.elecciones = elecciones;
    }

    public EleccionesManager setDatos(String[] datos) {
        this.datos = datos;
        return this;
    }

    public EleccionesManager setCriterioSeleccion(CriterioSeleccion cs) {
        this.cs = cs;
        return this;
    }

    public EleccionesManager setEntrada(String fEntrada) {
        this.fEntrada = fEntrada;
        return this;
    }

    public EleccionesManager setSalida(String fSalida) {
        this.fSalida = fSalida;
        return this;
    }

    public EleccionesManager setConsola(boolean consola) {
        this.consola = consola;
        return this;
    }

    public EleccionesManager setNumEsc(int numEsc) {
        this.numEsc = numEsc;
        return this;
    }

    private void verify() {
        if (!(datos==null ^ fEntrada==null))
            throw new EleccionesException("Debe haber una y sólo una entrada de datos");
        if (cs==null)
            throw new EleccionesException("No hay criterio de selección");
        if (numEsc <= 0)
            throw new EleccionesException("El número de escaños a repartir debe ser positivo");
        if (fSalida==null && !consola) 
            throw new EleccionesException("Debe haber al menos una salida especificada (o por fichero o por consola)");
    }

    public void build() throws IOException {
        this.verify();
        if (datos!=null) {
            this.elecciones.leeDatos(datos);
        } else {
            this.elecciones.leeDatos(fEntrada);
        }
        Map<Partido, Integer> map = this.elecciones.generaResultados(cs, numEsc);
        if (fSalida!=null) 
            this.elecciones.presentaResultados(fSalida, map);
        if (consola)
            this.elecciones.presentaResultados(new PrintWriter(System.out, true), map);
    }

}
