package org.uma.mbd.mdPartidos.partidos;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Token implements Comparable<Token> {

    private Partido partido;
    private double ratio;

    public Token(Partido partido, double ratio) {
        this.partido = partido;
        this.ratio = ratio;
    }

    public Partido getPartido() {
        return this.partido;
    }

    public double getRatio() {
        return this.ratio;
    }

    @Override
    public int compareTo(Token t) {
        int res;
        res =  Double.compare(t.ratio, this.ratio);
        if (res==0) // Doy por supuesto que queremos ordenar en caso de igualdad, por nombre de partido independientemente de mayus o minus
            res = this.partido.getNombre().toLowerCase().compareTo(t.partido.getNombre().toLowerCase());
        return res;
    }

    public static Set<Token> seleccioneTokens(Set<Token> tks, int numEsc) {
        return tks.stream().limit(numEsc).collect(Collectors.toSet());
    }

    public static Map<Partido, Integer> generaResultados(Set<Token> tks) {
        return tks.stream()
                .collect(Collectors.groupingBy(Token::getPartido, Collectors.summingInt(p -> 1)));
    }
    
}
