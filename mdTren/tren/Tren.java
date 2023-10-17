package org.uma.mbd.mdTren.tren;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Tren {
    private List<Vagon> vagones;
    private int capComun;
    // Veo necesario el guardar capComun como var de instancia, pues si no, si nos encontramos ante un tren con 0 vagones
    // en algún momento, no podré acceder al num capComún para crear un vagón nuevo de capacidad adecuada.

    public Tren(int nVagones, int capComun) {
        this.vagones = new ArrayList<>();
        this.capComun = capComun;
        for (int i=0; i < nVagones; i++) {
            this.vagones.add(new Vagon(capComun));
        }
    }

    public void carga(int ton) {
        int pos = 0;
        while (ton > 0) {
            if (pos == vagones.size())
                vagones.add(new Vagon(capComun));
            ton = vagones.get(pos).carga(ton);
            pos++;
        }
    }

    public void gasta(int ton) {
        int pos = 0;
        while (ton > 0 && pos < vagones.size()) {
            ton = vagones.get(pos).descarga(ton);
            pos++;
        }
        if (ton > 0) 
            throw new IllegalArgumentException("El tren no posee las toneladas de carbón necesarias para realizar el trayecto.");
    }

    public void optimiza() {
        vagones = vagones.stream()
            .filter((Vagon vg) -> vg.getCarga() != 0)
            .collect(Collectors.toList());
    }

    
    @Override
    public String toString() {
        return "Tren" + vagones;
    }
}
