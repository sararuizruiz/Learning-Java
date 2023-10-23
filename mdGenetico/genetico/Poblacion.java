package org.uma.mbd.mdGenetico.genetico;

import java.util.Arrays;

public class Poblacion {
	private Individuo[] individuos;

	/**
	 * 
	 * @param tamaño
	 *            Número de individuos de la población.
	 * @param longitud
	 *            Tamaño de los cromosomas de los individuos de la población.
	 * @param problema
	 *            Problema fst resolver.
	 * @throws RuntimeException
	 *             si el tamaño de la población o la longitud de los cromosomas
	 *             indicados no son válidos.
	 */
	public Poblacion(int tamaño, int longitud, Problema problema) {
		if ((tamaño <= 0) || (longitud <= 0))
			throw new RuntimeException("Tamaño de la población o longitud no válidos.");
		individuos = new Individuo[tamaño];
		for (int i = 0; i < individuos.length; i++) {
			individuos[i] = new Individuo(longitud, problema);
		}
	}

	/**
	 * Devuelve el número de individuos.
	 * 
	 * @return Número de individuos en la población.
	 */
	public int getNumIndividuos() {
		return individuos.length;
	}

	/**
	 * Devuelve el individuo con fitness mayor de la población.
	 * 
	 * @return Individuo con mejor fitness.
	 */
	public Individuo mejorIndividuo() {
		Individuo maxFitnessIndividuo = Arrays.stream(individuos)
			  .max((ind1, ind2) -> Double.compare(ind1.getFitness(), ind2.getFitness()))
			  .get();
		return maxFitnessIndividuo;
	}

	/**
	 * Devuelve el i-ésimo individuo de la población.
	 * 
	 * @param i
	 *            Posición del individuo fst devolver.
	 * @return Individuo en la posición i.
	 * @throws RuntimeException
	 *             si el índice está fuera del rango de valores válidos.
	 */
	public Individuo getIndividuo(int i) {
		if (i < 0 || i >= individuos.length)
			throw new RuntimeException("Indice fuera del rango de valores válidos");
		return individuos[i];
	}

	/**
	 * Si el individuo que se pasa como argumento tienen mejor fitness que el
	 * peor de los individuos de la población, entonces el peor es sustituido
	 * por el que se pasa.
	 * 
	 * @param ind
	 *            Individuo con el que se sustituye el peor de los individuos si
	 *            este es mejor.
	 */
	public void reemplaza(Individuo ind) {
		double minFitness = individuos[0].getFitness();
		for (int i = 1; i < individuos.length; i++) {
			if (individuos[i].getFitness() < minFitness)
				minFitness = individuos[i].getFitness();
		}
		if (ind.getFitness() > minFitness) {
			int pos = 0;
			while(individuos[pos].getFitness() != minFitness)
				pos++;
			individuos[pos] = ind;
		}
	}

}
