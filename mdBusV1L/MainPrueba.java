package org.uma.mbd.mdBusV1L;

import java.io.IOException;

import org.uma.mbd.mdBusV1L.buses.Servicio;

public class MainPrueba {

    public static void main(String[] args) throws IOException {
        Servicio mlg = new Servicio("Málaga");
        mlg.leeBuses("recursos/mdBusV1/buses.txt");
        System.out.println(mlg.getCiudad());
        System.out.println(mlg.getBuses());
    }
    
}
