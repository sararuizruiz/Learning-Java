package org.uma.mbd.mdPartidos.partidos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Elecciones {

    private List<Partido> partidos;

    static private Partido stringToPartido(String dato) {
        try (Scanner sc = new Scanner(dato)) {
            sc.useDelimiter("[,]+");
            String nombre = sc.next();
            int votos = sc.nextInt();
            Partido partido = new Partido(nombre, votos);
            return partido;
        } catch (InputMismatchException e) {
            throw new EleccionesException("Error por datos incorrectos en: "+dato);
        } catch (NoSuchElementException e) {
            throw new EleccionesException("Error por falta de datos en: " + dato);
        }
    }

    public void leeDatos(String[] datos) {
        partidos = Stream.of(datos).map(Elecciones::stringToPartido).toList();
    }

    public void leeDatos(String nombreFichero) throws IOException {
        partidos = new ArrayList<>();
        Path path = Path.of(nombreFichero);
        try (Scanner scLinea = new Scanner(path)) {
            while (scLinea.hasNextLine()) {
                String dato = scLinea.nextLine();
                partidos.add(stringToPartido(dato));
            }
        } 
    }

    public Map<Partido, Integer> generaResultados(CriterioSeleccion cs, int numEsc) {
        return cs.ejecuta(partidos, numEsc);
    }

    public void presentaResultados(String nombreFichero, Map<Partido, Integer> map) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(nombreFichero)) {
            this.presentaResultados(pw, map);
        }
    }

    public void presentaResultados(PrintWriter pw, Map<Partido, Integer> map) {
        
        partidos.stream()
            .collect(Collectors.toMap(p -> p, p -> map.getOrDefault(p, 0)))
            .entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getKey().getVotos(), e1.getKey().getVotos()))
                .forEach(entry -> {
                    Integer value = entry.getValue();
                    String finalValue;
                    if (value==0) {
                        finalValue = "Sin representación";
                    } else {
                        finalValue = value.toString();
                    }     
                    pw.println(entry.getKey().toString() + ", "+finalValue);
                });
        
    }
    
}
