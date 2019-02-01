package sintaxis;

import java.util.ArrayList;

import lexico.Token;

public class LlamadoFuncion {
	
	/**
	 * Clase que representa el llamado a una funcion
	 * 
	 * @author Daniel Beltran Gomez
	 * @author Tatiana Salazar
	 * @author Juan Jose alvarez
	 *
	 */
	
	private Token identificadorFuncion;
	private Token parentesisIzquierdo;
	private ArrayList<Termino> listaArgumentos;
	private Token parentesisDerecho;
	
	/**
	 * Constructor que declara un llamado a funcion
	 * @param identificadorFuncion
	 * @param parentesisIzquierdo
	 * @param listaArgumentos
	 * @param parentesisDerecho
	 */
	public LlamadoFuncion(Token identificadorFuncion, Token parentesisIzquierdo, ArrayList<Termino> listaArgumentos,
			Token parentesisDerecho) {
		super();
		this.identificadorFuncion = identificadorFuncion;
		this.parentesisIzquierdo = parentesisIzquierdo;
		this.listaArgumentos = listaArgumentos;
		this.parentesisDerecho = parentesisDerecho;
	}

	@Override
	public String toString() {
		return "LlamadoFuncion [identificadorFuncion=" + identificadorFuncion + ", parentesisIzquierdo="
				+ parentesisIzquierdo + ", listaArgumentos=" + listaArgumentos + ", parentesisDerecho="
				+ parentesisDerecho + "]";
	}
}
