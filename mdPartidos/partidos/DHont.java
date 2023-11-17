package org.uma.mbd.mdPartidos.partidos;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DHont extends DHontSimple{

    private double minPor;

    public DHont(double mp) {
        if (mp < 0 || mp >= 15)
            throw new EleccionesException("El mínimo porcentaje admisible debe estar entre 0 (incluido) y 15 (excluido)");
        minPor = mp;
    }

    @Override
    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc) {

        int totalVotos = partidos.stream().mapToInt(p -> p.getVotos()).sum();
        List<Partido> partidosFiltrados = partidos.stream().filter(p -> (p.getVotos()*100/totalVotos) >= minPor).toList();

        return super.ejecuta(partidosFiltrados, numEsc);
    }
    
}
