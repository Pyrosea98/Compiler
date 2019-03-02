package traductor;

import sintaxis.UnidadCompilacion;

/**
 * Clase que realiza la traducción a enguaje Java
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class Traductor {

	private UnidadCompilacion unidadCompilacion;
	
	

	/**
	 * @param unidadCompilacion
	 */
	public Traductor(UnidadCompilacion unidadCompilacion) {
		super();
		this.unidadCompilacion = unidadCompilacion;
	}

	/**
	 * @return the unidadCompilacion
	 */
	public UnidadCompilacion getUnidadCompilacion() {
		return unidadCompilacion;
	}

	/**
	 * Método que traduce desde la unidad de compilación
	 * 
	 * @return
	 */
	public String traducir() {
		return unidadCompilacion.traducir();
	}

	/**
	 * @param unidadCompilacion
	 *            the unidadCompilacion to set
	 */
	public void setUnidadCompilacion(UnidadCompilacion unidadCompilacion) {
		this.unidadCompilacion = unidadCompilacion;
	}

}
