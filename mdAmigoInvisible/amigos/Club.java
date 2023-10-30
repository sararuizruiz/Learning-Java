package org.uma.mbd.mdAmigoInvisible.amigos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class Club {

    protected List<Persona> socios;

    public Club() {
        socios = new ArrayList<>();
    }

    public void lee(String fEntrada, String delim) throws IOException {
        Path path = Path.of(fEntrada);
        try (Scanner scLinea = new Scanner(path)) {
            while (scLinea.hasNextLine()) {
                String linea = scLinea.nextLine();
                leeSocios(linea, delim);
            }
        }
    }

    private void leeSocios(String linea, String delim) {
        try (Scanner scDato = new Scanner(linea)) {
            scDato.useDelimiter(delim);
            while(scDato.hasNext()) {
                String socio = scDato.next();
                creaSocioDesdeString(socio);
            }
        }
    }

    protected void creaSocioDesdeString(String socio) {
        socios.add(new Persona(socio));
    }

    protected void hacerAmigos() {
        List<Integer> posAmigos = new ArrayList<>();
        for (int i = 0; i < socios.size(); i++) {
            posAmigos.add(i);
        }
        do {
            Collections.shuffle(posAmigos);
        } while (hayCoincidencias(posAmigos));
        for(int i = 0; i < socios.size(); i++) {
            socios.get(i).setAmigo(socios.get(posAmigos.get(i)));
        }
    }

    private static boolean hayCoincidencias(List<Integer> lista) {
        return lista.stream().anyMatch(num -> lista.indexOf(num) == num);
    }

    public void presentaAmigos(String fSalida) throws FileNotFoundException {
        try (PrintWriter pw = new PrintWriter(fSalida)) {
            this.presentaAmigos(pw);
        }
    }

    public void presentaAmigos(PrintWriter pw) {
        Collections.sort(socios);
        for (Persona socio : socios) {
            pw.println(socio);   
        }
    }
    
}
