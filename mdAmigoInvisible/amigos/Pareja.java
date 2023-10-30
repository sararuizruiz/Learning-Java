package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.Objects;

public record Pareja(Persona uno, Persona otro) {

    @Override
    public boolean equals (Object obj) {
        return obj instanceof Pareja p
            && ((uno==p.uno && otro==p.otro) || (uno==p.otro && otro==p.uno));
    }

    @Override
    public int hashCode() {
        return Objects.hash(uno, otro);
    }
}
