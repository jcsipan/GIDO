package gnf.gido.interfaces.batch.internal;


/**
 * The Class GccbStatisticsBatch.
 */
public class GidoStatisticsBatch {

	private boolean onWarning;

	private volatile long leidos = 0;

	private volatile long procesados = 0;

	private volatile long fallidos = 0;

	/**
	 * Checks if is on warning.
	 * 
	 * @return true, if is on warning
	 */
	public boolean isOnWarning() {
		return onWarning;
	}

	/**
	 * Sets the on warning.
	 * 
	 * @param onWarning the new on warning
	 */
	public void setOnWarning(final boolean onWarning) {
		this.onWarning = onWarning;
	}

	/**
	 * Adds the leidos.
	 */
	public synchronized void addLeidos() {
		leidos++;
	}

	/**
	 * Adds the procesados.
	 */
	public synchronized void addProcesados() {
		procesados++;
	}

	/**
	 * Adds the fallidos.
	 */
	public synchronized void addFallidos() {
		fallidos++;
	}

	/**
	 * Gets the leidos.
	 * 
	 * @return the leidos
	 */
	public long getLeidos() {
		return leidos;
	}

	/**
	 * Gets the procesados.
	 * 
	 * @return the procesados
	 */
	public long getProcesados() {
		return procesados;
	}

	/**
	 * Gets the fallidos.
	 * 
	 * @return the fallidos
	 */
	public long getFallidos() {
		return fallidos;
	}
}
