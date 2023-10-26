package org.uma.mbd.mdBusV1L.buses;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.io.PrintWriter;

public class Servicio {

    private String ciudad;
    private List<Bus> buses;

    public Servicio(String c) {
        ciudad = c;
        buses = new ArrayList<>();
    }

    public String getCiudad() {
        return this.ciudad;
    }

    public List<Bus> getBuses() {
        return this.buses;
    }

    public void leeBuses(String file) throws IOException {
        Path path = Path.of(file);
        try (Scanner scLinea = new Scanner(path)) {
            while (scLinea.hasNextLine()) {
                String linea = scLinea.nextLine();
                try (Scanner scDato = new Scanner(linea)) {
                    scDato.useDelimiter("[,]+");
                    int cb = scDato.nextInt();
                    String mat = scDato.next();
                    int cl = scDato.nextInt();
                    Bus bus = new Bus(cb, mat);
                    bus.setCodLinea(cl);
                    buses.add(bus);
                } catch (InputMismatchException e) {
                    System.err.println("Error por datos incorrectos en la línea del fichero :" + linea);
                } catch (NoSuchElementException e) {
                    System.err.println("Error por falta de datos en la línea del fichero :" + linea);
                }
            }
        }

    }

    public List<Bus> filtra(Criterio criterio) {
        return buses.stream().filter(bus -> criterio.esSeleccionable(bus)).toList();
    }

    public void guarda(String file, Criterio criterio) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(file)) {
            this.guarda(pw, criterio);
        }
    }

    public void guarda(PrintWriter pw, Criterio criterio) {
        pw.println(criterio);
        for (Bus bus: buses) {
            if (criterio.esSeleccionable(bus))
                pw.println(bus);
        }

    }
    
}
