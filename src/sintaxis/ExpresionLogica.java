package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Clase que representa la expresion logica
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */

public class ExpresionLogica extends Expresion {

	private ExpresionRelacional expresionRelacional;
	private ExpresionLogica expresionLogica;

	/**
	 * Constructor que crea expresion logica con solo una expresion relacional
	 * 
	 * @param expresionRelacional
	 */
	public ExpresionLogica(ExpresionRelacional expresionRelacional) {
		super();
		this.expresionRelacional = expresionRelacional;
	}

	/**
	 * Constructor que crea expresion logica con caso contrario
	 * 
	 * @param expresionRelacional
	 * @param operadorLogico
	 * @param expresionLogica
	 */
	public ExpresionLogica(ExpresionRelacional expresionRelacional, ExpresionLogica expresionLogica) {
		super();
		this.expresionRelacional = expresionRelacional;
		this.expresionLogica = expresionLogica;
	}

	/**
	 * Metodo del arbol grafico
	 */
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Expresion Logica");

		nodo.add(expresionRelacional.getArbolVisual());
		if (expresionLogica != null) {
			nodo.add(expresionLogica.getArbolVisual(nodo));
		}

		return nodo;
	}

	public DefaultMutableTreeNode getArbolVisual(DefaultMutableTreeNode nodo) {

		nodo.add(expresionRelacional.getArbolVisual());
		if (expresionLogica != null) {
			nodo.add(expresionLogica.getArbolVisual(nodo));
		}

		return nodo;
	}
}