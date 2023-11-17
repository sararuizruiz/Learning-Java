package org.uma.mbd.mdPartidos.partidos;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DHontSimple implements CriterioSeleccion {

    public Map<Partido, Integer> ejecuta(List<Partido> partidos, int numEsc) {
        
        return partidos.stream()
            .flatMap((Partido partido) -> IntStream.range(1, numEsc + 1).mapToObj(i -> new Token(partido, partido.getVotos() / i )))
            .sorted()
            .limit(numEsc)
            .collect(Collectors.groupingBy(Token::getPartido, Collectors.summingInt(p -> 1)));
    }
    
}
