package org.uma.mbd.mdPartidos.partidos;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Proporcional implements CriterioSeleccion {

    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc) {

        int totalVotos = partidos.stream().mapToInt(p -> p.getVotos()).sum();
        double vpe = (double) totalVotos / numEsc;

        return partidos.stream()
            .flatMap((Partido partido) -> IntStream.range(0, numEsc).mapToObj(i -> new Token(partido, partido.getVotos() - i*vpe)))
            .sorted()
            .limit(numEsc)
            .collect(Collectors.groupingBy(Token::getPartido, Collectors.summingInt(p -> 1)));

    }
    
}
