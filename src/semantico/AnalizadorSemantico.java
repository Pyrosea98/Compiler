package semantico;

import java.util.ArrayList;

import sintaxis.UnidadCompilacion;

/**
 * Clase que realiza el análisis semántico
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class AnalizadorSemantico {
	
	private UnidadCompilacion unidadCompilacion;
	private TablaSimbolos ts;
	private ArrayList<String> errores;
	/**
	 * @param unidadCompilacion
	 * @param ts
	 * @param errores
	 */
	public AnalizadorSemantico(UnidadCompilacion unidadCompilacion, TablaSimbolos ts, ArrayList<String> errores) {
		super();
		this.unidadCompilacion = unidadCompilacion;
		this.errores = errores;
		this.ts = new TablaSimbolos(this.errores);
	}
	
	public void llenarTablaSimbolos() {
		unidadCompilacion.llenarTablaSimbolos(ts);
	}
	
	public void analizarSemantica() {
		unidadCompilacion.analizarSemantica(ts, errores);
	}

	/**
	 * @return the unidadCompilacion
	 */
	public UnidadCompilacion getUnidadCompilacion() {
		return unidadCompilacion;
	}

	/**
	 * @param unidadCompilacion the unidadCompilacion to set
	 */
	public void setUnidadCompilacion(UnidadCompilacion unidadCompilacion) {
		this.unidadCompilacion = unidadCompilacion;
	}

	/**
	 * @return the ts
	 */
	public TablaSimbolos getTs() {
		return ts;
	}

	/**
	 * @param ts the ts to set
	 */
	public void setTs(TablaSimbolos ts) {
		this.ts = ts;
	}

	/**
	 * @return the errores
	 */
	public ArrayList<String> getErrores() {
		return errores;
	}

	/**
	 * @param errores the errores to set
	 */
	public void setErrores(ArrayList<String> errores) {
		this.errores = errores;
	}
	
	

}
