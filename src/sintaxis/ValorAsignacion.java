package sintaxis;

import lexico.Token;

public class ValorAsignacion {
	
	/**
	 * Clase que representa el valor de asignacion
	 * 
	 * @author Daniel Beltran Gomez
	 * @author Tatiana Salazar
	 * @author Juan Jose alvarez
	 *
	 */
	
	private Token tipoDato;

	public ValorAsignacion(Token tipoDato) {
		super();
		this.tipoDato = tipoDato;
	}

	@Override
	public String toString() {
		return "ValorAsignacion [tipoDato=" + tipoDato + "]";
	}
}
