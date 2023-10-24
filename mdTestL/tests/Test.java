package org.uma.mbd.mdTestL.tests;

import java.util.Objects;

public record Test(String alumno, int aciertos, int errores) {

    public double calificacion(double valAc, double valErr) {
        return aciertos*valAc + errores*valErr;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Test test
            && this.alumno.equalsIgnoreCase(test.alumno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alumno.toLowerCase());
    }
    
}
