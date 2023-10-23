package org.uma.mbd.mdGenetico.genetico;

import java.util.Arrays;

public class CeroMax implements Problema {

	/**
	 * El fitness de un individuo es el número de ceros que tiene el cromosoma.
	 * @see Problema#evalua(Cromosoma)
	 */
	public double evalua(Cromosoma cromosoma) {
		return cromosoma.datos.length - Arrays.stream(cromosoma.datos).sum();
	}
}
