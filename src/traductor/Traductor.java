package traductor;

import java.io.File;

import sintaxis.UnidadCompilacion;

/**
 * Clase que realiza la traducci�n a enguaje Java
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class Traductor {
	
	private UnidadCompilacion unidadCompilacion;

	/**
	 * @return the unidadCompilacion
	 */
	public UnidadCompilacion getUnidadCompilacion() {
		return unidadCompilacion;
	}
	
	/**
	 * M�todo que traduce desde la unidad de compilaci�n
	 * @return
	 */
	public String traducir() {
		File f = new File("src/bin/Principal.java");
		
		return unidadCompilacion.traducir();
	}

	/**
	 * @param unidadCompilacion the unidadCompilacion to set
	 */
	public void setUnidadCompilacion(UnidadCompilacion unidadCompilacion) {
		this.unidadCompilacion = unidadCompilacion;
	}

}
