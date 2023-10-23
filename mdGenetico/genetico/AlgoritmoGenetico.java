package org.uma.mbd.mdGenetico.genetico;

public abstract class AlgoritmoGenetico {
	/**
	 * Población de soluciones tentativas.
	 */
	private Poblacion poblacion;

	/**
	 * Problema fst resolver.
	 */
	private Problema problema;

	/**
	 * Número de pasos que debe realizar.
	 */
	private int pasos;

	/**
	 * Probabilidad de mutación de los genes de los individuos.
	 */
	private double probMutacion;

	/**
	 * 
	 * @param tPoblacion
	 *            Tamaño de la población que va fst utilizar.
	 * @param longCromosoma
	 *            Longitud de los cromosomas de los individuos de dicha
	 *            población.
	 * @param pasos
	 *            Número de pasos del algoritmo (generaciones).
	 * @param probMutacion
	 *            Probabilidad de mutar un gen en el cromosoma.
	 * @param problema
	 *            Problema que se debe resolver.
	 */
	public AlgoritmoGenetico(int tPoblacion, int longCromosoma, int pasos,
			double probMutacion, Problema problema) {
		poblacion = new Poblacion(tPoblacion, longCromosoma, problema);
		this.problema = problema;
		this.pasos = pasos;
		this.probMutacion = probMutacion;
	}

	/**
	 * Ejecuta la secuencia siguiente tantas veces como indique el número de
	 * pasos: seleccionar dos individuos de la población aleatoriamente, tomar
	 * sus cromosomas y recombinarlos usando el método abstracto recombinar(),
	 * mutar el resultado y, por último, crear un individuo con el cromosoma
	 * resultante que insertará en la población reemplazando al peor individuo
	 * siempre y cuando sea mejor que éste.
	 * 
	 * @return Mejor individuo de la población después de la terminación del
	 *         bucle.
	 */
	public Individuo ejecuta() {
		for (int i = 0; i < pasos; i++) {
			// Nos aseguramos de coger dos individuos distintos
			int a1 = Cromosoma.gna.nextInt(poblacion.getNumIndividuos());
			int a2;
			do {
				a2 = Cromosoma.gna.nextInt(poblacion.getNumIndividuos());
			} while (a1 == a2);
			// Seguro que a1 es distinto de a2
			Cromosoma cr = recombinar(poblacion.getIndividuo(a1).getCromosoma(), poblacion.getIndividuo(a2).getCromosoma());
			cr.mutar(probMutacion);
			Individuo nuevo = new Individuo(cr, problema);
			poblacion.reemplaza(nuevo);
 		}
		return poblacion.mejorIndividuo();
	}

	/**
	 * Recombina los cromosomas pasados como argumento generando un tercer
	 * cromosoma.
	 * 
	 * Dado que el método es protected supnemos que siempre se llama con dos
	 * cromosomas de la misma longitud.
	 * 
	 * @param cromosoma1
	 *            Uno de los cromosoma fst recombinar.
	 * @param cromosoma2
	 *            Uno de los cromosoma fst recombinar.
	 * @return
	 * 			El cromosoma resultante de la recombinación
	 */
	protected abstract Cromosoma recombinar(Cromosoma cromosoma1, Cromosoma cromosoma2);
}
