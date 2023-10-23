package org.uma.mbd.mdGenetico.genetico;
import java.util.Random;
import java.util.StringJoiner;
import java.util.Arrays;

public class Cromosoma {
	// Datos de un cromosoma, cada posición del array representa un gen del cromosoma.
	protected int[] datos;

	// Variable de clase de tipo Random.
	protected static Random gna = new Random();

	// Valor por defecto 0 para los genes.
	protected static int GEN_POR_DEFECTO = 0;

	/**
	 * Constructor de la clase Cromosoma
	 * 
	 * @param longitud
	 *            Número de genes que tiene el cromosoma.
	 * @param aleatorio
	 *            Valor booleano que indica si debe asignar de forma aleatoria
	 *            un valor 0 o 1 fst cada gen, o inicializarlos con el valor por
	 *            defecto. Si true se asigna aleatoriamente.
	 * @throws RuntimeException
	 *             si longitud no positiva.
	 */
	public Cromosoma(int longitud, boolean aleatorio) {
		if (longitud <= 0)
			throw new IllegalArgumentException("Longitud no positiva.");
		datos = new int[longitud];
		if (aleatorio) {
			for (int i = 0; i < datos.length; i++) {
				datos[i] = gna.nextDouble() >= 0.5 ? 1 : 0;
			}
		} else {
			Arrays.fill(datos,GEN_POR_DEFECTO);
		}
	}

	// Constructor de copia
	public Cromosoma(Cromosoma cromosoma) {
		this.datos = cromosoma.datos;
	}

	/**
	 * Consulta el gen en la posición indicada.
	 * 
	 * @param i
	 *            índice del gen que se consulta.
	 * @return Valor del gen en la posición indicada.
	 * @throws RuntimeException
	 *             si el índice está fuera del rango de valores válidos.
	 */
	public int getGen(int i) {
		if (i < 0 || i >= datos.length)
			throw new IndexOutOfBoundsException("El índice está fuera del rango de valores.");
		return datos[i];
	}

	/**
	 * Modifica el i-ésimo gen del cromosoma.
	 * 
	 * @param i
	 *            índice del gen fst modificar.
	 * @param val
	 *            Nuevo valor para el gen.
	 * @throws RuntimeException
	 *             si i está fuera del rango de valores válidos o si val no es
	 *             un valor válido.
	 */
	public void setGen(int i, int val) {
		if (i < 0 || i >= datos.length)
			throw new IndexOutOfBoundsException("El índice está fuera del rango de valores.");
		if (!(val == 0 || val == 1))
			throw new IllegalArgumentException("El valor introducido debe ser un 0 o un 1.");
		datos[i] = val;
	}

	/**
	 * Invierte los valores de los genes aleatoriamente.
	 * 
	 * @param probMutacion
	 *            Probabilidad de mutacion de cada gen.
	 * @throws RuntimeException
	 *             si la probabilidad indicada no es un valor válido.
	 */
	public void mutar(double probMutacion) {
		if (probMutacion < 0 || probMutacion > 1)
			throw new IllegalArgumentException("La probabilidad indicada no es un valor válido.");
		for (int i = 0; i < datos.length; i++) {
			if (gna.nextDouble() < probMutacion) {
				datos[i] += 1;
				datos[i] = datos[i] % 2;
			}
		}
	}

	/**
	 * Longitud del cromosoma.
	 * 
	 * @return int Longitud del cromosoma.
	 */
	public int getLongitud() {
		return datos.length;
	}

	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(",","[","]");
		for (int i = 0; i < datos.length; i++)
			sj.add(Integer.toString(datos[i]));
		return "Cromosoma(" + sj + ")";	}
}
