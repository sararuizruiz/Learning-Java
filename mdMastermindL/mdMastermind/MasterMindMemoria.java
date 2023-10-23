package org.uma.mbd.mdMastermindL.mdMastermind;

import java.util.ArrayList;
import java.util.List;

public class MasterMindMemoria extends MasterMind {
    private List<Movimiento> movimientos;

    public MasterMindMemoria() {
        movimientos = new ArrayList<>();
    }

    public MasterMindMemoria(String comb) {
        super(comb);
        movimientos = new ArrayList<>();
    }

    public MasterMindMemoria(int tamano) {
        super(tamano);
        movimientos = new ArrayList<>();
    }

    @Override
    public Movimiento intento(String cifras) {
        int pos = 0;
        while (pos < movimientos.size() && !movimientos.get(pos).intento().equals(cifras))
            pos++;
        if (pos < movimientos.size())
            throw new MasterMindException("Combinación repetida");
        Movimiento inten = super.intento(cifras);
        movimientos.add(inten);
        return inten;
    }

    public List<Movimiento> movimientos() {
        return movimientos;
    }
}
