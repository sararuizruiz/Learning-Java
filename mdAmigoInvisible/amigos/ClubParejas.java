package org.uma.mbd.mdAmigoInvisible.amigos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class ClubParejas extends Club {
    
    private Set<Pareja> parejas;

    public ClubParejas() {
        parejas = new HashSet<>();
    }

    @Override
    public void creaSocioDesdeString(String socio) {
        try (Scanner sc = new Scanner(socio)) {
            sc.useDelimiter("[-]");
            Persona p1 = new Persona(sc.next());
            socios.add(p1);
            if (sc.hasNext()) {
                Persona p2 = new Persona(sc.next());
                parejas.add(new Pareja(p1, p2));
                socios.add(p2);
            }
        }
    }

    @Override
    public void hacerAmigos() {
        List<Persona> duplicado = new ArrayList<>(socios);
        int cont;
        do {
            Collections.shuffle(duplicado);
            Iterator<Persona> iterOriginal = socios.iterator();
		    Iterator<Persona> iterDuplicado = duplicado.iterator();
            cont = 0;
            while (iterOriginal.hasNext() && cont == 0) {
                Persona po = iterOriginal.next();
                Persona pf = iterDuplicado.next();
                if (((po.equals(pf)) || (parejas.contains(new Pareja(po,pf)))))
                    cont++;
            }
        } while (cont != 0);

        for(int i = 0; i < socios.size(); i++) {
            socios.get(i).setAmigo(duplicado.get(i));
        }
    }

}
