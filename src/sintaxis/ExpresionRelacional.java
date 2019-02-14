package sintaxis;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Clase que representa la sentencia
 * 
 * @author Daniel Beltran Gomez
 * @author Tatiana Salazar
 * @author Juan Jose alvarez
 *
 */
public class ExpresionRelacional extends Expresion {

	private ExpresionAritmetica expAritmetica;
	private ExpresionRelacional expRelacional;

	/**
	 * Constructor con expresion aritmetica
	 * 
	 * @param expAritmetica
	 */
	public ExpresionRelacional(ExpresionAritmetica expAritmetica) {
		super();
		this.expAritmetica = expAritmetica;
	}

	/**
	 * Constructor con expresion aritmetica y operador relacional
	 * 
	 * @param expAritmetica
	 * @param opRelacional
	 * @param expRelacional
	 */
	public ExpresionRelacional(ExpresionAritmetica expAritmetica, ExpresionRelacional expRelacional) {
		super();
		this.expAritmetica = expAritmetica;
		this.expRelacional = expRelacional;
	}

	/**
	 * Constructor con parentesis izquierdo , parentesis derecho y expresion
	 * relacional
	 * 
	 * @param parentesisIzq
	 * @param parentesisDer
	 * @param expRelacional
	 */
	public ExpresionRelacional(ExpresionRelacional expRelacional) {
		super();
		this.expRelacional = expRelacional;
	}

	@Override
	public DefaultMutableTreeNode getArbolVisual() {

		DefaultMutableTreeNode nodo = new DefaultMutableTreeNode("Expresion Relacional");

		if (expAritmetica != null) {
			nodo.add(expAritmetica.getArbolVisual());
			if (expRelacional != null) {
				nodo.add(expRelacional.getArbolVisual(nodo));
			}
		} else {
			nodo.add(expRelacional.getArbolVisual(nodo));
		}
		return nodo;
	}

	private DefaultMutableTreeNode getArbolVisual(DefaultMutableTreeNode nodo) {

		if (expAritmetica != null) {
			nodo.add(expAritmetica.getArbolVisual());
			if (expRelacional != null) {
				nodo.add(expRelacional.getArbolVisual(nodo));
			}
		} else {
			nodo.add(expRelacional.getArbolVisual(nodo));
		}
		return nodo;
	}

}
